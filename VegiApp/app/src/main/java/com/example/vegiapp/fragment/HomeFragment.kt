package com.example.vegiapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.vegiapp.R
import com.example.vegiapp.adapter.CategoryHomeAdapter
import com.example.vegiapp.adapter.SliderImageAdapter
import com.example.vegiapp.adapter.SubCategoryAdapter
import com.example.vegiapp.api.Const
import com.example.vegiapp.api.RetrofitApiBuilder
import com.example.vegiapp.databinding.FragmentHomeBinding
import com.example.vegiapp.model.HomePage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    private val SliderImageAdapter = SliderImageAdapter()
    private val CategoryHomeAdapter = CategoryHomeAdapter()
    private val SubCategoryAdapter = SubCategoryAdapter()

    val disposable: CompositeDisposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        initview()

        return binding.root
    }

    private fun initview(){

        RetrofitApiBuilder.service.homePage(
            Const.KEY_VALUE
        )
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.unsubscribeOn(Schedulers.io())

            ?.subscribe {categories, throwable ->
//                categories?.data?.let {
//                    Log.d("TAG", "onCreate: " + it)
//                }

                // category items
                binding.rvHomepage.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                binding.rvHomepage.adapter = CategoryHomeAdapter
                binding.adapter = CategoryHomeAdapter

                // Banner auto Slider
                binding.auto.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                binding.auto.adapter = SliderImageAdapter
                binding.image = SliderImageAdapter

                val snapHelper = PagerSnapHelper()
                snapHelper.attachToRecyclerView(binding.auto)

                // Subcategory items
                binding.rvSubcategory.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                binding.rvSubcategory.adapter = SubCategoryAdapter
                binding.adapter1 = SubCategoryAdapter

                SubCategoryAdapter.update(categories?.data?.categoryWithProduct as ArrayList<HomePage.Data.CategoryWithProduct>)

                SliderImageAdapter.updateData1(categories.data.banner as ArrayList<HomePage.Data.Banner>)

                categories.data.let {

                    CategoryHomeAdapter.updatedata(categories.data.category as ArrayList<HomePage.Data.Category>)

                }

            }?.let {
                disposable.add(
                    it
                )
            }

    }
}