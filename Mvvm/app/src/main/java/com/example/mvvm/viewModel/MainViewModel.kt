package com.example.mvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.retrofitandroid.model.User
import com.example.mvvm.repositories.UserListRepository

class MainViewModel : ViewModel() {

    // private var userListLiveData = MutableLiveData<List<User>>()

    val fetchUserList : LiveData<List<User>>
        get() = UserListRepository.loadUserList()

    val isLoading : LiveData<Boolean>
        get() = UserListRepository.getLoadingUpdate()

    /* private fun getList() : MutableLiveData<List<User>>
     {
         userListLiveData = UserListRepository.loadUserList()
         return userListLiveData
     }*/

}