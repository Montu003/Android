package com.example.vegi.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.vegi.R
import com.example.vegi.databinding.FragmentFirstBinding
import com.example.vegi.model.OrderListModel

class FirstFragment : Fragment() {

    private lateinit var binding:FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_first, container, false)

       var data =   arguments?.getParcelable<OrderListModel>("data")
        Log.e("TAG", "onCreateView:$data ", )

        data?.let {
            binding.status.text = it.status
            binding.tvDate.text = it.date
            binding.tvCount.text = it.count
            binding.tvItemId.text = it.orderId
            binding.tvPrice.text = it.price
        }

        return binding.root
    }
}