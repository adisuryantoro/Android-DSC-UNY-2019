package com.seedgrow.dscuny2019.ui

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.seedgrow.dscuny2019.R
import com.seedgrow.dscuny2019.glide.GlideApp
import com.seedgrow.dscuny2019.utils.Constans
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        setSupportActionBar(toolbar)

        GlideApp.with(this)
            .load(intent.getStringExtra(Constans.IMAGE))
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(iv_activity_detail)


        tv_content_detail_description.text = intent.getStringExtra(Constans.DESCRIPTION)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}
