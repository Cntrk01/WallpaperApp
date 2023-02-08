package com.example.wallpaperappmvvmpexelapi.adapter

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.wallpaperappmvvmpexelapi.api.Api
import com.example.wallpaperapppexelapi.model.Photo

class WallPaperPaging (private val text:String, private val api: Api) : PagingSource<Int, Photo>(){
    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        return try {
            val nextPage=params.key ?: 1
            val getData=api.getWallPaper(text,nextPage)


            LoadResult.Page(
                data=getData.body()?.photos!!,
                prevKey = if(nextPage>0) null else nextPage-1,
                nextKey = nextPage.plus(1)
            )
        }catch (e:Exception){
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }

}