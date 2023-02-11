package com.example.androidjetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidjetpack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(10)).get(MainViewModel::class.java)
        binding.mainModel = mainViewModel
        binding.lifecycleOwner = this

//        mainViewModel.counterLiveData.observe(this,Observer{
//            binding.tvCounter.text = "$it"
//        })

        binding.btnIncrement.setOnClickListener {
            mainViewModel.increment()
        }

        binding.btnDecrement.setOnClickListener {
            mainViewModel.decrement()
        }
    }
}