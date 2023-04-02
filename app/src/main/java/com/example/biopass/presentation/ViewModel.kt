package com.example.biopass.presentation

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.biopass.data.dataClass.WebSiteDataX
import com.example.biopass.data.network.ApiClient
import com.example.biopass.data.repository.BioPassRepoImpl
import com.example.biopass.presentation.repository.BioPassRepo
import kotlinx.coroutines.launch

class BioPassViewModel(private val bioPassRepo: BioPassRepoImpl) : ViewModel() {

    val websites = MutableLiveData<WebSiteDataX>()
    fun getWebsites(){
        viewModelScope.launch {
            websites.value = bioPassRepo.getWebsite()
        }
    }

}

class BioPassViewModelFactory(private val application: Application) : ViewModelProvider.Factory{
    @Suppress("NOT_CHECKED")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BioPassViewModel::class.java)){
            return BioPassViewModel(
                bioPassRepo = BioPassRepoImpl(
                    apiClient = ApiClient,
                    application = application
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}