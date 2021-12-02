package com.appp.nira.viewDataModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.appp.nira.data.repository.OtpRepository
import com.appp.nira.utils.extension.Results
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class OtpViewModel @Inject constructor(val otpRepository: OtpRepository) : ViewModel() {


    init {
        Timber.d("Injection done")
    }

    fun validateNumber(number: String): LiveData<Results.Success<Boolean>> {
        return otpRepository
            .validateMobileNumber(number)
            .asLiveData(viewModelScope.coroutineContext)
    }


}