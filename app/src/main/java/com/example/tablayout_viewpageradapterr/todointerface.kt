package com.example.tablayout_viewpageradapterr

//interface todointerface {
//}
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface todointerface {

    @GET("/todos")
    fun getAllposts(): Observable<List<TodoModel>>

    companion object Factory{
        fun createRetrofit(): todointerface? {
            val retrofit= Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build()
            return (retrofit.create(todointerface::class.java))
        }
    }
}