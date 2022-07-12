package com.example.newproject.network

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

object ApiRestCliten {


    private var gitApiInterface: RBApiInterface? = null
    private const val baseUrl = "https://www.blogsonweb.com/res/"
    val client: RBApiInterface?
        get() {
            if (gitApiInterface == null) {
          val client = OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .addInterceptor { chain ->
                        val original = chain.request()
                        val request = original.newBuilder()
                            .method(original.method(), original.body())
                            .build()
                        chain.proceed(request)
                    }.build()
                val retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(client)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                gitApiInterface = retrofit.create(
                    RBApiInterface::class.java
                )
            }
            return gitApiInterface
        }

    interface RBApiInterface {
        @FormUrlEncoded
        @POST("RestController.php")
        fun getDomain(
            @Field("view") view: String?,
            @Field("domain_cd") domain_cd: String?
        ): Call<Any?>?


    }

}