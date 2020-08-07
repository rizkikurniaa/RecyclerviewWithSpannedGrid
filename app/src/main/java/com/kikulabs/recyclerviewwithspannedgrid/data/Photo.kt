package com.kikulabs.recyclerviewwithspannedgrid.data

import com.kikulabs.recyclerviewwithspannedgrid.R
import com.kikulabs.recyclerviewwithspannedgrid.model.DataPhoto

object Photo {
    private val tourismImages = intArrayOf(
        R.drawable.bali2,
        R.drawable.kelok9,
        R.drawable.pulaukomodo,
        R.drawable.myanmar,
        R.drawable.borobudur,
        R.drawable.gililombok,
        R.drawable.rajaampat,
        R.drawable.pagaruyung2,
        R.drawable.bromo,
        R.drawable.danausentani,
        R.drawable.toraja,
        R.drawable.tamanlautbunaken,
        R.drawable.bali,
        R.drawable.pagaruyung,
        R.drawable.borobudur2
    )

    val listData: ArrayList<DataPhoto>
        get() {
            val list = arrayListOf<DataPhoto>()
            for (position in tourismImages.indices) {
                val dataPhoto = DataPhoto()
                dataPhoto.photo = tourismImages[position]
                list.add(dataPhoto)
            }
            return list
        }
}