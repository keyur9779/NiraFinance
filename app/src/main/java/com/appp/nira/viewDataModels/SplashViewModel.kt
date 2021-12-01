package com.appp.nira.viewDataModels

import androidx.lifecycle.ViewModel
import com.appp.nira.data.repository.SplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class SplashViewModel @Inject constructor(val splashRepository: SplashRepository) : ViewModel() {


    init {
        Timber.d("Injection done")
    }


    val getSession: Boolean
        get() = splashRepository.getSession()


}