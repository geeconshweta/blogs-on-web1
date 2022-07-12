package com.example.newproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.newproject.network.Api
import com.example.newproject.network.ApiClient

class MainActivity : AppCompatActivity() {
    private var sharedPreferences: SharedPreferences? = null

    private var api: Api? = null
    //2 create variables for login and register-  data store
    private var statusLogin: String? = null
    private var statusRegister: String? = null
    private lateinit var id:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("Prefers", Context.MODE_PRIVATE)

        //initialize login and regiter status
        api = ApiClient.client?.create(Api::class.java)


        statusLogin = sharedPreferences!!.getString("statusLogin", null)
        statusRegister = sharedPreferences!!.getString("statusRegister", null)

        if (statusLogin != null && statusLogin.equals("Login Successful")) {

            Handler().postDelayed({
                val intent = Intent(this, HomeScreen::class.java)
                startActivity(intent)
                finish()
            }, 3000)
        } else if (statusRegister != null && statusRegister.equals("User Registration Successful")) {

            Handler().postDelayed({
                val intent = Intent(this, HomeScreen::class.java)
                startActivity(intent)
                finish()
            }, 3000)

        }
        else {
            Handler().postDelayed({
                val intent = Intent(this, Login_Screen::class.java)
                startActivity(intent)
                finish()
            }, 3000)
        }
    }


    }
