package com.kesavan.interview.virginmoneyapp.di

import com.kesavan.interview.virginmoneyapp.BuildConfig
import com.kesavan.interview.virginmoneyapp.data.remote.VMApiService
import com.kesavan.interview.virginmoneyapp.data.repository.VMARepositoryImpl
import com.kesavan.interview.virginmoneyapp.domain.repository.VMARepository
import com.kesavan.interview.virginmoneyapp.domain.usecase.GetPeopleUseCase
import com.kesavan.interview.virginmoneyapp.domain.usecase.GetRoomsUseCase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val TIME_OUT = 30L

val NetworkModule = module {

    single { createService(get()) }

    single { createRetrofit(get(), BuildConfig.BASE_URL) }

    single { createOkHttpClient() }

    single { GsonConverterFactory.create() }

}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient.Builder()
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).build()
}

fun createRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun createService(retrofit: Retrofit): VMApiService {
    return retrofit.create(VMApiService::class.java)
}

fun createVMARepository(apiService: VMApiService): VMARepository {
    return VMARepositoryImpl(apiService)
}

fun createGetPeopleUseCase(postsRepository: VMARepository): GetPeopleUseCase {
    return GetPeopleUseCase(postsRepository)
}

fun createGetRoomsUseCase(postsRepository: VMARepository): GetRoomsUseCase {
    return GetRoomsUseCase(postsRepository)
}
