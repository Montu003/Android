package com.example.customview47.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.customview47.HomeActivity
import com.example.customview47.databinding.PersonItemListBinding
import com.example.customview47.model.person

class CustomListAdapter(var context:Context, var personList:MutableList<person>):BaseAdapter() {

    lateinit var binding: PersonItemListBinding

    override fun getCount(): Int {
        return personList.size
    }

    override fun getItem(pos: Int): Any {
        return personList[pos]
    }

    override fun getItemId(pos: Int): Long {
        return pos.toLong()
    }

    override fun getView(pos: Int, view: View?, parent: ViewGroup?): View {
        binding = PersonItemListBinding.inflate(LayoutInflater.from(context),parent,false)

        var person = personList[pos]
        binding.tvTitle.text = person.title
        binding.tvType.text = person.type
        binding.ivMontu.setImageResource(person.image)
        binding.tvTime.text = person.time.toString()


        var strTitle= personList.get(pos).title
        var strtype= personList.get(pos).type
        var strtime= personList.get(pos).time
        var img=personList.get(pos).image

        binding.root.setOnClickListener {
            var intent=Intent(context,HomeActivity::class.java)
            intent.putExtra("title",strTitle)
            intent.putExtra("type",strtype)
            intent.putExtra("time",strtime)
            intent.putExtra("img",img)
            context.startActivity(intent)
        }

        return binding.root
    }
}