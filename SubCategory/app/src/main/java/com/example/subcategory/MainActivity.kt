package com.example.subcategory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imageload.api.Const
import com.example.imageload.api.RetrofitApiBuilder
import com.example.imageload.model.homepage.HomePage
import com.example.subcategory.adapter.SubCategoryAdapter
import com.example.subcategory.databinding.ActivityMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private var SubCategoryAdapter: SubCategoryAdapter = SubCategoryAdapter()

    val disposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

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

                // Subcategory items
                binding.rvSubcategory.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvSubcategory.adapter = SubCategoryAdapter
                binding.adapter = SubCategoryAdapter

                SubCategoryAdapter.update(categories?.data?.categoryWithProduct as ArrayList<HomePage.Data.CategoryWithProduct>)

            }?.let {
                disposable.add(
                    it
                )
            }
    }
}