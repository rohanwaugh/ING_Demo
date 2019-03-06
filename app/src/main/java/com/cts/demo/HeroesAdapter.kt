package com.cts.demo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recyclerview_layout.view.*

class HeroesAdapter(val mCtx: Context, val heroList: List<Hero>,val clickListener: (Hero) -> Unit) : RecyclerView.Adapter<HeroesAdapter.HeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_layout, parent, false)
        return HeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = heroList[position]
        Glide.with(mCtx).load(hero.imageurl).into(holder.itemView.imageView)
        (holder).bind(heroList[position], clickListener)

    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(hero: Hero, clickListener: (Hero) -> Unit) {
            itemView.textView.text = hero.name
            itemView.setOnClickListener { clickListener(hero)}

        }
    }
}