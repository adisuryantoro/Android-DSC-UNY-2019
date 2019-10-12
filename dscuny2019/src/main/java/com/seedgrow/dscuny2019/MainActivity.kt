package com.seedgrow.dscuny2019

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.seedgrow.dscuny2019.ui.CardViewHeroActivity
import com.seedgrow.dscuny2019.ui.GridHeroActivity
import com.seedgrow.dscuny2019.ui.ListHeroActivity
import com.seedgrow.dscuny2019.utils.Constans
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var sharedPreferences: SharedPreferences? = null

    @SuppressLint("ApplySharedPref")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences(Constans.DATA_USER, Context.MODE_PRIVATE)
        intent = Intent(this, LoginActivity::class.java)

        btn_activity_main_recylerview_mode_list.setOnClickListener {
            startActivity<ListHeroActivity>()
        }

        btn_activity_main_recylerview_mode_grid.setOnClickListener {
            startActivity<GridHeroActivity>()
        }

        btn_activity_main_recylerview_mode_card.setOnClickListener {
            startActivity<CardViewHeroActivity>()
        }

        btn_activity_main_logout.setOnClickListener {
            val editor = sharedPreferences!!.edit()
            editor.clear()
            editor.commit()
            startActivity(intent)
            finish()
        }

    }
}
