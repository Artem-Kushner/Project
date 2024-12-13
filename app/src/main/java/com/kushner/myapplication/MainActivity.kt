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

        binding.topAppBar.setOnMenuItemClickListener{
            when(it.itemId){
                R.id.settings_menu -> {
                    Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
            when(it.itemId){
                R.id.favorites -> {
                    Toast.makeText(this, "Избранное" , Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.watch_later -> {
                    Toast.makeText(this, "Посмотреть похже", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.selections -> {
                    Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}
