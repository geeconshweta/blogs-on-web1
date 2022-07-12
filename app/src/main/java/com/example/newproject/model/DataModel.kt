package com.example.newproject.model

class DataModel {

    var imageName: String? = null
    var imageId: String? = null
    var textname:String? =null
    var  imagename:String? =null
    var valuename: String? =null
    var imagem:String?=null
    var id:String?=null
    var image:String?=null
    var author_full_name:String?=null
    var title:String?=null
    var short_description:String?=null
    var description:String?=null
    var tags:String?=null



    constructor(imageName: String?, imageId: String?,textname: String?) {
        this.imageName = imageName
        this.imageId = imageId
        this.textname =textname



    }


    constructor(imageName: String?, imageId: String?) {
        this.imageName = imageName
        this.imageId = imageId
    }

    constructor(valuename: String?) {
        this.valuename = valuename
    }

    constructor(imageName: String?, imageId: String?, textname: String?, valuename: String?,id:String?) {
        this.imageName = imageName
        this.imageId = imageId
        this.textname = textname
        this.valuename = valuename
        this.id=id
    }

    constructor()
    constructor(imageName: String?, imageId: String?, textname: String?, valuename: String?) {
        this.imageName = imageName
        this.imageId = imageId
        this.textname = textname
        this.valuename = valuename
    }

    constructor(
        imageName: String?,
        imageId: String?,
        textname: String?,
        imagename: String?,
        valuename: String?,
        id: String?
    ) {
        this.imageName = imageName
        this.imageId = imageId
        this.textname = textname
        this.imagename = imagename
        this.valuename = valuename
        this.id = id
    }


}