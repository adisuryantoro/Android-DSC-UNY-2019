package com.seedgrow.dscuny2019.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.seedgrow.dscuny2019.R
import com.seedgrow.dscuny2019.glide.GlideApp
import com.seedgrow.dscuny2019.model.DataHeroModel
import com.seedgrow.dscuny2019.ui.DetailActivity
import com.seedgrow.dscuny2019.utils.Constans
import kotlinx.android.synthetic.main.item_list_hero.view.*

class ListHeroAdapter(private val listMovie: ArrayList<DataHeroModel>): RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_hero, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    override fun getItemCount(): Int = listMovie.size

    inner class ListViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {
       fun bind(dataMovieModel: DataHeroModel){
           with(itemView){
               GlideApp.with(itemView.context)
                   .load(dataMovieModel.image)
                   .apply(RequestOptions().override(60, 60))
                   .into(iv_item_list_hero_image)

               tv_item_list_hero_title.text = dataMovieModel.name
               tv_item_list_hero_birthday.text = dataMovieModel.birthday

               btn_item_list_hero_detail.setOnClickListener {
                   val intent = Intent(itemView.context, DetailActivity::class.java)
                   intent.putExtra(Constans.IMAGE, dataMovieModel.image)
                   intent.putExtra(Constans.NAME, dataMovieModel.name)
                   intent.putExtra(Constans.BIRTHDAY, dataMovieModel.birthday)
                   intent.putExtra(Constans.DESCRIPTION, dataMovieModel.description)
                   itemView.context.startActivity(intent)
               }
           }

       }
    }
}