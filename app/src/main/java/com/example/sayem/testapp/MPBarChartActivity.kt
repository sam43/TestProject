package com.example.sayem.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis


class MPBarChartActivity : AppCompatActivity() {

    private var data: BarData? = null
    private var barChart: BarChart? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mpbar_chart)
        barChart = findViewById(R.id.chart)

        /*data = BarData(getXAxisValues(), getDataSet())
        chart.data = data
        //chart.setDescription("My Chart")
        chart.animateXY(2000, 2000)
        chart.invalidate()*/
        setupBarChartData()
    }

    override fun onResume() {
        super.onResume()
        barChart?.animateXY(3000,3000)
    }

    private fun setupBarChartData() {
        // create BarEntry for Bar Group
        val bargroup = ArrayList<BarEntry>()
        bargroup.add(BarEntry(1f, 2f, "1"))
        bargroup.add(BarEntry(2f, 4f, "2"))
        bargroup.add(BarEntry(3f, 6f, "3"))
        bargroup.add(BarEntry(4f, 8f, "4"))
        bargroup.add(BarEntry(5f, 10f, "5"))
        bargroup.add(BarEntry(6f, 22f, "6"))
        bargroup.add(BarEntry(7f, 12.5f, "7"))
        bargroup.add(BarEntry(8f, 22f, "8"))
        bargroup.add(BarEntry(9f, 32f, "9"))
        bargroup.add(BarEntry(10f, 54f, "10"))
        bargroup.add(BarEntry(11f, 28f, "11"))
        bargroup.add(BarEntry(12f, 30f, "12"))
        bargroup.add(BarEntry(13f, 54f, "13"))
        bargroup.add(BarEntry(14f, 28f, "14"))
        bargroup.add(BarEntry(15f, 30f, "15"))
        bargroup.add(BarEntry(16f, 54f, "16"))
        bargroup.add(BarEntry(17f, 28f, "17"))
        bargroup.add(BarEntry(18f, 30f, "18"))
        bargroup.add(BarEntry(19f, 54f, "19"))
        bargroup.add(BarEntry(20f, 28f, "20"))
        bargroup.add(BarEntry(21f, 30f, "21"))
        bargroup.add(BarEntry(22f, 54f, "22"))
        bargroup.add(BarEntry(23f, 28f, "23"))
        bargroup.add(BarEntry(24f, 30f, "24"))
        bargroup.add(BarEntry(25f, 54f, "25"))
        bargroup.add(BarEntry(26f, 28f, "26"))
        bargroup.add(BarEntry(27f, 30f, "27"))
        bargroup.add(BarEntry(28f, 54f, "28"))
        bargroup.add(BarEntry(29f, 28f, "29"))
        bargroup.add(BarEntry(30f, 30f, "30"))

        // creating dataset for Bar Group
        val barDataSet = BarDataSet(bargroup, "")

        barDataSet.color = ContextCompat.getColor(this, R.color.colorAccent)

        val data = BarData(barDataSet)
        barChart?.data = data
        barChart?.xAxis?.position = XAxis.XAxisPosition.BOTTOM
        barChart?.xAxis?.labelCount = 30
        barChart?.xAxis?.enableGridDashedLine(5f, 5f, 0f)
        barChart?.axisRight?.enableGridDashedLine(5f, 5f, 0f)
        barChart?.axisLeft?.enableGridDashedLine(5f, 5f, 0f)
        barChart?.description?.isEnabled = false
        /*barChart?.animateY(3000)
        barChart?.animateX(3000)*/
        barChart?.legend?.isEnabled = false
        barChart?.setPinchZoom(false)
        barChart?.data?.setDrawValues(false)
    }
}
