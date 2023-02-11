package com.example.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.bottomsheet.adapter.BottomSheetAdapter
import com.example.bottomsheet.databinding.ActivityMainBinding
import com.example.bottomsheet.databinding.CouponBottomSheetBinding
import com.example.bottomsheet.model.Coupon
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnShow.setOnClickListener {

            val couponBottomSheet = BottomSheetDialog(this)
            val couponBottomSheetBinding: CouponBottomSheetBinding = DataBindingUtil.inflate(
                LayoutInflater.from(this), R.layout.coupon_bottom_sheet, null, false
            )
            couponBottomSheet.setContentView(couponBottomSheetBinding.root)

            val list = arrayListOf<Coupon>()

            list.add(Coupon(1,"Khodal","50%","500$"))
            list.add(Coupon(2,"Montu","50%","501$"))
            list.add(Coupon(3,"Jeel","50%","502$"))
            list.add(Coupon(4,"Dhruv","50%","503$"))
            list.add(Coupon(5,"parth","50%","504$"))
            list.add(Coupon(6,"gaurav","50%","505$"))
            list.add(Coupon(7,"Khodal","50%","506$"))
            list.add(Coupon(8,"Aniket","50%","507$"))
            list.add(Coupon(9,"Keval","50%","508$"))
            list.add(Coupon(10,"Romil","50%","509$"))
            list.add(Coupon(11,"Vraj","50%","510$"))
            list.add(Coupon(12,"Yash","50%","515$"))

            val adapter =BottomSheetAdapter()
            adapter.updateData(list)
            couponBottomSheetBinding.rvCoupon.adapter = adapter
            couponBottomSheet.show()
        }
    }
}