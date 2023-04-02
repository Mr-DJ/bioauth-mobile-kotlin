package com.example.biopass.presentation.repository

import com.example.biopass.data.dataClass.WebSiteDataX

interface BioPassRepo {

    suspend fun getWebsite() : WebSiteDataX?

}