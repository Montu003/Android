package com.example.fragmenttodatapass166.Fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmenttodatapass166.Communicator
import com.example.fragmenttodatapass166.R
import com.example.fragmenttodatapass166.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    lateinit var binding:FragmentThirdBinding
     lateinit var Communicator:Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Communicator = context as Communicator
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.setOnClickListener {

            var name = binding.etName.text.toString().trim()
            var age = binding.etAge.text.toString().trim()

            Communicator.setdata(name,age.toInt())
        }
    }
}