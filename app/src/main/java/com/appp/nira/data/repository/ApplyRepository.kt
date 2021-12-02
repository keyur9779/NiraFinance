package com.appp.nira.data.repository

import androidx.annotation.WorkerThread
import com.appp.nira.data.apppref.AppPrefConfig
import com.appp.nira.models.ImageModel
import com.appp.nira.utils.extension.Results
import com.appp.nira.utils.imageURLs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ApplyRepository {


    @WorkerThread
    fun updateAppState() = flow {

        AppPrefConfig.pref.isValidSession = false

        emit(Results.Success(true))

    }.flowOn(Dispatchers.IO)


    @WorkerThread
    fun fetchUserList() = flow {

        val items = java.util.ArrayList<ImageModel>()

        for (i in 0..5) {
            items.add(ImageModel(imageURLs[i % imageURLs.size]))
        }
        emit(Results.Success(items))
    }.flowOn(Dispatchers.IO)


}
