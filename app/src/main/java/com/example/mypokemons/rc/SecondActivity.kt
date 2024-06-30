package com.example.mypokemons

import android.annotation.SuppressLint
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mypokemons.databinding.ActivitySecondBinding
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.DrawableRes


class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent?.let {
            val pokemon_id = it.getIntExtra("pokemon_id", -1)
            val pokemon = pokemon_rep.get_pokemon_by_id(pokemon_id)

            if (pokemon != null) {
                with(binding) {
                    txtName.text = pokemon.name
                    txtType.text = pokemon.type
                    txtHeight.text = pokemon.height
                    txtWidth.text = pokemon.weight
                    imageCard2.setImageResource(pokemon.image_res)
                }
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        binding.btnBack2.setOnClickListener {
            finish()
        }
    }
}
