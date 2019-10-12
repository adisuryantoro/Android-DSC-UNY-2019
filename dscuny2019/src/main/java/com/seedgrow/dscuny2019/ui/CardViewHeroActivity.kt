package com.seedgrow.dscuny2019.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.seedgrow.dscuny2019.R
import com.seedgrow.dscuny2019.adapter.ListCardHeroAdapter
import com.seedgrow.dscuny2019.model.DataHeroModel
import kotlinx.android.synthetic.main.activity_card_view_hero.*


class CardViewHeroActivity : AppCompatActivity() {

    private val listDataHero = ArrayList<DataHeroModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view_hero)

        rv_activity_card_view.setHasFixedSize(true)

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
        rv_activity_card_view.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListCardHeroAdapter(listDataHero)
        rv_activity_card_view.adapter = listHeroAdapter

    }
}
