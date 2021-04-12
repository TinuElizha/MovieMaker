package com.tinu.moviemaker.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tinu.moviemaker.base.BaseRepository
import com.tinu.moviemaker.data.repository.HomeRepository
import com.tinu.moviemaker.home.HomeViewModel

import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(repository as HomeRepository) as T
            else -> throw IllegalArgumentException("ViewModelClass Not Found")
        }
    }

}