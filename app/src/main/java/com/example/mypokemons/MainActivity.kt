package com.example.mypokemons

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.mypokemons.databinding.ActivityMainBinding
import com.example.mypokemons.PokemonRep.pokemons
import com.example.mypokemons.rc.PokemonListAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PokemonListAdapter

    private val pokemonData = pokemons

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = PokemonListAdapter(pokemonData)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

        adapter.onClick = { pokemon:Pokemon ->

            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("pokemon_id", pokemon.id)
            }
            startActivity(intent)
        }

        //val newList = pokemons
        adapter.updatePokemonList(pokemons)

        binding.pokemonImage.setOnClickListener {
            val currentPokemon = pokemonData.firstOrNull()
            currentPokemon?.let {
                val intent = Intent(this, SecondActivity::class.java).apply {
                    putExtra("pokemon_id", currentPokemon.id)
                }
                startActivity(intent)
            }
        }
    }

}
