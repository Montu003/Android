package com.example.vegiapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.vegiapp.R
import com.example.vegiapp.adapter.CategoryAdapter
import com.example.vegiapp.api.Const
import com.example.vegiapp.api.RetrofitApiBuilder
import com.example.vegiapp.databinding.FragmentCategoryBinding
import com.example.vegiapp.model.CategoryPage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CategoryFragment : Fragment() {

    private lateinit var binding:FragmentCategoryBinding
    private val CategoryAdapter = CategoryAdapter()

    val disposable: CompositeDisposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = DataBindingUtil.inflate(inflater,R.layout.fragment_category, container, false)

        RetrofitApiBuilder.service.getCategoryList(
            Const.KEY_VALUE
        )
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.unsubscribeOn(Schedulers.io())

            ?.subscribe {categories, throwable ->

                binding.rvOu.layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
                binding.rvOu.adapter = CategoryAdapter
                binding.adapter = CategoryAdapter

                CategoryAdapter.update(categories?.data as ArrayList<CategoryPage.Data>)

            }?.let {
                disposable.add(
                    it
                )
            }
        return binding.root
    }
}