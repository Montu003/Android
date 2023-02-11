package com.example.vegi.activity

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.vegi.R
import com.example.vegi.databinding.ActivityFormfieldBinding
import com.example.vegi.model.MyDelivery

class formfield : AppCompatActivity() {

    private lateinit var binding: ActivityFormfieldBinding
    lateinit var adapter: ArrayAdapter<String>
    private var ischecked = false
    val cities = arrayOf("surat","Bhavngar","Ramadhari","Navasari","Bilimora","Rajkot","Dubai","Varacha","Dhanlaxmi")
    val area = arrayOf("Yogichowk","Dhanlaxmi","Mota Varacha","Sita nagar","laxman nagar ","Varacha")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_formfield)

        binding.btnImage.setOnClickListener {
            onBackPressed()
        }

        binding.ivHome.setOnClickListener {

            binding.ivHome.setBackgroundTintList(this.getResources().getColorStateList(R.color.orange))
            binding.tvHome.setTextColor(this.getResources().getColorStateList(R.color.white))
            binding.tvHom.setColorFilter(ContextCompat.getColor( this,android.R.color.white))
            binding.ivWork.setBackgroundTintList(this.getResources().getColorStateList(R.color.gray))
            binding.tvWork.setTextColor(this.getResources().getColorStateList(R.color.black))
            binding.tvWor.setColorFilter(ContextCompat.getColor( this,android.R.color.black))
            binding.ivOther.setBackgroundTintList(this.getResources().getColorStateList(R.color.gray))
            binding.tvOther.setTextColor(this.getResources().getColorStateList(R.color.black))
        }

        binding.ivWork.setOnClickListener {

            binding.ivWork.setBackgroundTintList(this.getResources().getColorStateList(R.color.orange))
            binding.tvWork.setTextColor(this.getResources().getColorStateList(R.color.white))
            binding.tvWor.setColorFilter(ContextCompat.getColor( this,android.R.color.white))
            binding.ivHome.setBackgroundTintList(this.getResources().getColorStateList(R.color.gray))
            binding.tvHome.setTextColor(this.getResources().getColorStateList(R.color.black))
            binding.tvHom.setColorFilter(ContextCompat.getColor( this,android.R.color.black))
            binding.ivOther.setBackgroundTintList(this.getResources().getColorStateList(R.color.gray))
            binding.tvOther.setTextColor(this.getResources().getColorStateList(R.color.black))
        }

        binding.ivOther.setOnClickListener {

            binding.ivOther.setBackgroundTintList(this.getResources().getColorStateList(R.color.orange))
            binding.tvOther.setTextColor(this.getResources().getColorStateList(R.color.white))
            binding.ivHome.setBackgroundTintList(this.getResources().getColorStateList(R.color.gray))
            binding.tvHome.setTextColor(this.getResources().getColorStateList(R.color.black))
            binding.tvHom.setColorFilter(ContextCompat.getColor( this,android.R.color.black))
            binding.ivWork.setBackgroundTintList(this.getResources().getColorStateList(R.color.gray))
            binding.tvWork.setTextColor(this.getResources().getColorStateList(R.color.black))
            binding.tvWor.setColorFilter(ContextCompat.getColor( this,android.R.color.black))
        }

        var data=intent.getParcelableExtra<MyDelivery>("form")
        data.let {
            binding.ivName.setText(data?.name)
            binding.etContact.setText(data?.content)
            binding.ivAlternate.setText(data?.mobile)
            binding.ivHouse.setText(data?.address)
            binding.ivPincode.setText(data?.pincode)
        }

        adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,cities)
        binding.etCity.setAdapter(adapter)

        adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,area)
        binding.etArea.setAdapter(adapter)

        binding.btnAddress.setOnClickListener {

            var name = binding.ivName.text.toString().trim()
            var mobile = binding.etContact.text.toString().trim()
            var alternate = binding.ivAlternate.text.toString().trim()
            var house = binding.ivHouse.text.toString().trim()
            var landmark = binding.ivLandmark.text.toString().trim()
            var city = binding.etCity.text.toString().trim()
            var area = binding.etArea.text.toString().trim()
            var pincode = binding.ivPincode.text.toString().trim()
            var trem = binding.ivTram.text.toString().trim()

          //  resetFocus()

            if (name.isEmpty()){
                Toast.makeText(this, "Enter name", Toast.LENGTH_SHORT).show()
               // setError(binding.ivName,"Enter name")
            }
            else if (!isvalidcontact(mobile)){
                Toast.makeText(this, "Enter Mobile", Toast.LENGTH_SHORT).show()
             //  setError(binding.ivMobile,"enter mobile")
            }
            else if (!isvalidalternate(alternate)){
                Toast.makeText(this, "Enter Alternate mobile", Toast.LENGTH_SHORT).show()
              //  setError(binding.ivName,"Enter mobile")
            }
            else if (house.isEmpty()){
                Toast.makeText(this, "Enter House", Toast.LENGTH_SHORT).show()
              //  setError(binding.ivAlternate,"enter House")
            }
            else if (landmark.isEmpty()){
                Toast.makeText(this, "Enter Landmark", Toast.LENGTH_SHORT).show()
              //  setError(binding.ivLandmark,"enter Landmark")
            }
            else if (city.isEmpty()){
                Toast.makeText(this, "Select City", Toast.LENGTH_SHORT).show()
             //  setError(binding.ivCity,"enter City")
            }
            else if (area.isEmpty()){
                Toast.makeText(this, "Select Area", Toast.LENGTH_SHORT).show()
             //  setError(binding.ivArea,"enter Area")
            }
            else if (!isvalidpincode(pincode)){
                Toast.makeText(this, "Enter Pincode", Toast.LENGTH_SHORT).show()
              //  setError(binding.ivPincode,"enter Pincode")
            }
            else if (!ischecked) {
                Toast.makeText(this, "please check terms and conditions", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "all fields are validated", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun isvalidcontact(mobile:String):Boolean {
        return mobile.length == 10
    }
    private fun isvalidalternate(alternate:String):Boolean {
        return alternate.length == 10
    }
    private fun isvalidpincode(pincode:String):Boolean {
        return pincode.length == 6
    }
}