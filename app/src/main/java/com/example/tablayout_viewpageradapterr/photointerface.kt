package com.example.tablayout_viewpageradapterr

//interface photointerface {
//}




import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface photointerface {

    @GET("/photos")
    fun getAllposts(): Observable<List<photoModel>>

    companion object Factory{
        fun createRetrofit(): photointerface? {
            val retrofit= Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build()
            return (retrofit.create(photointerface::class.java))
        }
    }
}