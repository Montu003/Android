package com.app.login

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.app.login.databinding.ActivityPriceBinding

class PriceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPriceBinding
    var count = 0
    var price = 1
    var Increment = 0
    var Deccrement = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPriceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {

            count--

            var tprice = 0
            Deccrement
            binding.tvPrice.setText(""+count)
            tprice= price * count
            binding.tvPrice.setText(""+tprice)

            if (binding.btnAdd.visibility == View.VISIBLE) {
                binding.btnAdd.visibility = View.GONE
                binding.btnAdddata.visibility = View.VISIBLE
            }

        }
    binding.ivMinus.setOnClickListener {
        if (1 < count) {
            count--
            binding.tvQty.text = count.toString()
            Log.d("TAG", "setModel: " + count)

            var tprice = 1
            Deccrement
            binding.tvPrice.setText(""+count);
            tprice= price * count
            binding.tvPrice.setText(""+tprice);

        } else {
            if (binding.btnAdddata.visibility == View.VISIBLE) {
                binding.btnAdddata.visibility = View.GONE
                binding.btnAdd.visibility = View.VISIBLE
            }
        }
    }
    binding.btAddition.setOnClickListener {

        if (count < 7) {
            Log.d("TAG", "setModel: " + count)
            count++
            binding.tvQty.text = count.toString()

            var tprice = 1
            Increment
            binding.tvPrice.setText(""+count)
            tprice= price * count
            binding.tvPrice.setText(""+tprice)

        }
    }
    }
}