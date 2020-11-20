package com.kshitijpatil.testhilt

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.kshitijpatil.data.android.MainRepository
import com.kshitijpatil.data.Member

class MainViewModel @ViewModelInject constructor(
    repository: MainRepository
): ViewModel() {
    val members: List<Member> = repository.getData()
}