package com.appp.nira.viewDataModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.appp.nira.data.repository.SplashRepository
import com.appp.nira.utils.extension.Results
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class SplashViewModel @Inject constructor(val splashRepository: SplashRepository) : ViewModel() {


    init {
        Timber.d("Injection done")
    }

    private val getSession = splashRepository
        .getSession().asLiveData(viewModelScope.coroutineContext)


    val appSession: LiveData<Results.Success<Boolean>>
        get() = getSession
/*
    val getSession: Boolean
        get() = splashRepository.getSession()*/


}