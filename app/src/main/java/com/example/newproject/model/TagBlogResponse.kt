package com.example.newproject.model

import com.google.gson.annotations.SerializedName

class TagBlogResponse {

    @SerializedName("success")
    var success: String? = null

    @SerializedName("data")
    var dataList: List<Data> = ArrayList()


    data class Data(
        @field:SerializedName("value")var value:String

    )

}