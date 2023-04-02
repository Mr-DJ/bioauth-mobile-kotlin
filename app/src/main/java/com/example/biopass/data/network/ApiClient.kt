package com.example.biopass.data.network

import android.app.Application
import android.content.Context
import com.example.biopass.constant.Constants
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private lateinit var apiService : ApiService

    fun getApiService(application: Application):ApiService{
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASEURL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build())
            .build()

        apiService = retrofit.create(ApiService::class.java)
        return apiService
    }
}