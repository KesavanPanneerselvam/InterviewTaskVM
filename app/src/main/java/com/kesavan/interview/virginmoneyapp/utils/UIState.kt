package com.kesavan.interview.virginmoneyapp.utils

sealed class UIState{
    class LOADING(val isLoading:Boolean=true) : UIState()
    class SUCCESS(val response: Any): UIState()
    class ERROR(val error: String): UIState()
}