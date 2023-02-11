package com.example.vegi.adapter

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vegi.R
import com.example.vegi.activity.formfield
import com.example.vegi.databinding.ItemDeleteDailogBinding
import com.example.vegi.databinding.ItemDeliveryBinding
import com.example.vegi.model.Diolog
import com.example.vegi.model.MyDelivery

class DeliveryAdapter(var list1: ArrayList<MyDelivery>) :
    RecyclerView.Adapter<DeliveryAdapter.DeliveryBindingViewHolder>() {

    inner class DeliveryBindingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var binding: ItemDeliveryBinding? = null

        init {
            binding = DataBindingUtil.bind(itemView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryBindingViewHolder {
        val View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_delivery, parent, false)
        return DeliveryBindingViewHolder(View)
    }

    override fun onBindViewHolder(holder: DeliveryBindingViewHolder, position: Int) {
        var data     = list1[position]
        holder.binding?.let {
            it.model = data

            // edit mate
            it.tvEdit.setOnClickListener {
                val intent = Intent(it.context, formfield::class.java)
                intent.putExtra("form", data)
                intent.putExtra("update",R.id.btn_address)
                it.context.startActivity(intent)
            }

            // delete karva mate
            it.tvDelete.setOnClickListener {

                //var list: ArrayList<Diolog>
//                var builder = AlertDialog.Builder(it.context)
//
//                builder.setTitle("Alert")
//                    .setMessage("are you sure you want to Delete items")
//
//                    .setPositiveButton(Html.fromHtml("<font color='#FF7F27'>Yes</font>"), { dialog, i ->
//                        Toast.makeText(it.context, "positive button clicked", Toast.LENGTH_SHORT).show()
//
//                        list1.remove(data)
//                        notifyDataSetChanged()
//                    })
//
//                    .setNegativeButton(Html.fromHtml("<font color='#FF4500'>No</font>"),{dialogInterface,i ->
//                        Toast.makeText(it.context, "Negative button clicked", Toast.LENGTH_SHORT).show()
//                    }).show()

                val dialog = Dialog(it.context)
                val itemDeleteDailogBinding : ItemDeleteDailogBinding = DataBindingUtil.inflate( LayoutInflater.from(it.context),R.layout.item_delete_dailog,null,false)
                dialog.setContentView(itemDeleteDailogBinding.root)
                dialog.window?.decorView?.setBackgroundColor(Color.TRANSPARENT)
                itemDeleteDailogBinding.tvTitle.setText("Delete Address")
                itemDeleteDailogBinding.tvAddress.setText("Do you want to delete this \n address")
                itemDeleteDailogBinding.btnCancel.setOnClickListener { dialog.dismiss()}

                itemDeleteDailogBinding.btnDelete.setOnClickListener {
                  list1.remove(data)
                    notifyDataSetChanged()
                    dialog.dismiss()
                }
                dialog.show()
            }
        }
    }

    override fun getItemCount() = list1.size

    fun Delivery(mList: ArrayList<MyDelivery>) {
        this.list1 = mList
        notifyDataSetChanged()
    }
}