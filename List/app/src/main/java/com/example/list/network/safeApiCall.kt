package com.example.list.network

import android.util.Log
import com.example.list.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response


fun<T> safeApiCall(call:suspend()->Response<T> ): Flow<Resource<T?>> = flow{

    try {

        val c = call()
        c.let {
            if(c.isSuccessful){
                Log.e("TAG", "safeApiCall:$c ", )
                Log.e("TAG", "safeApiCall "+it.body() )
                emit(Resource.Success(it.body()))
            }else{
                c.errorBody()?.let {
                    it.close()
                    Log.e("TAG", "error: "+it.toString() )
                    emit( Resource.Error(it.toString()))
                }
            }

        }

    }catch (t:Throwable){
        t.printStackTrace()
        Log.e("TAG", "error: "+t)
    }


}