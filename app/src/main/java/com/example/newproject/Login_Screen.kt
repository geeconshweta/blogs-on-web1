package com.example.newproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.newproject.model.LoginRequest
import com.example.newproject.model.LoginResponseModel
import com.example.newproject.network.Api
import com.example.newproject.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login_Screen : AppCompatActivity() {

    private var sharedPreferences: SharedPreferences? = null

    private var api: Api? = null
    //1 casting
    private lateinit var lgUsername: EditText
    private lateinit var lgPass: EditText
    private lateinit var forgetpass: TextView
    private lateinit var btnLgn: AppCompatButton
    private lateinit var regsbutton: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

//        api = ApiClient.client?.create(Api::class.java)
        api = ApiClient.client?.create(Api::class.java)

        sharedPreferences = getSharedPreferences("Prefers", Context.MODE_PRIVATE)

        //2 initialization
        lgUsername = findViewById(R.id.lg_username)
        lgPass = findViewById(R.id.lg_pass)
        btnLgn = findViewById(R.id.btnlogin)
        regsbutton = findViewById(R.id.lg_rgst)
        forgetpass=findViewById(R.id.fgt_pass)


        btnLgn.setOnClickListener {

            if (lgUsername.text.toString().isNullOrEmpty()) {
                Toast.makeText(this, "Please enter user name", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (lgPass.text.toString().isNullOrEmpty()) {
                Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            //7th pass our parameters
            val loginRequest = LoginRequest(
                "validateLogin",
                lgUsername.text.toString().trim(),
                lgPass.text.toString().trim()
            )

            //Api call

            val call = api?.validateLogin(loginRequest)
            call?.enqueue(object : Callback<LoginResponseModel?> {
                override fun onResponse(
                    call: Call<LoginResponseModel?>,
                    response: Response<LoginResponseModel?>
                ) {
                    if (response.isSuccessful) {
                        val model = response.body()
                        val status = model!!.status
                        val message = model.message
                        if (status.equals("1") && message.equals("Login Successful")) {
                            Toast.makeText(this@Login_Screen,"Login Successsfully", Toast.LENGTH_LONG).show()
                            val data = model.data
                            val user_id = data!!.user_id
                            val username=data.user_first_name
                            val login = data.login
                            val user_first_name = data.user_first_name
                            val user_last_name = data.user_last_name
                            val user_organization = data.user_organization
                            val user_email = data.user_email
                            val user_phone = data.user_phone
//                            val fname=data.user_first_name
//                            val lstname=data.user_last_name
//                            val email=data.user_email
//                            val phone=data.user_phone
                            val profile_pic=data.profile_pic
//                            val organization=data.user_organization
                            //sharedpreferences
                            val editor: SharedPreferences.Editor = sharedPreferences!!.edit()
                            editor.putString("statusLogin", message)
                            editor.putString("userid",user_id)
                            editor.putString("user_first_name",user_first_name)
                            editor.putString("user_last_name",user_last_name)
                            editor.putString("user_email",user_email)
                            editor.putString("user_phone",user_phone)
                            editor.putString("profile_pic",profile_pic)
//                            editor.putString("organization",organization)
                            editor.commit()

                            val i = Intent(this@Login_Screen, HomeScreen::class.java)
                            startActivity(i)
                            finish()
                        } else if (status.equals("0")) {
                            Toast.makeText(this@Login_Screen, message, Toast.LENGTH_LONG).show()

                        }
                    }
                }

                override fun onFailure(call: Call<LoginResponseModel?>, t: Throwable) {
                    Toast.makeText(this@Login_Screen, "Something went wrong", Toast.LENGTH_LONG)
                        .show()
                }

            }
            )
//            val call = api?.userLgn(loginRequest)
//            call?.eneque(object :Callback<LoginResponseModal?>)


        }

    }


    }
