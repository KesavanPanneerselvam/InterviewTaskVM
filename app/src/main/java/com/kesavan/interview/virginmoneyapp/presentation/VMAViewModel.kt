package com.kesavan.interview.virginmoneyapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kesavan.interview.virginmoneyapp.domain.model.ApiError
import com.kesavan.interview.virginmoneyapp.domain.model.PeopleItem
import com.kesavan.interview.virginmoneyapp.domain.model.RoomItem
import com.kesavan.interview.virginmoneyapp.domain.model.UNKNOWN_ERROR_MESSAGE
import com.kesavan.interview.virginmoneyapp.domain.usecase.GetPeopleUseCase
import com.kesavan.interview.virginmoneyapp.domain.usecase.GetRoomsUseCase
import com.kesavan.interview.virginmoneyapp.domain.usecase.base.UseCaseResponse
import com.kesavan.interview.virginmoneyapp.utils.UIState
import kotlinx.coroutines.cancel

class VMAViewModel  constructor(private val getPeopleUseCase: GetPeopleUseCase,private val getRoomsUseCase: GetRoomsUseCase) : ViewModel() {

    private var _responseState: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING())
    val responseState: LiveData<UIState> get()  = _responseState

    fun getPeople() {
        _responseState.postValue(UIState.LOADING())
        getPeopleUseCase.invoke(viewModelScope, null, object : UseCaseResponse<List<PeopleItem>> {
            override fun onSuccess(result: List<PeopleItem>) {
                _responseState.postValue(UIState.SUCCESS(result))
            }

            override fun onError(apiError: ApiError?) {
                _responseState.postValue( UIState.ERROR(apiError?.getErrorMessage()?: UNKNOWN_ERROR_MESSAGE ))
            }
        },
        )
    }

    fun getRooms() {
        _responseState.postValue(UIState.LOADING())
        getRoomsUseCase.invoke(viewModelScope, null, object : UseCaseResponse<List<RoomItem>> {
            override fun onSuccess(result: List<RoomItem>) {
                _responseState.postValue(UIState.SUCCESS(result))
            }

            override fun onError(apiError: ApiError?) {
                _responseState.postValue( UIState.ERROR(apiError?.getErrorMessage()?: UNKNOWN_ERROR_MESSAGE ))
            }
        },
        )
    }
    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }

}