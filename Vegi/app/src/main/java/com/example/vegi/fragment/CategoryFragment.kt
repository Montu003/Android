package com.example.vegi.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import com.example.vegi.model.Subcategory
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.vegi.R
import com.example.vegi.adapter.CategorySearchAdapter
import com.example.vegi.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding
    var list  = ArrayList<Subcategory>()
    private var adapter:CategorySearchAdapter= CategorySearchAdapter()

    /*val btnsearch: ImageView
        get() = findViewById(R.id.btn_search)*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_category, container, false)

       // val bundle = arguments
       // val editText = bundle!!.(R.id.btn_Search)

        var editText=view?.findViewById<EditText>(R.id.btn_search)

        binding.list = adapter
        binding.rvOu.layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        binding.rvOu.adapter = adapter

        val subData = ArrayList<Subcategory>()

        subData.add(Subcategory(1, R.drawable.image_22, "Atta"))
        subData.add(Subcategory(2, R.drawable.image_22, "Atta"))
        subData.add(Subcategory(3, R.drawable.image_12, "Potato"))
        subData.add(Subcategory(4, R.drawable.image_22, "Atta"))
        subData.add(Subcategory(5, R.drawable.image_22, "Atta"))
        subData.add(Subcategory(6, R.drawable.image_12, "Potato"))
        subData.add(Subcategory(7, R.drawable.image_22, "Atta"))
        subData.add(Subcategory(8, R.drawable.image_12, "Potato"))
        subData.add(Subcategory(9, R.drawable.image_22, "Atta"))
        subData.add(Subcategory(10, R.drawable.image_22, "Atta"))
        subData.add(Subcategory(1, R.drawable.image_22, "Atta"))
        subData.add(Subcategory(2, R.drawable.image_22, "Atta"))
        subData.add(Subcategory(2, R.drawable.image_22, "Atta"))
        subData.add(Subcategory(2, R.drawable.image_22, "Atta"))
        subData.add(Subcategory(2, R.drawable.image_22, "Atta"))
        subData.add(Subcategory(2, R.drawable.image_22, "Atta"))
        subData.add(Subcategory(2, R.drawable.image_22, "Atta"))
        subData.add(Subcategory(2, R.drawable.image_22, "Atta"))
        subData.add(Subcategory(2, R.drawable.image_22, "Atta"))
        subData.add(Subcategory(2, R.drawable.image_22, "Atta"))
        subData.add(Subcategory(2, R.drawable.image_22, "Atta"))
        subData.add(Subcategory(2, R.drawable.image_22, "Atta"))
        subData.add(Subcategory(2, R.drawable.image_22, "Atta"))
        subData.add(Subcategory(2, R.drawable.image_22, "Atta"))

      //  loaddata()
        adapter.setdata(subData)
        return binding.root
    }
    //private fun loaddata() {
   // }
}