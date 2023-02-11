package com.example.cameraimage

import android.content.DialogInterface
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.FileProvider
import com.example.cameraimage.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var imageUri: Uri

    var galleryContract = registerForActivityResult(ActivityResultContracts.GetContent()){
        if(it!=null){
            binding.ivImage.setImageURI(it)
        }
    }

    var cameraContract = registerForActivityResult(ActivityResultContracts.TakePicture()){
        if(it){
            binding.ivImage.setImageURI(imageUri)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageUri = createImageUri()!!

        binding.ivImage.setOnClickListener {
            showOptionDialog()
        }

    }

    private fun showOptionDialog() {
        var optionArray = arrayOf("From Gallery", "From Camera")

        AlertDialog.Builder(this)
            .setTitle("Pick Image")
            .setItems(optionArray, DialogInterface.OnClickListener { dialogInterface, i ->

                if(i==0){
                    // gallery
                    galleryContract.launch("image/*")
                }else if(i==1){
                    // camera
                    cameraContract.launch(imageUri)
                }

            }).show()
    }

    private fun createImageUri(): Uri? {
        val image = File(applicationContext.filesDir, "mypicture.png")
        return FileProvider.getUriForFile(
            applicationContext,
            "com.example.cameraimage.fileProvider",
            image
        )
    }
}