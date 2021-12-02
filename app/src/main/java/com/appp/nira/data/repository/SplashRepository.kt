package com.appp.nira.data.repository

import androidx.annotation.WorkerThread
import com.appp.nira.data.apppref.AppPrefConfig
import com.appp.nira.utils.extension.Results
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class SplashRepository {


    @WorkerThread
    fun getSession() = flow {
        kotlinx.coroutines.delay(1000)
        emit(Results.Success(AppPrefConfig.pref.isValidSession))
    }.flowOn(Dispatchers.IO)


}
