package com.example.vegi.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.vegi.R
import com.example.vegi.adapter.BottomSheetAdapter
import com.example.vegi.databinding.ActivityPaymentSummaryBinding
import com.example.vegi.databinding.CouponBottomSheetBinding
import com.example.vegi.model.Coupon
import com.google.android.material.bottomsheet.BottomSheetDialog

class PaymentSummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentSummaryBinding
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_payment_summary)

        // Back Activity MyDeliveryAddress
        binding.btnImage.setOnClickListener {
            onBackPressed()
        }

        // Bottom Sheet open
        binding.ivShow.setOnClickListener {

            val couponBottomSheet = BottomSheetDialog(this)
            val couponBottomSheetBinding: CouponBottomSheetBinding = DataBindingUtil.inflate(
                LayoutInflater.from(this),R.layout.coupon_bottom_sheet,null,false)
            couponBottomSheet.setContentView(couponBottomSheetBinding.root)

            var list = arrayListOf<Coupon>()

            list.add(Coupon(1,"khodal253","50%","501$"))
            list.add(Coupon(2,"jeel123","50%","501$"))
            list.add(Coupon(3,"Dhruv546","50%","501$"))
            list.add(Coupon(4,"Montu6356","50%","501$"))
            list.add(Coupon(5,"gaurav235","50%","501$"))
            list.add(Coupon(6,"vivek452","50%","501$"))
            list.add(Coupon(7,"Aniket956","50%","501$"))
            list.add(Coupon(8,"Neel856","50%","501$"))
            list.add(Coupon(9,"Parth658","50%","501$"))
            list.add(Coupon(10,"Avadh745","50%","501$"))
            list.add(Coupon(11,"Romil653","50%","501$"))
            list.add(Coupon(12,"Vraj562","50%","501$"))

            val adapter = BottomSheetAdapter()
            adapter.updateData(list)
            couponBottomSheetBinding.rvCoupon.adapter = adapter
            couponBottomSheet.show()
        }

        binding.btnUpdown.setOnClickListener {

            if (index == 0) {
                binding.btnUpdown.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
                binding.ivClose.visibility = View.GONE
                index = 1
            } else {
                index = 0
                binding.btnUpdown.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
                binding.ivClose.visibility = View.VISIBLE
            }
        }

        binding.ivButton.setOnClickListener {

            if (binding.ivButton.visibility == View.VISIBLE) {
                binding.ivPayment.visibility = View.GONE
                binding.ivButton.setImageResource(R.drawable.ic_baseline_radio_button_checked_24)
                binding.ivButton1.setImageResource(R.drawable.ic_baseline_radio_button_unchecked_24)
            } else if (binding.ivButton1.visibility == View.VISIBLE) {
                binding.ivPayment.visibility = View.GONE
                binding.ivButton.setImageResource(R.drawable.ic_baseline_radio_button_checked_24)
                binding.ivButton1.setImageResource(R.drawable.ic_baseline_radio_button_unchecked_24)
            }
        }

        binding.ivButton1.setOnClickListener {

            if (binding.ivButton1.visibility == View.VISIBLE) {
                binding.ivPayment.visibility = View.VISIBLE
                binding.ivButton1.setImageResource(R.drawable.ic_baseline_radio_button_checked_24)
                binding.ivButton.setImageResource(R.drawable.ic_baseline_radio_button_unchecked_24)
            } else if (binding.ivButton.visibility == View.VISIBLE) {
                binding.ivPayment.visibility = View.VISIBLE
                binding.ivButton.setImageResource(R.drawable.ic_baseline_radio_button_unchecked_24)
            }
        }

    }
}