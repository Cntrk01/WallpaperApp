package com.example.wallpaperappmvvmpexelapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.wallpaperappmvvmpexelapi.adapter.WallPaperPaging
import com.example.wallpaperappmvvmpexelapi.api.Api
import com.example.wallpaperapppexelapi.model.Photo
import javax.inject.Inject

class HomeFragmentRepo @Inject
constructor(private val api: Api) {
    suspend fun getDataApi(){
        api.getWallPaper("nature",1)
    }

//    private var data : LiveData<PagingData<Photo>>
//    val query = MutableLiveData<String>()
//
//    init {
//        data = MutableLiveData()
//        getWallPaper()
//    }
//
//    fun getWallPaper() {
//        data = query.switchMap {
//            Pager(PagingConfig(pageSize = 10)) {
//                WallPaperPaging(it, api)
//            }.liveData
//
//        }
//    }
//
//    fun setImageName(s: String) {
//        query.postValue(s)
//    }
//
//    fun getData(): LiveData<PagingData<Photo>> {
//        return data
//    }
}
