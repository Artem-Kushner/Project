package com.kushner.myapplication

import android.animation.Animator
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kushner.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("ResourceType")
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
        val animation = AnimationUtils.loadAnimation(this, R.anim.anim_1)
        binding.posterPanel4.setOnClickListener {
            binding.posterPanel4.startAnimation(animation)
        }
        val animationUpdateListener = object : Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator) {
                Toast.makeText(this@MainActivity, "Animation start", Toast.LENGTH_SHORT).show()
                println("start")
            }

            override fun onAnimationEnd(animation: Animator) {
                Toast.makeText(this@MainActivity, "Animation End", Toast.LENGTH_SHORT).show()
            }

            override fun onAnimationCancel(animation: Animator) {
                Toast.makeText(this@MainActivity, "Animation cancel", Toast.LENGTH_SHORT).show()
            }

            override fun onAnimationRepeat(animation: Animator) {
                Toast.makeText(this@MainActivity, "Animation repeat", Toast.LENGTH_SHORT).show()
            }
        }
binding.posterPanel3.setOnClickListener{
val anim = ObjectAnimator.ofFloat(binding.posterPanel3, View.ROTATION, 1F,360F)
anim.duration = 300
    anim.addListener(animationUpdateListener)
    anim.start()
}

    }
    }

