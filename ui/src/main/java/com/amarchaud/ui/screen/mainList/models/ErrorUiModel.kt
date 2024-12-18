package com.amarchaud.ui.screen.mainList.models

import android.content.Context
import com.amarchaud.ui.R

sealed class ErrorApiUiModel {
    class ApiServerErrorWithCode(val responseCode: Int, val responseMessage: String) :
        ErrorApiUiModel()

    data object ApiNullBody : ErrorApiUiModel()
    data object ApiGenericServerError : ErrorApiUiModel()
    data object SocketTimeOutError : ErrorApiUiModel()
    data object NoInternetError : ErrorApiUiModel()
    data object GenericError : ErrorApiUiModel()
    data object CancellationError : ErrorApiUiModel()
}

fun ErrorApiUiModel.toMessage(context: Context): String {
    return when (this) {
        is ErrorApiUiModel.ApiGenericServerError -> context.getString(R.string.error_ApiGenericServerError)
        is ErrorApiUiModel.ApiNullBody -> context.getString(R.string.error_ApiNullBody)
        is ErrorApiUiModel.ApiServerErrorWithCode -> context.getString(R.string.error_ApiServerErrorWithCode)
        is ErrorApiUiModel.GenericError -> context.getString(R.string.error_GenericError)
        is ErrorApiUiModel.NoInternetError -> context.getString(R.string.error_NoInternetError)
        is ErrorApiUiModel.SocketTimeOutError -> context.getString(R.string.error_SocketTimeOutError)
        else -> context.getString(R.string.error_ApiGenericServerError)
    }
}


