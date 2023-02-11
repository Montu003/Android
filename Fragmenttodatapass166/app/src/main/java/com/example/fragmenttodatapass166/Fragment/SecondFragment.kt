package com.example.fragmenttodatapass166.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmenttodatapass166.R
import com.example.fragmenttodatapass166.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    lateinit var binding:FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            var name = it.getString("NAME")
            var age = it.getInt("AGE")

            binding.tvName.text = "NAME : $name"
            binding.tvAge.text = "AGE : $age"
        }
    }
}