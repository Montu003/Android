package com.example.list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.list.model.CategoryResponse
import com.example.list.repository.CategoryRepository
import com.example.list.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: CategoryRepository):ViewModel(){

   val _categoryResponseLive:MutableLiveData<Resource<CategoryResponse?>> = MutableLiveData()
    val categoryResponseLive : LiveData<Resource<CategoryResponse?>> = _categoryResponseLive


    fun getCatData() = viewModelScope.launch {
        repository.getCatData().collect {values->
            _categoryResponseLive.value = values
        }
    }


}