package com.kesavan.interview.virginmoneyapp.domain.usecase.base

import com.kesavan.interview.virginmoneyapp.domain.model.ApiError

interface UseCaseResponse <Type> {

    fun onSuccess(result: Type)

    fun onError(apiError: ApiError?)
}

