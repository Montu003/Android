package com.app.share

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.app.share.adapter.CategoryHomeAdapter
import com.app.share.adapter.SliderImageAdapter
import com.app.share.adapter.SubCategoryAdapter
import com.app.share.model.HomePage
import com.app.share.databinding.ActivityMainBinding
import com.example.vegiapp.api.Const
import com.example.vegiapp.api.RetrofitApiBuilder
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val SliderImageAdapter = SliderImageAdapter()
    private val CategoryHomeAdapter = CategoryHomeAdapter()
    private val SubCategoryAdapter = SubCategoryAdapter()
    lateinit var sharedPreferences: SharedPreferences

    val disposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initview()

        sharedPreferences = getSharedPreferences(Const.SHARE, MODE_PRIVATE)

        if (sharedPreferences.getString("home_data", "")!!.isNotEmpty()) {
            startActivity(Intent(this, OutputActivity::class.java))
        }
    }

    private fun initview(){

        RetrofitApiBuilder.service.homePage(
            Const.KEY_VALUE
        )
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.unsubscribeOn(Schedulers.io())

            ?.subscribe { homedata, throwable ->

                val editor = sharedPreferences.edit()

                val data = Gson().toJson(homedata!!.data)
                editor.putString("home_data", data)
                editor.apply()

                // category items
                binding.rvHomepage.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                binding.rvHomepage.adapter = CategoryHomeAdapter
                binding.adapter = CategoryHomeAdapter

                // Banner auto Slider
                binding.auto.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                binding.auto.adapter = SliderImageAdapter
                binding.image = SliderImageAdapter

                val snapHelper = PagerSnapHelper()
                snapHelper.attachToRecyclerView(binding.auto)

                // Subcategory items
                binding.rvSubcategory.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvSubcategory.adapter = SubCategoryAdapter
                binding.adapter1 = SubCategoryAdapter

                SubCategoryAdapter.update(homedata.data.categoryWithProduct as ArrayList<HomePage.Data.CategoryWithProduct>)

                SliderImageAdapter.updateData1(homedata.data.banner as ArrayList<HomePage.Data.Banner>)

                homedata.data.let {

                    CategoryHomeAdapter.updatedata(homedata.data.category as ArrayList<HomePage.Data.Category>)
                }

            }?.let {
                disposable.add(
                    it
                )
            }
    }
}