package com.example.vaishnavi.cardviewkotlin

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import kotlinx.android.synthetic.main.fragment_card_view.view.*

class CardViewFragment : Fragment() {

    lateinit var cardView : CardView
    lateinit var radiusSeekBar : SeekBar
    lateinit var elevationSeekBar : SeekBar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_card_view,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cardView = view.findViewById(R.id.cardview)
        radiusSeekBar = view.findViewById(R.id.cardview_radius_seekbar)
        elevationSeekBar = view.findViewById(R.id.cardview_elevation_seekbar)

        radiusSeekBar.setOnSeekBarChangeListener(object  : SeekBar.OnSeekBarChangeListener{

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                //do nothing
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                cardView.radius = progress.toFloat()
            }

        })

        elevationSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                cardView.elevation = progress.toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        } )
    }

}