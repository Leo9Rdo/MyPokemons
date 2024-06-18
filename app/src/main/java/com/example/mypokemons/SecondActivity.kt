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
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent?.let {
            val name = it.getStringExtra("name")
            val type = it.getStringExtra("type")
            val height = it.getStringExtra("height")
            val weight = it.getStringExtra("weight")
            val imgRes= it.getIntExtra("image",0)

            if (name != null && type != null && height != null && weight != null && imgRes != 0) {
            with(binding) {
                txtName.text = name
                txtType.text= type
                txtHeight.text=height
                txtWidth.text=weight
                imageCard2.setImageResource(imgRes)
            }
        }
            else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        binding.btnBack2.setOnClickListener {
            finish()
        }
    }
    private fun ImageView.loadImage(@DrawableRes resId: Int) {
        this.setImageResource(resId)
    }
}