package com.example.newproject

import android.app.ProgressDialog
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.newproject.model.DataModel
import com.example.newproject.network.Api
import com.example.newproject.network.ApiClient
import com.squareup.picasso.Picasso

class HomeView : AppCompatActivity() {

    private var api: Api? = null
    private lateinit var Image_artcile: ImageView
    private lateinit var Tv_Author: TextView
    private lateinit var meet: TextView
    private lateinit var Tv_discription: TextView
    private lateinit var id: String
    private lateinit var blogid:String
    private lateinit var Tv_Author1: TextView
    private var datamodel = ArrayList<DataModel>()
    private lateinit var progressDialog: ProgressDialog
    private var sharedPreferences: SharedPreferences? = null
    var Author: String? = null
    var Logo: String? = null
    var Title:String?=null
    var image:String?=null
    var Description:String? = null
    var data1:String? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_view)

        api = ApiClient.client?.create(Api::class.java)
        sharedPreferences = getSharedPreferences("Prefers", Context.MODE_PRIVATE)
        blogid = sharedPreferences!!.getString("blogsbasedonid", null).toString()
        id  = sharedPreferences!!.getString("id","null").toString()
        image=sharedPreferences!!.getString("image","").toString()
        Image_artcile = findViewById(R.id.Image_artcile)
        Tv_Author = findViewById(R.id.Tv_Author)
        meet = findViewById(R.id.meet)
        Tv_discription=findViewById(R.id.Tv_discription)
        Tv_Author1 = findViewById(R.id.Tv_Author1)


        val intent = intent
//
//        Glide.with(this).load(image).error(R.drawable.ic_baseline_person_pin_24).into(Image_artcile)

        Logo= intent.getStringExtra("image")
        Picasso.get().load(Logo).error(R.drawable.img).into(Image_artcile)

        Author = intent.getStringExtra("description")
        Tv_Author!!.text =Author
        Title =intent.getStringExtra("author_full_name")
        Tv_Author1!!.text =Title

        data1 = intent.getStringExtra("")
        Tv_discription!!.text  =data1
//
        Description = intent.getStringExtra("title")
        meet!!.text = Description


    }

    }
