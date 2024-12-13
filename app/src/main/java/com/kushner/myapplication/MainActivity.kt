package com.kushner.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kushner.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root

        setContentView(view)
        binding.buttons1.setOnClickListener {
            Toast.makeText(this, "МЕНЮ", Toast.LENGTH_SHORT).show()
        }
        binding.buttons2.setOnClickListener {
            Toast.makeText(this, "ИЗБРАННОЕ", Toast.LENGTH_SHORT).show()
        }
        binding.buttons3.setOnClickListener {
            Toast.makeText(this, "ПОСМОТРЕТЬ ПОЗЖЕ", Toast.LENGTH_SHORT).show()
        }
        binding.buttons4.setOnClickListener {
            Toast.makeText(this, "ПОДБОРКИ", Toast.LENGTH_SHORT).show()
        }
        binding.buttons5.setOnClickListener {
            Toast.makeText(this, "НАСТРОЙКИ", Toast.LENGTH_SHORT).show()
        }
    }

}
