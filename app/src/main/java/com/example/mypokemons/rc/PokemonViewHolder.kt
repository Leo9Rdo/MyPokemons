package com.example.mypokemons.rc

import androidx.recyclerview.widget.RecyclerView
import com.example.mypokemons.databinding.ItemPokemonBinding
import com.example.mypokemons.Pokemon


class PokemonViewHolder(
    private val binding: ItemPokemonBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(pokemon: Pokemon, onClick: ((pokemon: Pokemon) -> Unit)?) {
        with(binding) {
            pokemonImage.setImageResource(pokemon.imageRes)
            pokemonName.text = pokemon.name
            root.setOnClickListener {
                onClick?.invoke(pokemon)
            }
        }
    }
}
