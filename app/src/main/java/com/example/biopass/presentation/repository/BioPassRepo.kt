package com.example.biopass.presentation.repository

import com.example.biopass.data.dataClass.WebsiteData

interface BioPassRepo {

    suspend fun getWebsite() : WebsiteData?

}