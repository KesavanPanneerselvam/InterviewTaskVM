package com.kesavan.interview.virginmoneyapp.data.repository

import com.kesavan.interview.virginmoneyapp.data.remote.VMApiService
import com.kesavan.interview.virginmoneyapp.domain.model.PeopleItem
import com.kesavan.interview.virginmoneyapp.domain.model.RoomItem
import com.kesavan.interview.virginmoneyapp.domain.repository.VMARepository

class VMARepositoryImpl (private val apiService: VMApiService) : VMARepository {

    override suspend fun getPeople(): List<PeopleItem> {
        return apiService.getPeople()
    }

    override suspend fun getRooms(): List<RoomItem> {
        return apiService.getRooms()
    }
}