package com.example.tablayout_viewpageradapterr

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface commentinterface {

    @GET("/comments")
    fun getAllposts(): Observable<List<commentModel>>

    companion object Factory{
        fun createRetrofit():commentinterface{
            val retrofit= Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build()
            return (retrofit.create(commentinterface::class.java))
        }
    }
}