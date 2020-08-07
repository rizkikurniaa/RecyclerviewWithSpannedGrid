package com.kikulabs.recyclerviewwithspannedgrid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kikulabs.recyclerviewwithspannedgrid.R
import com.kikulabs.recyclerviewwithspannedgrid.model.DataPhoto

class SpannedGridTourismAdapter(private val listHeroes: ArrayList<DataPhoto>) :
    RecyclerView.Adapter<SpannedGridTourismAdapter.GridViewHolder>() {

    inner class GridViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.iv_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_spanned_grid, parent, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHeroes.size
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listHeroes[position].photo)
            .into(holder.imgPhoto)

    }
}