package com.lukaszwroblak.simplenetworkapplication.repository

/**
 * Created by lukaszwroblak on 11.11.2018.
 */

import com.google.gson.GsonBuilder
import com.lukaszwroblak.simplenetworkapplication.datamodel.ElementBase
import com.lukaszwroblak.simplenetworkapplication.datamodel.ElementDetails
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

inline fun <reified T> api(): T {

    val gsonBuilder = GsonBuilder().setLenient()
    gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss")

    val client = OkHttpClient.Builder()

    val retrofit = Retrofit.Builder()
            .client(client.build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
            .baseUrl("http://dev.tapptic.com")
            .build()

    return retrofit.create(T::class.java)
}

interface NetApi {

    @GET("/test/json.php")
    fun getList(): Observable<List<ElementBase>>

    @GET("/test/json.php")
    fun getDetails(@Query("name") query: String): Observable<ElementDetails>

}