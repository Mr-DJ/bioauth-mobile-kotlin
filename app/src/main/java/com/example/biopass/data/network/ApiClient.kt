package com.example.biopass.data.network

import android.content.Context
import com.example.biopass.constant.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private lateinit var apiService : ApiService

    fun getApiService(context:Context):ApiService{
        if (!::apiService.isInitialized){
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            apiService = retrofit.create(ApiService::class.java)
        }
        return apiService
    }
}