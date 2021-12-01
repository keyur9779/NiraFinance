package com.appp.nira.data.repository

import androidx.lifecycle.LiveData
import com.appp.nira.data.apppref.AppPrefConfig
import com.appp.nira.models.LoanPlannerModel

class LoanCalculatorRepository {


    fun getLoadData():LoanPlannerModel = LoanPlannerModel()


/*
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
