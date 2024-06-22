package com.example.mypokemons.rc

import androidx.recyclerview.widget.RecyclerView
import com.example.mypokemons.databinding.ItemPokemonBinding
import com.example.mypokemons.pokemon
import com.example.mypokemons.pokemon_rep.pokemons

class PokemonViewHolder(
    private val binding: ItemPokemonBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(pokemon: pokemon, onClick: (pokemon) -> Unit){
        with(binding) {
            pokemonImage.setImageResource(pokemon.image_res)
            pokemonName.text = pokemon.name
            root.setOnClickListener {
                onClick(pokemon)
            }
        }
    }
}