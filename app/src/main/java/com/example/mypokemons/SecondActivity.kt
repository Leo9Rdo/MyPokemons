package com.example.mypokemons

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mypokemons.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        if (extras != null) {
            val name = extras.getString("name")
            val type = extras.getString("type")
            val height = extras.getString("height")
            val weight = extras.getString("weight")

            binding.txtName.setText("Name: " + name);
            binding.txtType.setText("Type: " + type);
            binding.txtHeight.setText("Height: " + height + " m");
            binding.txtWidth.setText("Weight: " + weight + " kg");

            binding.imageCard2.setImageResource(R.drawable.butterfree);
        }


        val btnBack2 : Button=this.findViewById<Button>(R.id.btnBack2)
            btnBack2.setOnClickListener{
                finish()

            }
    }
}