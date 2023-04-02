package com.example.biopass.data.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import com.example.biopass.data.dataClass.WebSiteDataX
import com.example.biopass.data.dataClass.WebsiteData
import com.example.biopass.data.network.ApiClient
import com.example.biopass.presentation.repository.BioPassRepo

class BioPassRepoImpl(
    apiClient: ApiClient,
    application: Application
):BioPassRepo {
    private val apiService = apiClient.getApiService(application)
    override suspend fun getWebsite(): WebSiteDataX? {
        try {
            Log.v("work","it worked")
            return apiService.getWebsites()

        } catch (e:Exception){
            Log.v("work","it doesn't work")
        }
        return null
    }

}