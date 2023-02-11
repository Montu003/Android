package com.gautam.validatonformgrewon

import android.Manifest.permission.RECEIVE_SMS
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.gautam.validatonformgrewon.databinding.ActivityPhoneSmsBinding
import com.gautam.validatonformgrewon.entiy.AppDataBase
import com.gautam.validatonformgrewon.shareprefrence.PrefManager
import com.gautam.validatonformgrewon.utils.Utils
import com.google.firebase.auth.FirebaseAuth
import com.hbb20.CountryCodePicker.OnCountryChangeListener


class PhoneSmsActivity : AppCompatActivity() {

    lateinit var binding: ActivityPhoneSmsBinding
    var number: String = ""
    lateinit var db: AppDataBase
    lateinit var auth: FirebaseAuth
    private var countryCode: Int = +91
    lateinit var prefManager: PrefManager
    private val MY_PERMISSIONS_REQUEST_SEND_SMS = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhoneSmsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefManager = PrefManager(this)
        auth = FirebaseAuth.getInstance()
        setonclick()
        db = AppDataBase.getInstance(this)

        checkForSmsPermission()



        binding.countryCodePicker.setOnCountryChangeListener(OnCountryChangeListener {
            countryCode = binding.countryCodePicker.selectedCountryCodeWithPlus.toInt()
        })




        binding.btSendotp.setOnClickListener {
            openOtpDailog()
            var number = binding.edEnternumber.text.toString().trim()
            // var user = Users(googlefacebook = number)
            if (!Utils.isValidPhone(number)) {
                Toast.makeText(this, "Enter 10 character phone number", Toast.LENGTH_SHORT).show()
            } else {

                //         prefManager.saveLoginCredentials(user)
                val intent = Intent(this, OtpActivity::class.java)
                //    db.userDao().insertRecord(user)
                intent.putExtra("number", "+$countryCode$number")
                Log.e("number", "onCreate: " + number)
                startActivity(intent)
            }
        }
    }

    private fun openOtpDailog() {

    }


    private fun checkForSmsPermission() {
        if (ActivityCompat.checkSelfPermission(
                this,
                RECEIVE_SMS

            ) !=
            PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this, arrayOf(RECEIVE_SMS),
                MY_PERMISSIONS_REQUEST_SEND_SMS
            )
        } else {
            // Permission already granted. Enable the SMS button.
            enableSmsButton()
        }
    }

    private fun enableSmsButton() {
        val smsButton = binding.btSendotp as ImageButton
        smsButton.visibility = View.VISIBLE
    }

    private fun disableSmsButton() {
        Toast.makeText(this, "SMS usage disabled", Toast.LENGTH_LONG).show()
        val smsButton = binding.btSendotp as ImageButton
        smsButton.visibility = View.INVISIBLE
        val retryButton: Button = binding.btSendotp as Button
        retryButton.setVisibility(View.VISIBLE)
    }


//number = "+91$number"

    private fun setonclick() {
        binding.btBack.setOnClickListener {
            var i = Intent(this, LoginActivity::class.java)
            startActivity(i)
            finish()
        }
    }


}

