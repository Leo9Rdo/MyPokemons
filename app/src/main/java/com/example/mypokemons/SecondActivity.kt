package com.example.mypokemons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mypokemons.databinding.ActivitySecondBinding
import android.widget.Toast


class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent == null){
            Toast.makeText(this,"Null", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

            val pokemonId = intent.getIntExtra("pokemon_id", -1)
            val pokemon = PokemonRep.getPokemonById(pokemonId)

            if (pokemon != null) {
                with(binding) {
                    txtName.text = pokemon.name
                    txtType.text = pokemon.type
                    txtHeight.text = pokemon.height
                    txtWidth.text = pokemon.weight
                    imageCard2.setImageResource(pokemon.imageRes)
                }
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                finish()
            }


        binding.btnBack2.setOnClickListener {
            finish()
        }
    }
}
