package com.kshitijpatil.data.android

import com.kshitijpatil.api.MockApi
import com.kshitijpatil.data.Member
import javax.inject.Inject

class MainRepository
constructor(
    private val api: MockApi
) {
    fun getData(): List<Member> {
        return api.data
    }
}