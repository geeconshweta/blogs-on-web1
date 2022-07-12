package com.example.newproject.model

class BlogbussinesstagRequest {
    private var view: String? = null
    private var tags:String?=null

    constructor(view: String?, tags: String?) {
        this.view = view
        this.tags = tags
    }
}