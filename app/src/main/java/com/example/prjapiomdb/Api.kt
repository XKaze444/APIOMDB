package com.example.prjapiomdb

import com.example.prjapiomdb.modeldata.SearchData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/")
    fun getMovies(

        @Query("s") s:String?,
        @Query("apikey") apikey:String

    ):Call<SearchData>
}