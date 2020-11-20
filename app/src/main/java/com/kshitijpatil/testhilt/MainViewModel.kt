package com.kshitijpatil.testhilt

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kshitijpatil.data.DataState
import com.kshitijpatil.data.android.MainRepository
import com.kshitijpatil.data.Member
import com.kshitijpatil.data.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    repository: MainRepository
): ViewModel() {
    lateinit var members: Flow<DataState<List<User>>>
    init {
        viewModelScope.launch {
            members = repository.getUsers()
        }
    }
}