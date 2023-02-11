package com.example.app.activitys

import android.Manifest
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.app.Baseee64
import com.example.app.database.Appdatabase
import com.example.app.database.entity.FirebaseTestUser
import com.example.app.database.entity.User
import com.example.app.shredpref.PrefManagr
import com.example.weddingapp.R
import com.example.weddingapp.databinding.ActivitySignupBinding
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointBackward
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.*

class SignupActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var binding: ActivitySignupBinding
    lateinit var db: Appdatabase
    private lateinit var mAuth: FirebaseAuth
    lateinit var databaseReference: DatabaseReference

    lateinit var imageUtil: Baseee64

    var store: String? = null

    private val REGEX = ("^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$")


    val galleryContract = registerForActivityResult(ActivityResultContracts.GetContent()) {
        it.let {
            store = binding.ivProfileIcon.setImageURI(it).toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Appdatabase.getDatabase(this)


        databaseReference = FirebaseDatabase.getInstance().getReference()
        initView()
        setClick()

        mAuth = FirebaseAuth.getInstance()

        imageUtil = Baseee64()

        binding.btnSignIn.setOnClickListener {

            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.ivProfileIcon.setOnClickListener {

            showOptionDialog()
        }
        binding.btnRegister.setOnClickListener {

            var name = binding.etName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var password = binding.etPassword.text.toString().trim()
            var contact = binding.etNumber.text.toString().trim()
            var birthdate = binding.etDate.text.toString().trim()
            var city = binding.etCity.text.toString().trim()


            var prefManagr = PrefManagr(this)

            if (name.isEmpty()) {
                binding.tvName.error = "Enter your name"
            } else if (!isValidEmail(email)) {
                binding.tvEmail.error = "Enter your email"
            } else if (!isValidPassword(password)) {
                binding.tvPassword.error = "Enter your password"
            } else if (!isValidContact(contact)) {
                binding.tvNumber.error = "Enter your contact"
            } else if (birthdate.isEmpty()) {
                binding.tvDate.error = "Enter your birthdate"
            } else if (city.isEmpty()) {
                binding.tvCity.error = "Enter your city name"
            } else if (store.isNullOrEmpty()) {
                Toast.makeText(this, "please select image", Toast.LENGTH_SHORT).show()
            } else {
                val user = User(
                    name = name,
                    email = email,
                    password = password,
                    image = store,
                    number = contact,
                    date = birthdate,
                    city = city
                )

                if (db.userDao.selectUser(user.email) != null) {
                    binding.tvEmail.error = "Already email exists"
                } else {
                    db.userDao.insertRecord(user)
                    mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                addUserToDatabase(email, name, mAuth.currentUser?.uid ?: "")
                                Toast.makeText(this, "Register Successfully", Toast.LENGTH_SHORT)
                                    .show()
                                prefManagr.saveUser(user)
                                startActivity(Intent(this, LoginActivity::class.java))
                            } else {
                                Toast.makeText(
                                    baseContext, "Authentication failed.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }
            }
        }
    }


    private fun addUserToDatabase(email: String, name: String, uid: String) {


        databaseReference = FirebaseDatabase.getInstance().getReference("user_table")
        databaseReference.child(uid).setValue(FirebaseTestUser(email = email, name = name, uId = uid))

    }

    private fun setClick() {
        binding.etDate.setOnClickListener(this)
    }

    fun initView() {

    }

    private fun pickdob() {
        val constraintsBuilderRange =
            CalendarConstraints.Builder().setValidator(DateValidatorPointBackward.now())
        MaterialDatePicker.Builder.datePicker().setTitleText(getString(R.string._select_date))
        val datePickerDialog = MaterialDatePicker.Builder.datePicker()
            .setCalendarConstraints(constraintsBuilderRange.build()).build()
        datePickerDialog.show(supportFragmentManager, "MATERIAL_DATE_PICKER")

        datePickerDialog.addOnPositiveButtonClickListener {
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val date = sdf.format(it)
            binding.etDate.setText(date)
        }
    }

    private fun isValidContact(contact: String): Boolean {
        return contact.length == 10
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        return password.length == 10
    }


    override fun onClick(p0: View?) {
        when (p0) {
            binding.etDate -> pickdob()

        }
    }


    private fun showOptionDialog() {

        val items = arrayOf("From Gallery", "From Camera")

        AlertDialog.Builder(this)
            .setTitle("Select option")
            .setItems(items, DialogInterface.OnClickListener { dialogInterface, i ->

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


            }).show()
    }

    private fun pickImageFromCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, 200)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if (requestCode == 200) {
            data?.let {


                store = imageUtil.bitmapToBase64(data.extras!!.get("data") as Bitmap)
                val bitmap = store?.let { it1 -> imageUtil.base64ToBitmap(it1) }
                binding.ivProfileIcon.setImageBitmap(bitmap)
            }
        }
    }


    private fun checkCameraPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }


}