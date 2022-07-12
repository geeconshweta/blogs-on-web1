package com.example.newproject.model

class LoginRequest {
    private var view: String? = null
    private var username: String? = null
    private var password: String? = null

    constructor(view: String?, username: String?, password: String?) {
        this.view = view
        this.username = username
        this.password = password
    }


}