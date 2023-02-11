package com.example.vegi.fragment

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.vegi.R
import com.example.vegi.activity.*
import com.example.vegi.databinding.FragmentProfileBinding
import com.example.vegi.databinding.ItemCustomDailogBinding
import com.example.vegi.databinding.ItemProfileBinding
import com.example.vegi.model.Cartmodel
import com.example.vegi.model.Diolog
import com.google.android.material.bottomsheet.BottomSheetDialog

class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        binding.btnLogout.setOnClickListener {
            val dialog = Dialog(requireActivity())
            val itemCustomDailogBinding: ItemCustomDailogBinding = DataBindingUtil.inflate(
                LayoutInflater.from(requireActivity()),
                R.layout.item_custom_dailog,
                null,
                false
            )
            dialog.setContentView(itemCustomDailogBinding.root)
            dialog.window?.decorView?.setBackgroundColor(Color.TRANSPARENT)
            itemCustomDailogBinding.tvCancel.setOnClickListener { dialog.dismiss() }
            itemCustomDailogBinding.tvDelete.setOnClickListener { dialog.dismiss() }
            dialog.show()
        }

        binding.btnOrder.setOnClickListener {
            val intent = Intent(requireContext(), OrderDetails::class.java)
            startActivity(intent)
        }

        binding.toolBar.setOnClickListener {
            val intent = Intent(requireContext(), MyDeliveryAddress::class.java)
            startActivity(intent)
        }

        binding.btnWishlist.setOnClickListener {
            val intent = Intent(requireContext(), MyWishlistActivity::class.java)
            startActivity(intent)
        }

        binding.btnComplaint.setOnClickListener {
            val intent = Intent(requireContext(), MyComplaintActivity::class.java)
            startActivity(intent)
        }

        // data pass profile Activity
        binding.ivProfile.setOnClickListener {

//            var name = binding.tvRetry.text.toString().trim()
//            var email = binding.viEmail.text.toString().trim()
//            val data =   Profile(
//                name = name,
//                email = email
//            )
//            val intent = Intent(requireActivity(), ItemProfileBinding::class.java)
//            intent.putExtra("data",data)
//            startActivity(intent)

            val dialog = BottomSheetDialog(requireActivity())
            val itemProfileBinding: ItemProfileBinding = DataBindingUtil.inflate(
                LayoutInflater.from(requireActivity()),
                R.layout.item_profile,
                null,
                false
            )
            dialog.setContentView(itemProfileBinding.root)

            dialog.window?.decorView?.setBackgroundColor(Color.TRANSPARENT)
            itemProfileBinding.ivCancel.setOnClickListener { dialog.dismiss() }
            dialog.show()
        }

        return binding.root
    }
}