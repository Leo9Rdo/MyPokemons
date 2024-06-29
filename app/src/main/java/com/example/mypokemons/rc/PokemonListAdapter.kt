package com.example.mypokemons.rc

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mypokemons.PokemonDiff
import com.example.mypokemons.R
import com.example.mypokemons.databinding.ItemPokemonBinding
import com.example.mypokemons.pokemon
import com.example.mypokemons.pokemon_rep

class PokemonListAdapter(private var pokemonList: List<pokemon>) :
    RecyclerView.Adapter<PokemonViewHolder>() {

    var onClick: ((pokemon: pokemon) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.bind(pokemon, onClick)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    fun updatePokemonList(newList: List<pokemon>) {

        val diffResult = DiffUtil.calculateDiff(PokemonDiff(pokemonList, newList))
        pokemonList = newList
        diffResult.dispatchUpdatesTo(this)
    }

    fun getPokemonList() = pokemonList
}
