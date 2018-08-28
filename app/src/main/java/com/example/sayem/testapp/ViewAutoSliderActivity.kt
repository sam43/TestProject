package com.example.sayem.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.ViewFlipper

class ViewAutoSliderActivity : AppCompatActivity() {
    private lateinit var viewFlipper: ViewFlipper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_auto_slider)
        viewFlipper = findViewById(R.id.view_flipper)
        val textView = TextView(this)
        textView.text = "Dynamically added TextView"
        textView.gravity = Gravity.CENTER

        viewFlipper.addView(textView)

        viewFlipper.setFlipInterval(2000)
        viewFlipper.startFlipping()
    }

    fun previousView(v: View) {
        viewFlipper.setInAnimation(this, R.anim.slide_in_right)
        viewFlipper.setOutAnimation(this, R.anim.slide_out_left)
        viewFlipper.showPrevious()
    }

    fun nextView(v: View) {
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left)
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right)
        viewFlipper.showNext()
    }
}
