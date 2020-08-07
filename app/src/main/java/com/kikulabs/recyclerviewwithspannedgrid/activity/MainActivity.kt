package com.kikulabs.recyclerviewwithspannedgrid.activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.arasthel.spannedgridlayoutmanager.SpanSize
import com.arasthel.spannedgridlayoutmanager.SpannedGridLayoutManager
import com.kikulabs.recyclerviewwithspannedgrid.R
import com.kikulabs.recyclerviewwithspannedgrid.adapter.SpannedGridTourismAdapter
import com.kikulabs.recyclerviewwithspannedgrid.data.Photo
import com.kikulabs.recyclerviewwithspannedgrid.decorator.SpaceItemDecorator
import com.kikulabs.recyclerviewwithspannedgrid.model.DataPhoto
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var list: ArrayList<DataPhoto> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.addAll(Photo.listData)
        setSearcView()
        showSpannedGrid()

    }

    private fun setSearcView() {
        val searchPlateId: Int = searchView.context.resources
            .getIdentifier("android:id/search_plate", null, null)
        val searchPlate: View =
            searchView.findViewById(searchPlateId)
        searchPlate?.setBackgroundColor(Color.TRANSPARENT)

        val linearLayout1 = searchView.getChildAt(0) as LinearLayout
        val linearLayout2 = linearLayout1.getChildAt(2) as LinearLayout
        val linearLayout3 = linearLayout2.getChildAt(1) as LinearLayout
        val autoComplete = linearLayout3.getChildAt(0) as AutoCompleteTextView
        autoComplete.textSize = 14f
    }

    private fun showSpannedGrid() {
        val spannedGridLayoutManager = SpannedGridLayoutManager(
            orientation = SpannedGridLayoutManager.Orientation.VERTICAL,
            spans = 3
        )
        spannedGridLayoutManager.itemOrderIsStable = true


        rv_tourisme.layoutManager = spannedGridLayoutManager

        rv_tourisme.addItemDecoration(
            SpaceItemDecorator(
                left = 2,
                top = 2,
                right = 2,
                bottom = 2
            )
        )

        val adapter = SpannedGridTourismAdapter(list)

        spannedGridLayoutManager.spanSizeLookup =
            SpannedGridLayoutManager.SpanSizeLookup { position ->

                //Conditions for 3x3 items
                if (position % 12 == 0 || position % 12 == 7) {

                    SpanSize(2, 2)


                } else {
                    SpanSize(1, 1)
                }
            }

        rv_tourisme.adapter = adapter
    }
}