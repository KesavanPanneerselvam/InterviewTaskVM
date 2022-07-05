package com.kesavan.interview.virginmoneyapp.data.remote

import com.kesavan.interview.virginmoneyapp.domain.model.PeopleItem
import com.kesavan.interview.virginmoneyapp.domain.model.RoomItem
import retrofit2.http.GET

interface VMApiService {

    @GET("/people")
    suspend fun getPeople(): List<PeopleItem>

    @GET("/rooms")
    suspend fun getRooms(): List<RoomItem>
}