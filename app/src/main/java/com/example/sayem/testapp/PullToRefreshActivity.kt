package com.example.sayem.testapp

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import java.util.*


class PullToRefreshActivity : AppCompatActivity() {


    private var arrayList = ArrayList<String>()
    private var swipeRefreshLayout: SwipeRefreshLayout? = null
    private var rvList: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pull_to_refresh)


        swipeRefreshLayout = findViewById(R.id.swipeToRefresh)
        rvList = findViewById(R.id.rv_list)

        swipeRefreshLayout?.setColorSchemeResources(R.color.colorPrimary)

        arrayList.add("First Element")
        arrayList.add("Second Element")
        arrayList.add("Third Element")
        arrayList.add("Fourth Element")
        arrayList.add("Fifth Element")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
        rvList?.adapter = adapter

        swipeRefreshLayout?.setOnRefreshListener {
            shuffle()
            swipeRefreshLayout?.isRefreshing = false
        }
    }

    fun shuffle() {
        arrayList.shuffle(Random(System.currentTimeMillis()))
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
        rvList?.adapter = adapter
    }

}
