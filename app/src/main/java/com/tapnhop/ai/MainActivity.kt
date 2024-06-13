package com.tapnhop.ai

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.lang.Exception
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var dollarAmount:EditText
    lateinit var cediAmount:TextView
    lateinit var convert:Button
    lateinit var lotto:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        dollarAmount = findViewById(R.id.dollars)
        cediAmount = findViewById(R.id.ghc)
        convert = findViewById(R.id.convert_button)
        lotto = findViewById(R.id.random_number_button)


        convert.setOnClickListener {

            try {
                var inDollars:String = dollarAmount.text.toString()
                var money:Double = inDollars.toDouble()


                //convert from dollars to cedis
                //1dollar is 15ghc so multiply dollar by 15 to get cedis
                var cedisAmount:Double? = money.times(15)
                cediAmount.text = "GHc" + cedisAmount.toString()
            }catch (e:Exception){
                Toast.makeText(this@MainActivity,e.message,Toast.LENGTH_LONG).show()
            }


         }

        lotto.setOnClickListener {
            //generate random numbers and store it in a bundle to pass to another activity
            val random = Random.Default

            var randomList= mutableListOf<String>()
            var bundle:Bundle = Bundle()
            for(i in 1..5){
                val randomNumber = random.nextInt(1,40)

                randomList.add(randomNumber.toString())



            }

            for (i in randomList.indices) {
                bundle.putString(i.toString(), randomList[i])
                println(bundle.getString(i.toString()))
                Toast.makeText(this@MainActivity,bundle.getString(i.toString()),Toast.LENGTH_LONG).show()
            }

            for(key in bundle.keySet()){
                println("key: $key, value:${bundle.getString(key)}")
            }

        }




        
    }
}