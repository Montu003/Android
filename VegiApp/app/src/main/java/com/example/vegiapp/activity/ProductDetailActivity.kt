package com.example.vegiapp.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.vegiapp.R
import com.example.vegiapp.adapter.ProductDetailAdapter
import com.example.vegiapp.api.Const
import com.example.vegiapp.api.RetrofitApiBuilder
import com.example.vegiapp.databinding.ActivityProductDetailBinding
import com.example.vegiapp.model.GetProduct
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ProductDetailActivity : BaseActivity() {

    private lateinit var binding: ActivityProductDetailBinding
    private var index = 0
    private val ProductDetailAdapter = ProductDetailAdapter()

    val disposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_detail)

        RetrofitApiBuilder.service.getProductById(
            Const.KEY_VALUE,12
        )
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.unsubscribeOn(Schedulers.io())

            ?.subscribe { categories, throwable ->

//                var data  = intent.getStringExtra("title")
//                binding.tvtitle.text = data

                categories?.data?.images?.let {

                    Log.i("TAG", "onCreate: "+categories.data.images.toString())
                    ProductDetailAdapter.updatedata(categories.data.images as ArrayList<GetProduct.Data.Image>)
                }

                binding.ivImage.setOnClickListener {
                    onBackPressed()
                }
                //  var  data = intent.getParcelableArrayListExtra<ItemSubCategory>("data")

                //add data count for result
                val add = intent.getIntExtra("Add", 0)

                if (add == 0) {
                    binding.btnAdd.text = "Add"
                } else {
                    binding.btnAdd.text = add.toString()
                }

//        binding.ivIcon.setImageResource(data?.get(0)!!.image)
//        // binding.tvKg.text=data.get(0).price
//        binding.tvtitle.text=data.get(0).title

                binding.btnFav.setOnClickListener {

                    if (index == 0) {
                        binding.ivDil.setImageResource(R.drawable.ic_favorite_like)
                        binding.tvAdditem.text = "remove"
                        index = 1
                    } else {
                        index = 0
                        binding.ivDil.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                        // binding.ivDil.visibility = View.VISIBLE
                        binding.tvAdditem.text = "Add To Wishlist"
                    }
                }
                binding.btnAdd.setOnClickListener {

                    if (binding.btnAdd.visibility == View.VISIBLE){
                        binding.btnAdd.visibility = View.GONE
                        binding.btnAdddata.visibility = View.VISIBLE
                    }
                }

                var count = 1
                binding.ivMinus.setOnClickListener {

                    if (1 < count) {
                        count--
                        binding.tvQty.text = count.toString()
                        Log.d("TAG", "onCreateView: " + count)
                    } else {
                        if (binding.btnAdddata.visibility == View.VISIBLE) {
                            binding.btnAdddata.visibility = View.GONE
                            binding.btnAdd.visibility = View.VISIBLE
                        }
                    }
                }

                binding.btAddition.setOnClickListener {

                    if (count < 7) {
                        Log.d("TAG", "onCreateView: " + count)
                        count++
                        binding.tvQty.text = count.toString()
                    }
                }

            }?.let {
                disposable.add(
                    it
                )
            }
    }
}