package com.example.mypokemons

import androidx.recyclerview.widget.DiffUtil
import com.example.mypokemons.pokemon_rep.pokemons
class PokemonDiff(private val oldList: List<pokemon>, private val newList: List<pokemon>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}
