package com.kesavan.interview.virginmoneyapp.di

import com.kesavan.interview.virginmoneyapp.presentation.VMAViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {

    viewModel { VMAViewModel(get(),get()) }

    single { createGetPeopleUseCase((get())) }

    single { createGetRoomsUseCase((get())) }

    single { createVMARepository(get()) }
}