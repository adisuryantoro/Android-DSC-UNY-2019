package com.seedgrow.dscuny2019

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //Three Second splash time
        Handler().postDelayed({
            //start MainActivity
            startActivity(Intent(this, ListHeroActivity::class.java))
            //finish this activity
            finish()
        }, 3000)
    }
}
