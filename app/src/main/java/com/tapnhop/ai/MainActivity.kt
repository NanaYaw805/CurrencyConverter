package com.tapnhop.ai

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var dollarAmount:EditText
    lateinit var cediAmount:TextView
    lateinit var convert:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        dollarAmount = findViewById(R.id.dollars)
        cediAmount = findViewById(R.id.ghc)
        convert = findViewById(R.id.convert_button)


        convert.setOnClickListener {
            var inDollars:String = dollarAmount.text.toString()
            var money:Double = inDollars.toDouble()


            //convert from dollars to cedis
            //1dollar is 15ghc so multiply dollar by 15 to get cedis
            var cedisAmount:Double? = money.times(15)
            cediAmount.text = "GHc" + cedisAmount.toString()
         }

        
    }
}