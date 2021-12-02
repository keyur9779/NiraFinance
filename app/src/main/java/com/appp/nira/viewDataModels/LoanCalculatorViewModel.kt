package com.appp.nira.viewDataModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.appp.nira.data.repository.LoanCalculatorRepository
import com.appp.nira.models.LoanPlannerModel
import com.appp.nira.utils.extension.Results
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class LoanCalculatorViewModel @Inject constructor(val loadnCalculatorRepository: LoanCalculatorRepository) :
    ViewModel() {


    init {
        Timber.d("Injection done")
    }

    fun updateAmount(amount: Int): LiveData<Results.Success<LoanPlannerModel>> {

        return loadnCalculatorRepository
            .calculateLoanAmount(loanData.value!!.data, amount)
            .asLiveData(viewModelScope.coroutineContext)
    }

    fun updateTenure(tenure: Int): LiveData<Results.Success<LoanPlannerModel>> {

        return loadnCalculatorRepository
            .calculateLoanAmountTenure(loanData.value!!.data, tenure)
            .asLiveData(viewModelScope.coroutineContext)
    }

    private val getLoanData = loadnCalculatorRepository
        .getLoadData().asLiveData(viewModelScope.coroutineContext)


    val loanData: LiveData<Results.Success<LoanPlannerModel>>
        get() = getLoanData


}