package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById(R.id.toolbarMenu)
        setSupportActionBar(toolbar)

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

    // Inflar el menú en el Toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Manejar las acciones del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.optBuscar -> {
                // Acción a realizar cuando se selecciona la opción de configuración
                true
            }
            R.id.optBuscarProducto -> {
                    val intent = Intent(this, Consultas::class.java)
                    startActivity(intent)
                true
            }
            // Agrega más casos según sea necesario para cada opción del menú
            else -> super.onOptionsItemSelected(item)
        }
    }



}
