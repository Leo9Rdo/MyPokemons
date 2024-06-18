package com.example.mypokemons

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import com.example.mypokemons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding
    private var currentIndex = 0

    data class Pokemon(
        val name: String,
        val type: String,
        val height: String,
        val weight: String,
        @DrawableRes val imageResId: Int
    )

    private val pokemons = listOf(
        Pokemon("Butterfree", "Bug", "11 sm", "320 g", R.drawable.butterfree),
        Pokemon("Charmeleon", "Fire", "11 sm", "190 g", R.drawable.charmeleon),
        Pokemon("Pidgay", "Flying","3 sm", "18 g", R.drawable.pidgey),
        Pokemon("Squirtle", "water","5 sm", "90 g", R.drawable.squirtle),
        Pokemon("Wartortle", "water","10 sm", "150 g", R.drawable.wartortle),
        Pokemon("Ivysaur", "poisin","10 sm", "130 g", R.drawable.ivysaur)

    )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.imgCard.setImageResource(R.drawable.butterfree)
        val bundle = Bundle()
        binding.imgCard.setOnClickListener{
            val Poke = pokemons[currentIndex]
            val intent = Intent(this,SecondActivity::class.java).apply {
                putExtra("name", Poke.name)
                putExtra("type", Poke.type)
                putExtra("height", Poke.height)
                putExtra("weight", Poke.weight)
                putExtra("image",Poke.imageResId)

            }
           // intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.btnNext.setOnClickListener {
            currentIndex = (currentIndex + 1) % pokemons.size
            update()
        }
    }


    private fun update() {
        val currentPokemon = pokemons[currentIndex]
        binding.imgCard.setImageResource(currentPokemon.imageResId)
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