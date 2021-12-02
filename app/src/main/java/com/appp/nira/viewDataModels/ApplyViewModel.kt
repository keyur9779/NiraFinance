package com.appp.nira.viewDataModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.appp.nira.data.repository.ApplyRepository
import com.appp.nira.models.ImageModel
import com.appp.nira.utils.extension.Results
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import java.util.*
import javax.inject.Inject


@HiltViewModel
class ApplyViewModel @Inject constructor(val applyRepository: ApplyRepository) :
    ViewModel() {


    init {
        Timber.d("Injection done")
    }

    fun saveActivityState(): LiveData<Results.Success<Boolean>> {

        return applyRepository
            .updateAppState()
            .asLiveData(viewModelScope.coroutineContext)
    }

    private val getUserList = applyRepository
        .fetchUserList().asLiveData(viewModelScope.coroutineContext)


    val loadUserList: LiveData<Results.Success<ArrayList<ImageModel>>>
        get() = getUserList


}