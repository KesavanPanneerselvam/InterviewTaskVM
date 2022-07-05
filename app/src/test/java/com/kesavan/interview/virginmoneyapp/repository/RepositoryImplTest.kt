package com.kesavan.interview.virginmoneyapp.repository


import com.kesavan.interview.virginmoneyapp.data.repository.VMARepositoryImpl
import com.kesavan.interview.virginmoneyapp.domain.model.PeopleItem
import com.kesavan.interview.virginmoneyapp.domain.model.RoomItem
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test

class RepositoryImplTest {

    @MockK
    lateinit var vmaRepository: VMARepositoryImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this) //for initialization
    }

    @Test
    fun getPeopleData() = runBlocking {
        val peopleList = mockk<List<PeopleItem>>()
        every { runBlocking { vmaRepository.getPeople() } } returns (peopleList)

        val result = vmaRepository.getPeople()
        MatcherAssert.assertThat(
            "Received result [$result] & mocked [$peopleList] must be matches on each other!",
            result,
            CoreMatchers.`is`(peopleList)
        )
    }

    @Test
    fun getRoomData() = runBlocking {
        val roomList = mockk<List<RoomItem>>()
        every { runBlocking { vmaRepository.getRooms() } } returns (roomList)

        val result = vmaRepository.getRooms()
        MatcherAssert.assertThat(
            "Received result [$result] & mocked [$roomList] must be matches on each other!",
            result,
            CoreMatchers.`is`(roomList)
        )
    }
}