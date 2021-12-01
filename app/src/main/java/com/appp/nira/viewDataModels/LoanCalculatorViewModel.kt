package com.appp.nira.viewDataModels

import androidx.lifecycle.ViewModel
import com.appp.nira.data.repository.LoanCalculatorRepository
import com.appp.nira.models.LoanPlannerModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class LoanCalculatorViewModel @Inject constructor(val loadnCalculatorRepository: LoanCalculatorRepository) :
    ViewModel() {


    init {
        Timber.d("Injection done")
    }


    val getLoanData: LoanPlannerModel
        get() = loadnCalculatorRepository.getLoadData()


}