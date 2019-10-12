package com.seedgrow.dscuny2019.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.seedgrow.dscuny2019.R
import com.seedgrow.dscuny2019.adapter.ListHeroAdapter
import com.seedgrow.dscuny2019.model.DataHeroModel
import kotlinx.android.synthetic.main.activity_list_hero.*

class ListHeroActivity : AppCompatActivity() {

    private val listDataHero = ArrayList<DataHeroModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_hero)

        rv_activity_list.setHasFixedSize(true)

        listDataHero.addAll(getListHeros())

        showRecyclerList()

    }

    private fun getListHeros(): ArrayList<DataHeroModel> {
        val image = resources.getStringArray(R.array.data_photo)
        val title = resources.getStringArray(R.array.data_name)
        val birthday = resources.getStringArray(R.array.data_birthday)
        val description = resources.getStringArray(R.array.data_description)

        val listHero = ArrayList<DataHeroModel>()
        for (position in title.indices){
            val dataHero = DataHeroModel(
                image[position],
                title[position],
                birthday[position],
                description[position]
            )
            listHero.add(dataHero)
        }
        return listHero


    }

    private fun showRecyclerList(){
        rv_activity_list.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(listDataHero)
        rv_activity_list.adapter = listHeroAdapter

    }
}

