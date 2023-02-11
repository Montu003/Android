package com.example.vegi.adapter

import android.app.Dialog
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vegi.R
import com.example.vegi.databinding.ItemCartBinding
import com.example.vegi.databinding.ItemDeleteDailogBinding
import com.example.vegi.model.Cartmodel
import com.example.vegi.model.Diolog

class CartAdapter : RecyclerView.Adapter<CartAdapter.CartBindingViewHolder>() {

    //var listCart=MutableList<cartmodel>
    // private var list: ArrayList<Subcategory> = ArrayList()
    var listCart: ArrayList<Cartmodel> = ArrayList()

    inner class CartBindingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var binding: ItemCartBinding

        init {
            binding = DataBindingUtil.bind(itemView)!!
        }

        fun setModel(position: Int) {

            val cartdata = listCart[position]
            binding.model = cartdata
            binding.ivPotates.text = cartdata.name

            var count = 1
            binding.ivMinus.setOnClickListener {

                if (1 < count){
                    count--
                    binding.ivNo.text = count.toString()
                    Log.d("TAG", "onCreateView: " + count)
                } else{
                    if (binding.ivButton.visibility == View.VISIBLE){

                        val dialog = Dialog(it.context)
                        val itemDeleteDailogBinding: ItemDeleteDailogBinding =
                            DataBindingUtil.inflate(
                                LayoutInflater.from(it.context),
                                R.layout.item_delete_dailog,
                                null,
                                false
                            )
                        dialog.setContentView(itemDeleteDailogBinding.root)
                        dialog.window?.decorView?.setBackgroundColor(Color.TRANSPARENT)

                        itemDeleteDailogBinding.tvTitle.setText("Delete Product")
                        itemDeleteDailogBinding.btnCancel.setText("Cancel")
                        itemDeleteDailogBinding.btnDelete.setText("ok")
                        itemDeleteDailogBinding.tvAddress.setText("Do you want to delete this\n Product")

                        itemDeleteDailogBinding.btnCancel.setOnClickListener {dialog.dismiss()}
                        itemDeleteDailogBinding.btnDelete.setOnClickListener {
                            DelteItem(cartdata)
                            notifyDataSetChanged()
                            dialog.dismiss()
                        }
                        dialog.show()
                        // DelteItem(cartdata)
                    }
                }
            }

            binding.ivPlus.setOnClickListener {

                if (count < 7){
                    Log.d("TAG", "onCreateView: " + count)
                    count++
                    binding.ivNo.text = count.toString()

//                    Toast.makeText(it.context, "your limitation", Toast.LENGTH_SHORT).show()
                }
            }

            binding.btnRemove.setOnClickListener {

                val dialog = Dialog(it.context)
                val itemDeleteDailogBinding: ItemDeleteDailogBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(it.context),
                    R.layout.item_delete_dailog,
                    null,
                    false
                )
                dialog.setContentView(itemDeleteDailogBinding.root)
                dialog.window?.decorView?.setBackgroundColor(Color.TRANSPARENT)
                itemDeleteDailogBinding.tvTitle.setText("Delete Product")
                itemDeleteDailogBinding.btnCancel.setText("Cancel")
                itemDeleteDailogBinding.btnDelete.setText("ok")
                itemDeleteDailogBinding.tvAddress.setText("Do you want to delete this\n Product")

                itemDeleteDailogBinding.btnCancel.setOnClickListener { dialog.dismiss() }
                itemDeleteDailogBinding.btnDelete.setOnClickListener {
                    DelteItem(cartdata)
                    notifyDataSetChanged()
                    dialog.dismiss()
                }
                dialog.show()

            }
        }

        fun DelteItem(model: Cartmodel) {
            // listCart.get(position).id
            listCart.remove(model)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartBindingViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return CartBindingViewHolder(View)
    }

    override fun onBindViewHolder(holder: CartBindingViewHolder, position: Int) {
        holder.setModel(position)
    }

    override fun getItemCount(): Int {
        return listCart.size
    }

    fun setdata(categoryList1: ArrayList<Cartmodel>) {
        this.listCart = categoryList1
        notifyDataSetChanged()
    }
}