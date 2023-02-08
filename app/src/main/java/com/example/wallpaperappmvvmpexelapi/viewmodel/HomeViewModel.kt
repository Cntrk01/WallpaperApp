package com.example.wallpaperappmvvmpexelapi.viewmodel

import androidx.lifecycle.*
import androidx.paging.*
import com.example.wallpaperappmvvmpexelapi.adapter.WallPaperPaging
import com.example.wallpaperappmvvmpexelapi.api.Api
import com.example.wallpaperappmvvmpexelapi.repository.HomeFragmentRepo
import com.example.wallpaperapppexelapi.model.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(private val api: Api) : ViewModel() {
    var wallPaperList: LiveData<PagingData<Photo>>
    val query = MutableLiveData<String>()
    init {
        wallPaperList = MutableLiveData()
        setName("nature")
    }



    fun setName(s: String) {
        query.postValue(s)
        wallPaperList=query.switchMap {
            Pager(PagingConfig(1)){
                WallPaperPaging(it,api)
            }.liveData.cachedIn(viewModelScope)
        }
    }

}