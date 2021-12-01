package com.appp.nira.data.repository

import com.appp.nira.data.apppref.AppPrefConfig

class SplashRepository {


    fun getSession(): Boolean = AppPrefConfig.pref.isValidSession


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
