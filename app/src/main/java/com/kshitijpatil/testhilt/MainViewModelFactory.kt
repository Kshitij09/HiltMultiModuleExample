package com.kshitijpatil.testhilt

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kshitijpatil.data.android.Inject

/**
 * Factory for ViewModels
 */
class MainViewModelFactory() : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            val repository = Inject.provideMainRepository()
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}