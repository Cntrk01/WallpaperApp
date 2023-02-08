package com.example.wallpaperappmvvmpexelapi.api

import com.example.wallpaperapppexelapi.model.WallPaperResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {
    @Headers("Authorization: iL7fRpSsFeKT1YRbueRBqi1mS9vVNeGsJAjxwMg4tuBXMZqhf5WbdCpB")
    @GET("search")
    suspend fun getWallPaper(
        @Query("query")query:String,
        //DİKKAT !!!!page yerine per_page yazmışım ondan dolayı veriler  kopyalanmış yükleniyordu
        @Query("page")perpage:Int
    ) : Response<WallPaperResponse>
}