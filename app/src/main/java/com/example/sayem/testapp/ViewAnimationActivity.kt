package com.example.sayem.testapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator


class ViewAnimationActivity : AppCompatActivity() {

    private var tv: TextView? = null
    private var image: ImageView? = null
    private var color1 = 0
    private var color2 = 0
    private var name = "Saadat Sayem"
    private var char = ""
    private var builderC: TextDrawable.IBuilder? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_animation)
        tv = findViewById(R.id.tv_text)
        tv?.text = name
        char = name[0].toString()
        //normal
        image = findViewById(R.id.iv_text_img)
        randomColorGenerator()
        val drawable = TextDrawable.builder()
                .beginConfig()
                .textColor(Color.WHITE)
                .useFont(Typeface.SANS_SERIF)
                .fontSize(100)
                .bold()
                .toUpperCase()
                .withBorder(10)
                .endConfig()
                .buildRoundRect(char, color1, 85)
        /*val drawable = builderC?.build("S", color1)*/

        image?.setImageDrawable(drawable)

        /*AnimationUtils.loadAnimation(this, R.anim.shake_error).also { hyperspaceJumpAnimation ->
            tv?.startAnimation(hyperspaceJumpAnimation)
        }*/
    }

    override fun onResume() {
        super.onResume()
        reloadView()
    }

    private fun reloadView() {

        randomColorGenerator()
        val drawable = TextDrawable.builder()
                .beginConfig()
                .textColor(Color.WHITE)
                .useFont(Typeface.SANS_SERIF)
                .fontSize(100)
                .bold()
                .toUpperCase()
                .withBorder(10)
                .endConfig()
                .buildRoundRect(char.toString(), color1, 85)
        /*val drawable = builderC?.build("S", color1)*/

        image?.setImageDrawable(drawable)
    }

    private fun randomColorGenerator() {
        val generator: ColorGenerator = ColorGenerator.MATERIAL // or use DEFAULT
// generate random color
        color1 = generator.randomColor
// generate color based on a key (same key returns the same color), useful for list/grid views
        color2 = generator.getColor("scode43@gmail.com")

// declare the builder object once.
        builderC = TextDrawable.builder()
                .beginConfig()
                .withBorder(4)
                .endConfig()
                .rect()
    }
}
