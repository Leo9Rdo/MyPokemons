package com.example.mypokemons

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.mypokemons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


       binding.imgCard.setImageResource(R.drawable.butterfree)

        binding.imgCard.setOnClickListener{
            val intent = Intent(this,SecondActivity::class.java)
            val bundle = Bundle()
            intent.putExtra("name","butterfree")
            intent.putExtra("type", "pokemon")
            intent.putExtra("height", "23")
            intent.putExtra("weight","42")

            intent.putExtras(bundle)
            startActivity(intent)
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