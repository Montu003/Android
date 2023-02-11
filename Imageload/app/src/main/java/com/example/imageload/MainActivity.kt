package com.example.imageload

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imageload.adapter.HomeAdapter
import com.example.imageload.adapter.SliderImageAdapter
import com.example.imageload.adapter.ProductAdapter
import com.example.imageload.adapter.SubCategoryAdapter
import com.example.imageload.api.Const
import com.example.imageload.api.RetrofitApiBuilder
import com.example.imageload.databinding.ActivityMainBinding
import com.example.imageload.model.homepage.HomePage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    // imageurl
    lateinit var binding: ActivityMainBinding
    private val HomeAdapter= HomeAdapter()
    private val SliderImageAdapter= SliderImageAdapter()
    private val SubCategoryAdapter= SubCategoryAdapter()

    val disposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        RetrofitApiBuilder.service.registerUser(
            Const.KEY_VALUE
        )
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.unsubscribeOn(Schedulers.io())

            ?.subscribe { categories, throwable ->
//                categories?.data?.let {
//
//                    Log.d("TAG", "onCreate: " + it)
//                }

                // category items
                binding.rvHomepage.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                binding.rvHomepage.adapter = HomeAdapter
                binding.adapter = HomeAdapter

                // Banner auto Slider
                binding.auto.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                binding.auto.adapter = SliderImageAdapter
                binding.image = SliderImageAdapter

                // Subcategory items
                binding.rvSubcategory.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvSubcategory.adapter = SubCategoryAdapter
                binding.adapter1 = SubCategoryAdapter

                SubCategoryAdapter.update(categories?.data?.categoryWithProduct as ArrayList<HomePage.Data.CategoryWithProduct>)

                SliderImageAdapter.updateData1(categories.data.banner as ArrayList<HomePage.Data.Banner>)

                HomeAdapter.updatedata(categories.data.category as ArrayList<HomePage.Data.Category>)

            }?.let {
                disposable.add(
                    it
                )
            }
    }
}