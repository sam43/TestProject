package com.example.sayem.testapp

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class ViewProgammingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_progamming)

        val view = View(this)
        view.setBackgroundColor(Color.RED)
        //view.layoutParams =
    }
}
