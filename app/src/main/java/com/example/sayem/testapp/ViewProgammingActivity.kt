package com.example.sayem.testapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.PopupMenu
import android.view.View
import android.widget.ImageView



class ViewProgammingActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        showPopUp(v!!)
    }

    private var ivMore: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.applicant_list_item)
        ivMore = findViewById(R.id.iv_more)
        ivMore?.setOnClickListener(this@ViewProgammingActivity)
    }

    private fun showPopUp(v: View) {
        val popup = PopupMenu(this@ViewProgammingActivity, v)
        val inflater = popup.menuInflater
        inflater.inflate(R.menu.overflow_menu, popup.menu)
        popup.setOnMenuItemClickListener(MyMenuItemClickListener(this@ViewProgammingActivity))
        popup.show()
    }
}
