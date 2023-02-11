package com.gautam.validatonformgrewon

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Paint
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.gautam.validatonformgrewon.base64.BaseImage
import com.gautam.validatonformgrewon.databinding.ActivitySingupBinding
import com.gautam.validatonformgrewon.entiy.AppDataBase
import com.gautam.validatonformgrewon.modal.Users
import com.gautam.validatonformgrewon.utils.Utils
import java.io.FileDescriptor
import java.io.IOException

open class SignupActivity : AppCompatActivity() {

    lateinit var binding: ActivitySingupBinding
    lateinit var db: AppDataBase
    var store: String? = null

    private val galleryContract = registerForActivityResult(ActivityResultContracts.GetContent()) {
        it?.let {
            binding.upImage.setImageURI(it)
            uriToBitmap(it)?.let {
                store = BaseImage.bitmapToBase64(it)
                binding.upImage.setImageBitmap(it)
            }
        }
    }


    private fun uriToBitmap(selectedFileUri: Uri): Bitmap? {
        try {
            val parcelFileDescriptor = contentResolver.openFileDescriptor(selectedFileUri, "r")
            val fileDescriptor: FileDescriptor = parcelFileDescriptor!!.fileDescriptor
            val image = BitmapFactory.decodeFileDescriptor(fileDescriptor)
            parcelFileDescriptor.close()
            return image
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }

    private val cameraContract =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            it.let {
                it?.data.let {
                    store = BaseImage.bitmapToBase64(it?.extras!!["data"] as Bitmap)
                    binding.upImage.setImageBitmap(it.extras!!["data"] as Bitmap)
                }
            }
        }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rdAlrediyaccount.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        val items = listOf("Male", "Female", "Other")
        val gender = ArrayAdapter(this, R.layout.list_ofiteamlistdropmenu, items)
        binding.dropDownfiled.setAdapter(gender)

        db = AppDataBase.getInstance(this)

        binding.rdAlrediyaccount.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        binding.upImage.setOnClickListener {
            showOptionDialog()
        }

        binding.btSingup.setOnClickListener {
            val name = binding.tvSname.text.toString().trim()
            val email = binding.edSetemail.text.toString().trim()
            val password = binding.edSpassworld.text.toString().trim()
            val cPassword = binding.etSconpasssworld.text.toString().trim()
            val gender = binding.dropDownfiled.text.toString().trim()

            validationForm(name, email, password, cPassword, gender)
        }
    }

    private fun showOptionDialog() {
        val items = arrayOf("From Gallery", "From Camera")

        AlertDialog.Builder(this).setTitle("Select option").setItems(items) { dialogInterface, i ->

            when (i) {
                0 -> {
                    // Caller
                    galleryContract.launch("image/*")
                }

                1 -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (checkCameraPermission()) {
                            pickImageFromCamera()
                        } else {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                requestPermissions(arrayOf(Manifest.permission.CAMERA), 100)
                            }
                        }
                    } else {
                        pickImageFromCamera()
                    }
                }
            }
        }.show()
    }

    private fun pickImageFromCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraContract.launch(cameraIntent)
    }

    private fun checkCameraPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun validationForm(
        name: String,
        email: String,
        password: String,
        cPassword: String,
        gender: String
    ) {
        resetFocus()
        if (name.isEmpty()) {
            binding.tvSname.error = getString(R.string.Enter_name)
            /* getString(R.string.enter_your_name)*/
            binding.tvSname.requestFocus()
        } else if (email.isEmpty()) {
            binding.edSetemail.error = getString(R.string.Enter_email)
            binding.edSetemail.requestFocus()
        } else if (!Utils.isValidEmail(email)) {
            binding.edSetemail.error = getString(R.string.enter_valid_format_email)
            binding.edSetemail.requestFocus()
        } else if (db.userDao().getEmail(email) != null) {
            binding.edSetemail.error = getString(R.string.Already_register_email)
            binding.edSetemail.requestFocus()
        } else if (password.isEmpty()) {
            /* val options = ActivityOptions.makeSceneTransitionAnimation(requireActivity())
             options.toBundle()//in startactivityh*/
            binding.edSpassworld.error = getString(R.string.create_password)
            binding.edSpassworld.requestFocus()
        } else if (!Utils.isValidpassword(password)) {
            binding.edSpassworld.error = getString(R.string.uppercase_with_lower_case)
            binding.edSpassworld.requestFocus()
        } else if (cPassword.isEmpty()) {
            binding.etSconpasssworld.error = getString(R.string.Enter_same_password)
            binding.etSconpasssworld.requestFocus()
        } else if (cPassword != password) {
            binding.etSconpasssworld.error = getString(R.string.uppercase_with_lower_case)
            binding.etSconpasssworld.requestFocus()
        } else if (store.isNullOrEmpty()) {
            Toast.makeText(this, getString(R.string.please_select_image), Toast.LENGTH_SHORT).show()
        } else if (gender.isNullOrEmpty()) {
            binding.dropDownfiled.error = getString(R.string.Select_your_gender)
            binding.dropDownfiled.requestFocus()
        } else {
            insertRecourd(name, email, password, cPassword, gender)
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, getString(R.string.Registration_Successfully), Toast.LENGTH_SHORT)
                .show()
            finish()
        }
    }

    private fun insertRecourd(
        name: String,
        email: String,
        password: String,
        cpassworld: String,
        gender: String
    ) {
        val user = Users(
            name = name,
            email = email,
            passworld = password,
            image = store,
            gender = gender,
            conformpassworld = cpassworld

        )
        db.userDao().insertRecord(user)
    }

    private fun resetFocus() {
        binding.tvSname.clearFocus()
        binding.edSetemail.clearFocus()
        binding.edSpassworld.clearFocus()
        binding.edSpassworld.clearFocus()
        binding.etSconpasssworld.clearFocus()
        binding.dropDownfiled.clearFocus()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                pickImageFromCamera()
            }
        }
    }
}
