package com.example.mypokemons

object PokemonRep {
    val pokemons = listOf(
        Pokemon(1, "Butterfree", "Bug", "11 sm", "320 g", R.drawable.butterfree),
        Pokemon(2, "Charmeleon", "Fire", "11 sm", "190 g", R.drawable.charmeleon),
        Pokemon(3, "Pidgay", "Flying", "3 sm", "18 g", R.drawable.pidgey),
        Pokemon(4, "Squirtle", "water", "5 sm", "90 g", R.drawable.squirtle),
        Pokemon(5, "Wartortle", "water", "10 sm", "150 g", R.drawable.wartortle),
        Pokemon(6, "Ivysaur", "poison", "10 sm", "130 g", R.drawable.ivysaur)
    )

    fun getPokemonById(id: Int): Pokemon? {
        return pokemons.find { it.id == id }
    }
}

data class Pokemon(
    val id: Int,
    val name: String,
    val type: String,
    val height: String,
    val weight: String,
    val imageRes: Int
)
