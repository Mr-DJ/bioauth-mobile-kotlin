package com.example.biopass.data.dataClass

data class WebsiteDataItem(
    val __v: Int,
    val _id: String,
    val createdAt: String,
    val password : String?,
    val username : String?,
    val loginStatus: Boolean,
    val webSiteUrl: String,
    val websiteName: String
)