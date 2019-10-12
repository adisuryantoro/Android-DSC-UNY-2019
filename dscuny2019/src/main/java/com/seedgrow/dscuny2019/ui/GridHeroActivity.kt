package com.seedgrow.dscuny2019.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.seedgrow.dscuny2019.R
import com.seedgrow.dscuny2019.adapter.GridHeroAdapter
import com.seedgrow.dscuny2019.model.DataHeroModel
import kotlinx.android.synthetic.main.activity_grid_hero.*
import kotlinx.android.synthetic.main.activity_list_hero.*

class GridHeroActivity : AppCompatActivity() {

    private val listDataHero = ArrayList<DataHeroModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_hero)

        rv_activity_grid.setHasFixedSize(true)

        listDataHero.addAll(getListMovies())

        showRecyclerGrid()

    }

    private fun getListMovies(): ArrayList<DataHeroModel> {
        val image = resources.getStringArray(R.array.data_photo)
        val title = resources.getStringArray(R.array.data_name)
        val birthday = resources.getStringArray(R.array.data_birthday)
        val description = resources.getStringArray(R.array.data_description)

        val listMovie = ArrayList<DataHeroModel>()
        for (position in title.indices){
            val dataMovie = DataHeroModel(
                image[position],
                title[position],
                birthday[position],
                description[position]
            )
            listMovie.add(dataMovie)
        }
        return listMovie


    }

    private fun showRecyclerGrid() {
        rv_activity_grid.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter = GridHeroAdapter(listDataHero)
        rv_activity_grid.adapter = gridHeroAdapter
    }
}
