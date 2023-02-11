package com.example.vegi.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vegi.R
import com.example.vegi.databinding.ItemSubcategoryBinding
import com.example.vegi.model.ItemSubCategory

class Subcategoryadp(
    var list2: ArrayList<ItemSubCategory>,
    var listener: SubCategoryAdapter.itemClicked

) : RecyclerView.Adapter<Subcategoryadp.SubcategoryBindingViewHolder>() {

    inner class SubcategoryBindingViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        var binding: ItemSubcategoryBinding? = null

        var count = 0

        init {
            binding = DataBindingUtil.bind(itemview)
        }

        fun setModel(position: Int) {
            var subcategory = list2[position]
            binding?.model = subcategory
            binding?.ivImage?.setImageResource(subcategory.image)
            binding?.tvtitle?.text = subcategory.title
            binding?.tvPrice?.setText(subcategory.price)

            //adapter = Subcategoryadp(subcategory.list, listener)

            binding?.btnAdd?.setOnClickListener {
                listener.ChildItemAddBtnClicked(position, subcategory.title)

//                val intent = Intent(binding!!.btnAdd.context,Clickevent::class.java)
//                intent.putExtra("button",itemCount)
//                binding!!.btnAdd.context.startActivity(intent)
                count++
                if (binding?.btnAdd?.visibility == View.VISIBLE) {
                    binding?.btnAdd?.visibility = View.GONE
                    binding?.btnAdddata?.visibility = View.VISIBLE
                }
            }

            binding?.ivMinus?.setOnClickListener {
                if (1 < count) {
                    count--
                    binding?.tvQty?.text = count.toString()
                    Log.d("TAG", "setModel: " + count)
                } else {
                    if (binding?.btnAdddata?.visibility == View.VISIBLE) {
                        binding?.btnAdddata?.visibility = View.GONE
                        binding?.btnAdd?.visibility = View.VISIBLE
                    }
                }
            }
            binding?.btAddition?.setOnClickListener {

                if (count < 7) {
                    Log.d("TAG", "setModel: " + count)
                    count++
                    binding?.tvQty?.text = count.toString()
                }
            }

            binding?.ivImage?.setOnClickListener {
                listener.ChlidDataPasss(position, subcategory.image, count, list2)

            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubcategoryBindingViewHolder {
        // val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sub, parent, false)
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_subcategory, parent, false)
        return SubcategoryBindingViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubcategoryBindingViewHolder, position: Int) {
        holder.setModel(position)
    }

    override fun getItemCount() = list2.size

/* fun subupdate(categoryList: ArrayList<Item_Subcatgrocery>) {
     this.list2 = categoryList
     notifyDataSetChanged()
 }*/
}