package com.appp.nira.data.repository

import androidx.annotation.WorkerThread
import com.appp.nira.utils.extension.Results
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class OtpRepository {


    @WorkerThread
    fun validateMobileNumber(number: String) = flow {
        kotlinx.coroutines.delay(1000)
        emit(Results.Success(true))
    }.flowOn(Dispatchers.IO)


}
