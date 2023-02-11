package com.example.vegiapp.fragment

import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.vegiapp.R
import com.example.vegiapp.databinding.FragmentProfileBinding
import com.example.vegiapp.databinding.LogoutDailogBinding
import com.example.vegiapp.model.Register
import com.google.gson.Gson

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        val sharedPreferences: SharedPreferences = requireActivity().getSharedPreferences(
            "vegi", Context.MODE_PRIVATE
        )
        val strData = sharedPreferences.getString("user", "")
        val user: Register.Data = Gson().fromJson(strData,Register.Data::class.java)
        binding.tvName.text = user.firstname
        binding.tvEmail.text = user.email

        binding.btnLogout.setOnClickListener {

            val dialog = Dialog(requireActivity())
            val itemCustomDailogBinding: LogoutDailogBinding = DataBindingUtil.inflate(
                LayoutInflater.from(requireActivity()),
                R.layout.logout_dailog,
                null,
                false
            )
            dialog.setContentView(itemCustomDailogBinding.root)
            dialog.window?.decorView?.setBackgroundColor(Color.TRANSPARENT)

            itemCustomDailogBinding.btnDelete.setOnClickListener {
                dialog.dismiss()
            }
            itemCustomDailogBinding.btnCancel.setOnClickListener { dialog.dismiss() }
            dialog.show()
        }

        return binding.root
    }
}