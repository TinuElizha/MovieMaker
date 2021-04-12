package com.tinu.moviemaker.data.repository

import androidx.room.Dao
import com.tinu.moviemaker.base.BaseRepository
import com.tinu.moviemaker.dao.MovieDAO

class HomeRepository(private val dao: MovieDAO):BaseRepository() {

    val movieList = dao.getAllMovieList()
    val movieListSecond = dao.getAllSecondMovieList()


}