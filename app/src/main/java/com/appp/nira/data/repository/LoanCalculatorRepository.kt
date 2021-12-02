package com.appp.nira.data.repository

import android.util.Log
import androidx.annotation.WorkerThread
import com.appp.nira.models.LoanPlannerModel
import com.appp.nira.utils.extension.Results
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class LoanCalculatorRepository {


    @WorkerThread
    fun getLoadData() = flow {
        Log.d("keyur", "is recteaed nwe oan")
        val loanPlannerModel = LoanPlannerModel()
        val amount =
            (loanPlannerModel.interest * loanPlannerModel.tenurDefault * loanPlannerModel.defaultLoanAmount) / 100
        val finalValue = amount + loanPlannerModel.defaultLoanAmount

        loanPlannerModel.amount = finalValue
        emit(Results.Success(loanPlannerModel))
    }.flowOn(Dispatchers.IO)

    @WorkerThread
    fun calculateLoanAmount(loanPlannerModel: LoanPlannerModel, amount: Int) = flow {

        val simpleIntrest =
            (loanPlannerModel.interest * loanPlannerModel.tenurDefault * amount) / 100  //P*R*T

        val finalValue = amount + simpleIntrest
        loanPlannerModel.amount = finalValue
        loanPlannerModel.defaultLoanAmount = amount
        emit(Results.Success(loanPlannerModel))

    }.flowOn(Dispatchers.IO)

    @WorkerThread
    fun calculateLoanAmountTenure(loanPlannerModel: LoanPlannerModel, tenure: Int) = flow {

        val simpleIntrest =
            (loanPlannerModel.interest * loanPlannerModel.defaultLoanAmount * tenure) / 100  //P*R*T

        val finalValue = loanPlannerModel.defaultLoanAmount + simpleIntrest
        loanPlannerModel.amount = finalValue
        loanPlannerModel.tenurDefault = tenure
        emit(Results.Success(loanPlannerModel))

    }.flowOn(Dispatchers.IO)


/*

int no = 124750;
String str = String.format("%,d", no);

//str = 124,750
    @WorkerThread
    fun loadGenreList() = flow {
        val genre = genreDao.getGenreList()
        if (genre.isNullOrEmpty()) {
            val response = genreService.fetchGenre()
            response.suspendOnSuccess {
                genreDao.insertGenre(data.genres)
                emit(Results.Success(data.genres))
            }
        } else {
            emit(Results.Success(genre))
        }
    }.flowOn(Dispatchers.IO)
*/

}
