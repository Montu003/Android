
import android.content.Context
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.RecyclerView
import app.crudoperation.R
import app.crudoperation.databinding.RowItemBinding
import javax.microedition.khronos.opengles.GL

class DataAdapter(var context: Context, var listdata: MutableList<Data>) :
    RecyclerView.Adapter<DataAdapter.ViewData>() {

    lateinit var binding: RowItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        binding = RowItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewData(binding)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        var list = listdata[position]

        holder.bind.tvName.text = "${list.FirstName} ${list.LastName}"
        holder.bind.tvEmail.text = "${list.email}"

        //holder.bind.ivIcon.setImageResource(list.Image)
        Glide.with(context).load(list.avatar).centerCrop().placeholder(
            R.drawable.ic_launcher_foreground).into(holder.bind.ivIcon)

    }

    override fun getItemCount(): Int {
        return listdata.size
    }

    class ViewData(var bind: RowItemBinding) : RecyclerView.ViewHolder(bind.root) {
    }

    fun setItem(listdata:MutableList<Data>){
        this.listdata=listdata
        notifyDataSetChanged()
    }
}
