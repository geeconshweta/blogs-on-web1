package com.example.newproject.network

import com.example.newproject.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {

    @POST("RestController.php")
    fun validateLogin(@Body loginRequest: LoginRequest): Call<LoginResponseModel>
    @POST("RestController.php")
    fun getBlogsTag(@Body blogTagRequest: BlogTagRequest): Call<BlogTagResponse>

    @POST("RestController.php")
    fun getTagsBlogs(@Body tagBlogRequest: TagBlogRequest): Call<TagBlogResponse>

    @POST("RestController.php")
    fun getBlogbussinesstag1(@Body blogbussinesstagRequest: BlogbussinesstagRequest):Call<BlogbussinesstagResponse>


}