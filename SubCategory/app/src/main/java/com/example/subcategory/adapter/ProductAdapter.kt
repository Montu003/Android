package  com.example.subcategory.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.imageload.api.Const
import com.example.imageload.model.homepage.HomePage
import com.example.subcategory.R
import com.example.subcategory.databinding.ItemProductBinding

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.SubCategoryViewHolder>(){

    private var list: ArrayList<HomePage.Data.CategoryWithProduct.Product> = ArrayList()

   inner class SubCategoryViewHolder(itemView: View) : ViewHolder(itemView){

        var binding: ItemProductBinding

       init{
           binding = DataBindingUtil.bind(itemView)!!
       }

       fun setmodel(position: Int){
           val category = list[position]

           Glide.with(itemView)
               .load(Const.ITEM_BASE_URL+category.images.get(0).image)
               .into(binding.ivImage)

           binding.model = category

       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.item_product,parent,false)
        return SubCategoryViewHolder(View)
    }

    override fun onBindViewHolder(holder: SubCategoryViewHolder, position: Int) {
        holder.setmodel(position)
    }

    override fun getItemCount() = list.size

    fun update(category: ArrayList<HomePage.Data.CategoryWithProduct.Product>) {
        this.list = category
        notifyDataSetChanged()
    }
}