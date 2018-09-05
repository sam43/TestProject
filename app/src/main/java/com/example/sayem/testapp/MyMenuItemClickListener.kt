package com.example.sayem.testapp

import android.content.Context
import android.support.v7.widget.PopupMenu
import android.view.MenuItem
import android.widget.Toast


/**
 * Click listener for popup menu items
 */
internal class MyMenuItemClickListener(mContext: ViewProgammingActivity) : PopupMenu.OnMenuItemClickListener {

    private var cxt: Context? = null

    init {
        cxt = mContext
    }

    override fun onMenuItemClick(menuItem: MenuItem): Boolean {

        when (menuItem.itemId) {
            R.id.action_add_favourite -> {
                Toast.makeText(cxt, "Add to favourite", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_play_next -> {
                Toast.makeText(cxt, "Play next", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return true
    }
}