package com.example.biopass.data.repository

import android.app.Application
import com.example.biopass.data.dataClass.WebsiteData
import com.example.biopass.data.network.ApiClient
import com.example.biopass.presentation.repository.BioPassRepo

class BioPassRepoImpl(
    apiClient: ApiClient,
    application: Application
):BioPassRepo {
    private val apiService = apiClient.getApiService(application)
    override suspend fun getWebsite(): WebsiteData? {
        try {



        } catch (e:Exception){

        }
        return null
    }

}