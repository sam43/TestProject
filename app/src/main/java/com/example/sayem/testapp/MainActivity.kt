package com.example.sayem.testapp

import android.annotation.SuppressLint
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    val compID: Int = 35450
    val dateStr = "9/12/2012 12:38:00 PM"
    val token: String = "Crp3JsApplPostedArc"
    var totToken: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getDateValue()
    }
    @SuppressLint("SimpleDateFormat")
    private fun getDateValue() {
        Log.d("outMsg","getValues...")
        val str = "9/12/2012 12:38:00 PM"
        val dob = splitItem(str)
        try {
            val sdf = SimpleDateFormat("MM/dd/yyyy")
            val d = sdf.parse(dob)
            val cal = Calendar.getInstance()
            cal.time = d
            val month = cal.get(Calendar.MONTH) + 1
            val dd = cal.get(Calendar.DATE)
            val year:String = cal.get(Calendar.YEAR).toString()
            val yearInt = year.toInt()
            Log.d("outpu", year)
            Log.d("output","\nsum of values: ${compID+month+dd+yearInt}")
            totToken = (month+dd+yearInt).toString()
            Log.d("outpu", totToken)
        } catch (e: Exception) {
            Log.d("output","\nsum of values: ${e.message}")
            e.printStackTrace()
        }

        totToken = token + totToken
        Log.d("outTot", totToken)
        totToken = encode2Base64(totToken!!)
        Log.d("outTotEnc", totToken)

    }
    private fun splitItem(str: String): String{
        val splited = str.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        // splited[0] = splited[0].replace("0", "")
        return  splited[0]
    }

    private fun encode2Base64(str: String) : String {
        val res: String?
        val bytes = str.toByteArray()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            res = String(Base64.getEncoder().encode(bytes))
            Log.d("outBase1", res)
        } else {
            res = String(android.util.Base64.decode(str, android.util.Base64.DEFAULT))
            Log.d("outBase2", res)
        }
        Log.d("outBase3", res)
        return res
    }
}
