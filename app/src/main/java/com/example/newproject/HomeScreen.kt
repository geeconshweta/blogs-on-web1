package com.example.newproject

import android.app.ProgressDialog
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newproject.adapter.BusinessAdapter
import com.example.newproject.adapter.TagBlogAdapter
import com.example.newproject.model.*
import com.example.newproject.network.Api
import com.example.newproject.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeScreen : AppCompatActivity() {
    private var api: Api? = null
    private var datamodel = ArrayList<DataModel>()
    private var datamodel1 = ArrayList<DataModel>()

    private lateinit var temperArrayList:ArrayList<DataModel>
    private lateinit var recyclerBuss: RecyclerView
    private lateinit var rcvhome: RecyclerView
    private lateinit var imgnavig: ImageView
    private lateinit var img_navig: ImageView
    private lateinit var userid: String
    private lateinit var profileimg: ImageView
    private lateinit var event_id: String

    private lateinit var progressDialog: ProgressDialog
    private var sharedPreferences: SharedPreferences? = null
    private var statusLogin: String? = null
    private  var profilepic:String?=null
    private lateinit var businessAdapter: BusinessAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        api = ApiClient.client?.create(Api::class.java)
        recyclerBuss = findViewById(R.id.rcv_bussbutton)
        rcvhome = findViewById(R.id.rcv_home)
        imgnavig = findViewById(R.id.img_navig)
        profileimg=findViewById(R.id.profileimg)

        temperArrayList= arrayListOf<DataModel>()
        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Loading!...please wait")
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        progressDialog.isIndeterminate = true
        progressDialog.setCanceledOnTouchOutside(false)
        progressDialog.setCancelable(false)
        progressDialog.create()


        var visible = true
        sharedPreferences = getSharedPreferences("Prefers", Context.MODE_PRIVATE)
//        statusLogin = sharedPreferences!!.getString("statusLogin", null)
        userid = sharedPreferences!!.getString("userid", "").toString()
        profilepic =sharedPreferences!!.getString("profile_pic","").toString()
        event_id = sharedPreferences!!.getString("eventid", "").toString()
//        Glide.with(this).load(profilepic).error(R.drawable.ic_baseline_person_pin_24).circleCrop()
//            .into(profileimg)

        val home1 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerBuss.layoutManager = home1

        val linearLayoutManager = LinearLayoutManager(this)
        rcvhome.layoutManager = linearLayoutManager
        datamodel.clear()

        datamodel1.clear()
        datamodel.clear()
        demo1()
        demo2()

    }


    private fun demo2() {
        val tagBlogRequest = TagBlogRequest("getTagsForBlogs")
        val call1 = api?.getTagsBlogs(tagBlogRequest)
        call1?.enqueue(object : Callback<TagBlogResponse?> {
            override fun onResponse(
                call: Call<TagBlogResponse?>,
                response: Response<TagBlogResponse?>
            ) {
                if (response.isSuccessful) {
                    datamodel.clear()
                    progressDialog.dismiss()
                    val model = response.body()
                    val success = model!!.success
                    if (success == "1") {
                        val data = model.dataList
                        for (k in data.indices) {
                            datamodel1.add(
                                DataModel(
                                    data[k].value
                                ))}
                        val tagBlogAdapter = TagBlogAdapter(this@HomeScreen, datamodel1)
                        recyclerBuss.adapter = tagBlogAdapter//recyclerMainScreen.setAdapter(mainScreenAdapter);
                        tagBlogAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<TagBlogResponse?>, t: Throwable) {
                progressDialog.dismiss()
            }
        }
        )
    }

    private fun demo1() {
        val blogTagRequest = BlogTagRequest("getBlogsBasedOnTags",)
        val call = api?.getBlogsTag(blogTagRequest)
        call?.enqueue(object : Callback<BlogTagResponse> {
            override fun onResponse(
                call: Call<BlogTagResponse>,
                response: Response<BlogTagResponse>
            ) {
                if (response.isSuccessful) {
                    val model = response.body()
                    val success = model!!.success
                    if (success == "1") {
                        val data = model.dataList
                        for (k in data.indices) {
                            val editor= sharedPreferences!!.edit()
                            editor.putString("blogsbasedonid",data[k].id)
                            editor.commit()
                            datamodel.add(
                                DataModel(
                                    data[k].title,
                                    data[k].image,
                                    data[k].description,
                                    data[k].created_on,
                                    data[k].author_full_name,
                                    data[k].id
                                ))
                            Log.d("checkdate", "onResponse: ${data[k].created_on}")
                            temperArrayList.add(
                                DataModel(data[k].title,
                                    data[k].image,
                                    data[k].description,
                                    data[k].created_on,
                                    data[k].author_full_name,
                                    data[k].id)


                            )

                        }

                        businessAdapter = BusinessAdapter(this@HomeScreen, datamodel)
                        rcvhome.adapter = businessAdapter//recyclerMainScreen.setAdapter(mainScreenAdapter);
                        businessAdapter.notifyDataSetChanged()
                        getfilter()
//
                    }
                }
            }

            override fun onFailure(call: Call<BlogTagResponse>, t: Throwable) {
            }
        }

        )
    }

    private fun getfilter() {




    }


    fun getBlogsBasedOnTagsFilter(valuename: String?) {
        val blogbussinesstagRequest = BlogbussinesstagRequest("getBlogsBasedOnTags", "$valuename")
        val call = api?.getBlogbussinesstag1(blogbussinesstagRequest)
        call?.enqueue(object : Callback<BlogbussinesstagResponse> {
            override fun onResponse(
                call: Call<BlogbussinesstagResponse>,
                response: Response<BlogbussinesstagResponse>
            ) {
                if (response.isSuccessful) {
                    val model = response.body()
                    val success = model!!.success
                    if (success == "1") {
                        datamodel.clear()
                        val data = model.dataList
                        for (k in data.indices) {
                            datamodel.add(
                                DataModel(
                                    data[k].title,
                                    data[k].image,
                                    data[k].short_description,
                                    data[k].created_on,

                                    )
                            )
                        }
                        businessAdapter = BusinessAdapter(this@HomeScreen, datamodel)
                        rcvhome.adapter =
                            businessAdapter//recyclerMainScreen.setAdapter(mainScreenAdapter);
                        businessAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<BlogbussinesstagResponse>, t: Throwable) {
            }
        }

        )
    }
}