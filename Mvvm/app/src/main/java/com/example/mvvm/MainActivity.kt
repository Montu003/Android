package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.retrofitandroid.adapter.CustomRecyclerAdapter
import com.app.retrofitandroid.model.User
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    private lateinit var mAdapter:CustomRecyclerAdapter
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.fetchUserList.observe(this, Observer {
            if(it!=null){
                mAdapter.setItems(it as MutableList<User>)
            }
        })

        mainViewModel.isLoading.observe(this, Observer {
            if(it)
                binding.progressCircular.visibility = View.VISIBLE
            else
                binding.progressCircular.visibility = View.GONE
        })

        initRecycler()
    }
    private fun initRecycler() {

        var manager = LinearLayoutManager(this)
        binding.recyclerItem.layoutManager = manager
        mAdapter = CustomRecyclerAdapter(this, mutableListOf())
        binding.recyclerItem.adapter = mAdapter

    }
}