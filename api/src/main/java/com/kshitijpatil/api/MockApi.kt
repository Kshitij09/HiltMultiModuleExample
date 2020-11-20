package com.kshitijpatil.api

import com.kshitijpatil.data.Member

class MockApi {
    private val wings = listOf("A", "B", "C", "D", "E")
    private val sampleStatus = listOf("member", "visitor")
    private val sampleFlatNumbers =
        IntRange(100, 120) + IntRange(200, 220) + IntRange(300, 320) + IntRange(400, 420)

    val data: List<Member>
        get() {
            return generateSequence {
                getRandomMember()
            }.take(100).toList()
        }

    private fun getRandomMember(): Member {
        return Member(getRandomFlatNo(),sampleStatus.random())
    }

    private fun getRandomFlatNo(): String {
        val wing = wings.random()
        val number = sampleFlatNumbers.random().toString()
        return wing + number
    }
}