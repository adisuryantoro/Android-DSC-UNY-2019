package com.seedgrow.dscuny2019.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.seedgrow.dscuny2019.R
import com.seedgrow.dscuny2019.glide.GlideApp
import com.seedgrow.dscuny2019.model.DataHeroModel
import kotlinx.android.synthetic.main.item_grid_hero.view.*

class GridHeroAdapter(private val listHero: ArrayList<DataHeroModel>) : RecyclerView.Adapter<GridHeroAdapter.GridViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GridViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_hero, parent, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int = listHero.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    inner class GridViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(dataHeroModel: DataHeroModel ) {
            with(itemView){
                GlideApp.with(itemView.context)
                    .load(dataHeroModel.image)
                    .apply(RequestOptions().override(350, 550))
                    .into(iv_item_grid_hero)
//                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(hero) }
            }
        }
    }


}