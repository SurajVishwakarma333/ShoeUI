package `in`.insideandroid.shoesuiandroid

import android.graphics.PorterDuff
import android.graphics.drawable.LayerDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var count = 0

    lateinit var yellowColor1: ImageView
    lateinit var  yellowColor2: ImageView
    lateinit var  redColor1: ImageView
    lateinit var  redColor2: ImageView
    lateinit var  blueColor1: ImageView
    lateinit var  blueColor2: ImageView
    lateinit var  greenColor1: ImageView
    lateinit var  greenColor2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // color control
        yellowColor1 = findViewById<ImageView>(R.id.yellow1)
        yellowColor2 = findViewById<ImageView>(R.id.yellow2)
        redColor1 = findViewById<ImageView>(R.id.red1)
        redColor2 = findViewById<ImageView>(R.id.red2)
        blueColor1 = findViewById<ImageView>(R.id.blue1)
        blueColor2 = findViewById<ImageView>(R.id.blue2)
        greenColor1 = findViewById<ImageView>(R.id.green1)
        greenColor2 = findViewById<ImageView>(R.id.green2)

        // quantity
        val imageAdd = findViewById<ImageView>(R.id.add)
        val imageMinus = findViewById<ImageView>(R.id.minus)
        val shoesCountTextView = findViewById<TextView>(R.id.txtCount)

        imageAdd.setOnClickListener {
            count++

            if(count > 9)
                count = 9
            shoesCountTextView.text = count.toString()
        }

        imageMinus.setOnClickListener {
            count--

            if(count < 0)
                count = 0
            shoesCountTextView.text = count.toString()
        }

        // rating bar
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val stars : LayerDrawable = ratingBar.progressDrawable as LayerDrawable
        stars.getDrawable(2).setColorFilter(resources.getColor(R.color.yellow), PorterDuff.Mode.SRC_ATOP)

        yellowColor1.setOnClickListener {
            clickedColor(1)
        }

        redColor1.setOnClickListener {
            clickedColor(2)
        }

        blueColor1.setOnClickListener {
            clickedColor(3)
        }

        greenColor1.setOnClickListener {
            clickedColor(4)
        }

    }

    private fun clickedColor(i: Int) {
        yellowColor2.visibility = View.GONE
        greenColor2.visibility = View.GONE
        blueColor2.visibility = View.GONE
        redColor2.visibility = View.GONE

        when(i){
            1 -> yellowColor2.visibility = View.VISIBLE
            2 -> redColor2.visibility = View.VISIBLE
            3 -> blueColor2.visibility = View.VISIBLE
            4 -> greenColor2.visibility = View.VISIBLE
        }
    }
}