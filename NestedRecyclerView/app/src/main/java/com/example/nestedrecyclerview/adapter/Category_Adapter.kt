package com.example.nestedrecyclerview.adapter
import android.icu.util.ULocale
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.R
import com.example.nestedrecyclerview.databinding.ItemChildLayoutBinding
import com.example.nestedrecyclerview.databinding.ItemParentLayoutBinding
import com.example.nestedrecyclerview.model.Category
import com.example.nestedrecyclerview.model.SubCategory
import java.util.*
import kotlin.collections.ArrayList

class Category_Adapter : RecyclerView.Adapter<Category_Adapter.CategoryBindingViewHolder>() {
    private var list2: ArrayList<Category> = ArrayList()
   /* private val categoryList1:ArrayList<SubCategory> = ArrayList()
    private val SubCategoryAdapter:SubCategoryAdapter = SubCategoryAdapter()*/

    inner class CategoryBindingViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        val subCategoryAdapter: SubCategoryAdapter = SubCategoryAdapter()
        var binding: ItemParentLayoutBinding? = null

        init {
            binding = DataBindingUtil.bind(itemview)
        }
        fun setModel(position: Int) {
            val category = list2[position]
            binding?.model = category
            binding?.tvTitle?.text = category.title
            binding?.adapter = subCategoryAdapter

            subCategoryAdapter.updateDate1(category.movieList)
          /*  binding?.adapter = SubCategoryAdapter
            SubCategoryAdapter.updateDate1(categoryList1)*/
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryBindingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_parent_layout, parent, false)
        return CategoryBindingViewHolder(view)
    }
    override fun onBindViewHolder(holder: CategoryBindingViewHolder, position: Int) {
        holder.setModel(position)
    }
    override fun getItemCount() = list2.size

    fun updateData(categotyList: ArrayList<Category>) {
        this.list2 = categotyList
        notifyDataSetChanged()
    }
}