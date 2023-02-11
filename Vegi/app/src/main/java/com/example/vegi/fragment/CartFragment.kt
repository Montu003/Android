package com.example.vegi.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vegi.R
import com.example.vegi.activity.DeliveryDetailsActivity
import com.example.vegi.adapter.CartAdapter
import com.example.vegi.databinding.FragmentCartBinding
import com.example.vegi.model.Cartmodel

class CartFragment : Fragment() {

    lateinit var binding: FragmentCartBinding
    var adapter:CartAdapter=CartAdapter()
    var listDat= mutableListOf<Cartmodel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)

        addData()

        binding.list = adapter
        binding.rvCartList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvCartList.adapter = adapter
        // binding.image = sliderImageAdapter

        binding.btnChekout.setOnClickListener {

            val intent = Intent(requireContext(),DeliveryDetailsActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    fun addData(){
        val cartData = ArrayList<Cartmodel>()

        cartData.add(Cartmodel(1,R.drawable.image_22,"Atta1",25.5f))
        cartData.add(Cartmodel(2,R.drawable.image_12,"Potato1",26.5f))
        cartData.add(Cartmodel(3,R.drawable.image_22,"Atta2",27.5f))
        cartData.add(Cartmodel(4,R.drawable.image_12,"Potato2",28.5f))
        cartData.add(Cartmodel(5,R.drawable.image_22,"Atta3",29.5f))
        cartData.add(Cartmodel(6,R.drawable.image_12,"Potato3",30.5f))
        cartData.add(Cartmodel(7,R.drawable.image_22,"Atta4",31.5f))
        cartData.add(Cartmodel(8,R.drawable.image_12,"Potato5",32.5f))

        adapter.setdata(cartData)
    }
}