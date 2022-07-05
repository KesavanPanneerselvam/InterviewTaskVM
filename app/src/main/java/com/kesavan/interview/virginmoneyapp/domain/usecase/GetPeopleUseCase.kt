package com.kesavan.interview.virginmoneyapp.domain.usecase

import com.kesavan.interview.virginmoneyapp.domain.model.PeopleItem
import com.kesavan.interview.virginmoneyapp.domain.repository.VMARepository
import com.kesavan.interview.virginmoneyapp.domain.usecase.base.UseCase

class GetPeopleUseCase constructor(
    private val vmaRepository: VMARepository
) : UseCase<List<PeopleItem>, Any?>() {

    override suspend fun run(params: Any?): List<PeopleItem> {
        return vmaRepository.getPeople()
    }

}