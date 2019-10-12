package com.seedgrow.dscuny2019

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.seedgrow.dscuny2019.utils.Constans
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var username: String? = null
    private var password: String? = null
    private var sharedPreferences: SharedPreferences? = null

    @SuppressLint("ApplySharedPref")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //SharedPreference
        sharedPreferences = getSharedPreferences(Constans.DATA_USER, Context.MODE_PRIVATE)

        intent = Intent(this, MainActivity::class.java)

        if (sharedPreferences!!.contains("username") && sharedPreferences!!.contains("password")) {
            startActivity(intent)
            finish()
        }
    }

    @SuppressLint("ApplySharedPref")
    fun login(view: View) {
        username = edt_activity_login_username.text.toString()
        password = edt_activity_login_password.text.toString()

        if (username.equals("adisuryantoro") && password.equals("DSCUNY2019")) {
            val editor = sharedPreferences?.edit()
            editor?.putString("username", username)
            editor?.putString("password", password)
            editor?.commit()

            startActivity(intent)
            finish()

        } else if (username!!.isEmpty() || password!!.isEmpty()) {
            toastPopUp("Please Insert Email and Password")

        } else {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("User Name & Password Salah")
                .setNegativeButton("Coba Lagi", null).create().show()
        }

//    fun login(view: View){
//        username = edt_activity_login_username.text.toString()
//        password = edt_activity_login_password.text.toString()
//
//        if (username!!.isEmpty()|| password!!.isEmpty()) {
//            Toast.makeText(this, "Please Insert Email and Password", Toast.LENGTH_SHORT).show()
//        }
//        if(username == "adisuryantoro" && password == "dscuny2019"){
//            val progressDialog = ProgressDialog(this, R.style.Theme_MaterialComponents_Light_Dialog)
//            progressDialog.isIndeterminate = true
//            progressDialog.setMessage("Loading...")
//            progressDialog.show()
//            val intent = Intent (this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//    }
    }

    fun toastPopUp(message: String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}
