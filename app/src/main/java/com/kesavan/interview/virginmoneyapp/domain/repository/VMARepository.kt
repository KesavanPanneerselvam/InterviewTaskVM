package com.kesavan.interview.virginmoneyapp.domain.repository

import com.kesavan.interview.virginmoneyapp.domain.model.PeopleItem
import com.kesavan.interview.virginmoneyapp.domain.model.RoomItem

interface VMARepository {
    suspend fun getPeople(): List<PeopleItem>
    suspend fun getRooms(): List<RoomItem>
}