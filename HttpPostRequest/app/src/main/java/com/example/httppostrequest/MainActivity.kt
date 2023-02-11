package com.example.httppostrequest

import ApiClient
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.httppostrequest.databinding.ActivityMainBinding
import com.example.httppostrequest.model.Country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadCountry()
    }

    private fun loadCountry() {

        ApiClient.init().getCountryList("Bearer ${Const.TOKEN}")
                .enqueue(object : Callback<MutableList<Country>> {
                override fun onResponse(
                    call: Call<MutableList<Country>>,
                    response: Response<MutableList<Country>>
                ) {

                 //   if (response.isSuccessful) {

                        if (response.body() != null) {
                            var countryAdapter = ArrayAdapter(
                                applicationContext,
                                android.R.layout.simple_spinner_dropdown_item,
                                response.body()!!
                            )
                            binding.autoCountry.setAdapter(countryAdapter)

                        }
                  //  }
                }

                override fun onFailure(call: Call<MutableList<Country>>, t: Throwable) {

                }

            })
    }
}