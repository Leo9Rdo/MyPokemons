package com.example.mypokemons

object pokemon_rep {
    val pokemons = listOf(
        pokemon(1, "Butterfree", "Bug", "11 sm", "320 g", R.drawable.butterfree),
        pokemon(2, "Charmeleon", "Fire", "11 sm", "190 g", R.drawable.charmeleon),
        pokemon(3, "Pidgay", "Flying", "3 sm", "18 g", R.drawable.pidgey),
        pokemon(4, "Squirtle", "water", "5 sm", "90 g", R.drawable.squirtle),
        pokemon(5, "Wartortle", "water", "10 sm", "150 g", R.drawable.wartortle),
        pokemon(6, "Ivysaur", "poison", "10 sm", "130 g", R.drawable.ivysaur)

    )

    fun get_pokemon_by_id(id: Int): pokemon? {
        return pokemons.find { it.id == id }
    }
}

data class pokemon(
    val id: Int,
    val name: String,
    val type: String,
    val height: String,
    val weight: String,
    val image_res: Int
)
