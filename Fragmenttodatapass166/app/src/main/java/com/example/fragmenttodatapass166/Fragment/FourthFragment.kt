package com.example.fragmenttodatapass166.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmenttodatapass166.R
import com.example.fragmenttodatapass166.databinding.FragmentFourthBinding


class FourthFragment : Fragment() {

    lateinit var binding:FragmentFourthBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun updateResult(name:String,age:Int)
    {

        binding.tvName.text = "Name :$name"
        binding.tvAge.text = "Age : $age"

    }
}