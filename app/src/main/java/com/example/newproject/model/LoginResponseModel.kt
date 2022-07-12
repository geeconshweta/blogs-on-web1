package com.example.newproject.model

import com.google.gson.annotations.SerializedName

class LoginResponseModel {

    @SerializedName("status")
    var status: String? = null

    @SerializedName("message")
    var message: String? = null

    @SerializedName("data")
    var data: Data? = null

    data class Data(

        @field:SerializedName("user_id")
        var user_id: String,

        @field:SerializedName("login")
        var login: String,

        @field:SerializedName("user_first_name")
        var user_first_name: String,

        @field:SerializedName("user_last_name")
        var user_last_name: String,

        @field:SerializedName("user_organization")
        var user_organization: String,

        @field:SerializedName("user_email")
        var user_email: String,

        @field:SerializedName("user_phone")
        var user_phone: String,

        @field:SerializedName("profile_pic")
        var profile_pic: String




    )
}