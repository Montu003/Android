package com.example.vegiapp.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vegiapp.R
import com.example.vegiapp.adapter.SearchAdapter
import com.example.vegiapp.api.Const
import com.example.vegiapp.api.RetrofitApiBuilder
import com.example.vegiapp.databinding.ActivitySearchBinding
import com.example.vegiapp.model.SearchPage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SearchActivity : BaseActivity() {

    private lateinit var binding:ActivitySearchBinding
    private val SearchAdapter = SearchAdapter()

    val disposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_search)

        RetrofitApiBuilder.service.searchProduct(
            Const.KEY_VALUE,10
        )
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.unsubscribeOn(Schedulers.io())

            ?.subscribe {categories, throwable ->

//                var data = intent.getStringExtra("title")
//                binding.btnTitle.text = data

                binding.ivBack.setOnClickListener {
                    onBackPressed()
                }

                binding.rvList.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvList.adapter = SearchAdapter
                binding.adapter = SearchAdapter

                categories?.data?.let {
                    SearchAdapter.updatedata(categories.data as ArrayList<SearchPage.Data>)

                }

            }?.let {
                disposable.add(
                    it
                )
            }
    }
}