package com.example.mypokemons

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypokemons.databinding.ActivityMainBinding
import com.example.mypokemons.pokemon_rep.pokemons
import com.example.mypokemons.databinding.ItemPokemonBinding
import com.example.mypokemons.rc.PokemonListAdapter
import com.example.mypokemons.rc.PokemonViewHolder


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PokemonListAdapter
    private var current_index = 0

    private val pokemon_data = pokemon_rep.pokemons

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = PokemonListAdapter(pokemon_data)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

        adapter.onClick = { pokemon ->
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("pokemon_id", pokemon.id)
            }
            startActivity(intent)
        }

        binding.pokemonImage.setOnClickListener {
            val currentPokemon = pokemon_data[current_index]
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("pokemon_id", currentPokemon.id)
            }
            startActivity(intent)
        }
    }

    private fun update() {
        val currentPokemon = pokemon_data[current_index]
        binding.pokemonImage.setImageResource(currentPokemon.image_res)
    }
}
