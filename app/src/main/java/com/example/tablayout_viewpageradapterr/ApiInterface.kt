package com.example.tablayout_viewpageradapterr

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    // method @get
    // api end point /posts
    // https://jsonplaceholder.typicode.com/posts

    @GET("/posts")
    fun getAllposts(): Observable<List<PostModelApi>>

    companion object Factory{
        fun createRetrofit():ApiInterface{
            val retrofit=Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build()
            return (retrofit.create(ApiInterface::class.java))
        }
    }
}