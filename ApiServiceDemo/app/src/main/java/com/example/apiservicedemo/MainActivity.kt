package com.example.apiservicedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiservicedemo.adapter.ProfileCategoryAdapter
import com.example.apiservicedemo.api.Const
import com.example.apiservicedemo.api.RetrofitApiBuilder
import com.example.apiservicedemo.databinding.ActivityMainBinding
import com.example.apiservicedemo.model.profilecategory.ProfileCategory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity(){

    lateinit var binding: ActivityMainBinding
    private val ProfileCategoryAdapter: ProfileCategoryAdapter = ProfileCategoryAdapter()

    val disposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        RetrofitApiBuilder.service.registerUser(
            "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiYWM4YmIyZmY4M2NjNjNjMjY4MzA0NjkzZmIxNjQ1MmU5ZWZmMGUyMWNlNjc1MjYyZGI5Mzk0ZTFlZmIxZTJkZTViOTAxMmRmYzYzMzM5ODQiLCJpYXQiOjE2NjgwNzU0NjcuMjY0ODMyMDE5ODA1OTA4MjAzMTI1LCJuYmYiOjE2NjgwNzU0NjcuMjY0ODM2MDcyOTIxNzUyOTI5Njg3NSwiZXhwIjoxNjk5NjExNDY2Ljk3MzA4ODk3OTcyMTA2OTMzNTkzNzUsInN1YiI6IjkwMyIsInNjb3BlcyI6W119.ecnBAFzsi6YafTGpHgjTOuDH_l-36RdmlUPeDWG38cNaUvI9t_WU0ZK7z-EDy0ySTETR8US-Bs_Rq7j-PjKNz3K9b6rFUPnsUF3C5XGCl8R9oRhUaNZcCmNF4bPuHOu1ffivTvidmPrZhnl6BcCRhZOUK9EPT1L9xXHTYw_Wp2aDcFrtB3DiTDcPHDG5D96Yo0zsHUgsH5plPeTtiTkcfOITjdFiSOstSbEnPaadzlOUjHTmBw5cbd6K-hMxoyyVlnQpzqnfsYaOX3D31BIyB57o8Iz5NDSbH6QlI8RUqiwJjTHkWUj9H3PDQn1p0hzOvOuVm1QYkU3Am34D4Dtg7llexzyUZtfEvgt6PWqf7pbjG3BDkOLbFBNKr4FK-b3_srPGQNQG3tt2owS5_lyDZiiyZa2uHRbWX50DWYgAwr2GRcTiiRtCTpq-GEC-QpGQrHO6XvuWT-pYS65tq_lstQrC7HwxGIL6n9m9flLnknK3I-OKUFwNC1moeSXM8OtzwIaEgsZ0i34s4P8qeCXOyOdFcRE2yeqLOXONkTNMRQKNaL7GeBZ9TZfHZO0aRM1-Ir0nyX8w15nIRwbHQhxGWMQWtfQXE2wjfzOpxvZqvtRA1oTTCBtJ9LfjfogBUOnR5t6aDqNPLVHPsYdbUTp5G2FEJdvRo7XxVcfU_gLuDzU",
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

                binding.rvProfile.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvProfile.adapter = ProfileCategoryAdapter
                binding.adapter = ProfileCategoryAdapter

                ProfileCategoryAdapter.update(categories?.data as ArrayList<ProfileCategory.Data>)

            }?.let {
                disposable.add(
                    it
                )
            }
    }
}