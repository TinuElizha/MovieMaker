package com.tinu.moviemaker.home

import androidx.lifecycle.viewModelScope
import com.tinu.moviemaker.base.BaseViewModel
import com.tinu.moviemaker.data.repository.HomeRepository
import com.tinu.moviemaker.data.response.Content
import kotlinx.coroutines.launch
import java.util.logging.Filter

class HomeViewModel(
    private val repository: HomeRepository
) : BaseViewModel(repository) {
    lateinit var newItemList: ArrayList<Content?>

    val movieDataList = repository.movieList
    val movieDataListSecond = repository.movieListSecond



    fun filterData(input: String): ArrayList<Content?> {
        viewModelScope.launch {
            newItemList = ArrayList<Content?>()
            for (item in movieDataList) {

                if (item?.name?.toLowerCase()?.contains(input.toLowerCase())!!) {
                 //  newItemList.toMutableList().add(item)
                  newItemList.add(item)

                }
                else{
                    continue
                }
            }

        }
        return newItemList;
    }


}