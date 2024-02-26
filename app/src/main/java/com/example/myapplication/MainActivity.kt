package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goToModify.setOnClickListener {
            val intent = Intent(this, modificar::class.java)
            startActivity(intent)
        }

        binding.goToAdd.setOnClickListener {
            val intent = Intent(this, agregar::class.java)
            startActivity(intent)
        }

        binding.goToDelete.setOnClickListener {
            val intent = Intent(this, Delete::class.java)
            startActivity(intent)
        }
        binding.goToConsultas.setOnClickListener {
            val intent = Intent(this, Consultas::class.java)
            startActivity(intent)
        }
    }
}