package com.example.sayem.testapp.mpChartTest

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sayem.testapp.R
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.formatter.IValueFormatter
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.example.sayem.testapp.R.id.chart
import com.github.mikephil.charting.components.YAxis




class MPBarChartActivity : AppCompatActivity() {

    private var firstLoad: Boolean = false
    private var chart: BarChart? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mpbar_chart)
        chart = findViewById(R.id.chart)

        chart?.data = BarData(getBarData())
        chart?.setVisibleXRangeMaximum(31F)
        chart?.xAxis?.disableAxisLineDashedLine()
        chart?.moveViewToX(0F)
        chart?.zoomToCenter(2F,0F)
        //chart?.invalidate()
        setUpBarChart(chart)
    }

    private fun setUpBarChart(chart: BarChart?) {

        //Y-axis values
        chart?.axisLeft?.apply {
            axisMinimum = 0f
            axisMaximum = 2000f
            setLabelCount(10, true)
            //labelCount = 10
            setDrawTopYLabelEntry(true)
            setValueFormatter { value, axis -> "" + value.toInt()}
        }

        //Y-axis set up
        chart?.axisRight?.apply {
            setDrawLabels(false)
            setDrawGridLines(false)
            setDrawAxisLine(false)
            setDrawZeroLine(false)
            setDrawTopYLabelEntry(true)
        }

        //X-axis Labels
        val labels = arrayOf("","1 Jan","2 Jan","3 Jan","4 Jan","5 Jan","6 Jan","7 Jan","8 Jan","9 Jan","10 Jan","11 Jan","12 Jan","13 Jan","14 Jan","15 Jan","16 Jan","17 Jan","18 Jan","19 Jan","20 Jan","21 Jan","22 Jan","23 Jan","24 Jan","25 Jan","26 Jan","27 Jan","28 Jan","29 Jan","30 Jan","31 Jan") //X-axis labels
        chart?.xAxis?.apply {
            valueFormatter = IndexAxisValueFormatter(labels)
            labelCount = 6 //show how frequent to show X-axis labels
            position = XAxis.XAxisPosition.BOTTOM
            setDrawLabels(true)
            setDrawAxisLine(false)
            disableAxisLineDashedLine()
            setDrawGridLines(false)
        }

        //setting up properties
        chart?.apply {
            setDrawValueAboveBar(true)
            description.isEnabled = false
            isClickable = false
            legend.isEnabled = true
            setScaleEnabled(false)
            //animateXY(2000,2000)
            //animateY(1500, Easing.EasingOption.EaseInOutExpo)

        }
    }

    @SuppressLint("PrivateResource")
    private fun getBarData(): ArrayList<IBarDataSet> {
        //add value by X-axis to Y-axis
        val entries = ArrayList<BarEntry>().apply {
            //add(BarEntry(0f, 8f))
            add(BarEntry(1f, 160f))
            add(BarEntry(2f, 815f))
            add(BarEntry(3f, 260f))
            add(BarEntry(4f, 1210f))
            add(BarEntry(5f, 1110f))
            add(BarEntry(6f, 302f))
            add(BarEntry(7f, 595f))
            add(BarEntry(8f, 128f))
            add(BarEntry(9f, 780f))
            add(BarEntry(10f, 65f))
            add(BarEntry(11f, 620f))
            add(BarEntry(12f, 80f))
            add(BarEntry(13f, 720f))
            add(BarEntry(14f, 42f))
            add(BarEntry(15f, 808f))
            add(BarEntry(16f, 30f))
            add(BarEntry(17f, 565f))
            add(BarEntry(18f, 1452f))
            add(BarEntry(19f, 70f))
            add(BarEntry(20f, 635f))
            add(BarEntry(21f, 610f))
            add(BarEntry(22f, 80f))
            add(BarEntry(23f, 720f))
            add(BarEntry(24f, 42f))
            add(BarEntry(25f, 80f))
            add(BarEntry(26f, 30f))
            add(BarEntry(27f, 553f))
            add(BarEntry(28f, 132f))
            add(BarEntry(29f, 70f))
            add(BarEntry(30f, 605f))
            add(BarEntry(31f, 65f))
        }

        val dataSet = BarDataSet(entries, "Number of CV dropped").apply {
            //整数で表示
            valueFormatter = IValueFormatter { value, _, _, _ -> "" + value.toInt() }
            //ハイライトさせない
            isHighlightEnabled = false
            //Bar colors - setting according to cv drop
            /*setColors(intArrayOf(R.color.material_blue, R.color.material_green, R.color.material_yellow, R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark, R.color.material_bar, R.color.material_teal, R.color.material_deep_teal_200), this@MPBarChartActivity)*/
            setColors(intArrayOf(R.color.material_teal), this@MPBarChartActivity)
        }

        val bars = ArrayList<IBarDataSet>()
        bars.add(dataSet)
        return bars
    }

}
