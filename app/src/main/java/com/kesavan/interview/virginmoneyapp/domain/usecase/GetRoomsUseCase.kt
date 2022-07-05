package com.kesavan.interview.virginmoneyapp.domain.usecase

import com.kesavan.interview.virginmoneyapp.domain.model.RoomItem
import com.kesavan.interview.virginmoneyapp.domain.repository.VMARepository
import com.kesavan.interview.virginmoneyapp.domain.usecase.base.UseCase

class GetRoomsUseCase constructor(
    private val vmaRepository: VMARepository
) : UseCase<List<RoomItem>, Any?>() {

    override suspend fun run(params: Any?): List<RoomItem> {
        return vmaRepository.getRooms()
    }
}