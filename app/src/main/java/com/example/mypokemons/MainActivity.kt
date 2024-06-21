package com.example.mypokemons

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import com.example.mypokemons.databinding.ActivityMainBinding
import com.example.mypokemons.pokemon_rep.pokemons


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var current_index = 0

    private val pokemon_data = pokemon_rep.pokemons
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgCard.setImageResource(R.drawable.butterfree)
        // val bundle = Bundle()

        binding.imgCard.setOnClickListener {
            val currentPokemon = pokemon_data[current_index]
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("pokemon_id", currentPokemon.id)
            }
            startActivity(intent)
        }
        binding.btnNext.setOnClickListener {
            current_index = (current_index + 1) % pokemons.size
            update()
        }
    }


    private fun update() {
        val currentPokemon = pokemons[current_index]
        binding.imgCard.setImageResource(currentPokemon.image_res)
    }

}