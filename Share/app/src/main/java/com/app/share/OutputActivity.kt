package com.app.share

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.app.share.adapter.CategoryHomeAdapter
import com.app.share.adapter.SliderImageAdapter
import com.app.share.adapter.SubCategoryAdapter
import com.app.share.databinding.ActivityOutputBinding
import com.app.share.model.HomePage
import com.bumptech.glide.Glide
import com.example.vegiapp.api.Const
import com.google.gson.Gson

class OutputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOutputBinding
    private val SliderImageAdapter = SliderImageAdapter()
    private val CategoryHomeAdapter = CategoryHomeAdapter()
    private val SubCategoryAdapter = SubCategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_output)

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(
            Const.SHARE, MODE_PRIVATE
        )
        val strData = sharedPreferences.getString("home_data", "")
        val homeData: HomePage.Data = Gson().fromJson(strData, HomePage.Data::class.java)
    //    Log.i("TAG", "onCreate: "+homeData)

        // Banner auto Slider
        binding.rvImage.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvImage.adapter = SliderImageAdapter
        binding.image = SliderImageAdapter

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.rvImage)

        // category items
        binding.rvHomepage.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvHomepage.adapter = CategoryHomeAdapter
        binding.adapter = CategoryHomeAdapter

        // Subcategory items
        binding.rvSubcategory.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvSubcategory.adapter = SubCategoryAdapter
        binding.adapter1 = SubCategoryAdapter

        SubCategoryAdapter.update(homeData.categoryWithProduct as ArrayList<HomePage.Data.CategoryWithProduct>)

        SliderImageAdapter.updateData1(homeData.banner as ArrayList<HomePage.Data.Banner>)

        homeData.let {

            CategoryHomeAdapter.updatedata(homeData.category as ArrayList<HomePage.Data.Category>)
        }
    }
}