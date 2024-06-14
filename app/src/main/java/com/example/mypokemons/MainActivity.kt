package com.example.mypokemons

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

            Log.d("tag","hello, onCreate")


        val imageCard : ImageView = this.findViewById<ImageView>(R.id.imgCard)
        imageCard.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            this.startActivity(intent)

        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

        override fun onStop() {
            super.onStop()
            Log.d("tag","hello, onStop")
        }
}

