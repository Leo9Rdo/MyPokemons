package com.example.mypokemons.rc

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mypokemons.R
import com.example.mypokemons.databinding.ItemPokemonBinding
import com.example.mypokemons.pokemon

class PokemonListAdapter(private var pokemonList: List<pokemon>) :
    RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder>() {

    var onClick: ((pokemon: pokemon) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.bind(pokemon)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    fun updatePokemonList(newList: List<pokemon>) {
        pokemonList = newList
    }


    inner class PokemonViewHolder(private val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onClick?.invoke(pokemonList[adapterPosition])
            }
        }

        fun bind(pokemon: pokemon) {
            binding.pokemonName.text = pokemon.name
            binding.pokemonImage.setImageResource(pokemon.image_res)
        }
    }
    fun getPokemonList() = pokemonList
}
