package com.example.biopass.data.network

import com.example.biopass.constant.Constants
import com.example.biopass.data.dataClass.WebsiteData
import retrofit2.http.*

interface ApiService {

    @GET(Constants.GETWEBSITE)
    suspend fun getWebsites():WebsiteData

}