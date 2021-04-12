package com.tinu.moviemaker.base

import androidx.lifecycle.ViewModel
import com.tinu.moviemaker.base.BaseRepository


abstract class BaseViewModel(
    private val repository: BaseRepository
) : ViewModel() {



}