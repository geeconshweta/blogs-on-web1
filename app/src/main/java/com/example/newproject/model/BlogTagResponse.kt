package com.example.newproject.model

import com.google.gson.annotations.SerializedName

class BlogTagResponse {

    @SerializedName("success")
    var success: String? = null

    @SerializedName("data")
    var dataList: List<Data> = ArrayList()

    data class Data(
        @field:SerializedName("id")var id:String,
        @field:SerializedName("user_id")var user_id:String,
        @field:SerializedName("author_full_name")var author_full_name:String,
        @field:SerializedName("title")var title:String,
        @field:SerializedName("friendly_url")var friendly_url:String,
        @field:SerializedName("short_description")var short_description:String,
        @field:SerializedName("image")var image:String,
        @field:SerializedName("description")var description:String,
        @field:SerializedName("categories")var categories:String,
        @field:SerializedName("value")var value:String,
        @field:SerializedName("services")var services:String,
        @field:SerializedName("tools") var tools:String,
        @field:SerializedName("publication_category")var publication_category:String,
        @field:SerializedName("tags")var  tags:String,
        @field:SerializedName("status")var  status: String,
        @field:SerializedName("short_url")var short_url:String,
        @field:SerializedName("featured")var featured:String,
        @field:SerializedName("feature_start_date")var feature_start_date:String,
        @field:SerializedName("feature_end_date")var feature_end_date:String,
        @field:SerializedName("video_attachment")var video_attachment:String,
        @field:SerializedName("audio_attachment")var audio_attachment:String,
        @field:SerializedName("attachment")var attachment:String,
        @field:SerializedName("attachment_type")var attachment_type: String,
        @field:SerializedName("attachment_name")var attachment_name:String,
        @field:SerializedName("sponsor_image")var sponsor_image:String,
        @field:SerializedName("article_type")var article_type:String,
        @field:SerializedName("article") var article:String,
        @field:SerializedName("is_deleted")var is_deleted:String,
        @field:SerializedName("created_by")var created_by:String,
        @field:SerializedName("created_on")var created_on:String,
        @field:SerializedName("updated_by")var updated_by:String,
        @field:SerializedName("updated_on")var updated_on:String,
        @field:SerializedName("content_short")var content_short:String,
        @field:SerializedName("keywords")var keywords:String



    )
}

