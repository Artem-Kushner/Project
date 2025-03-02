package com.kushner.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.kushner.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var backPressed = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigation()
        //Запускаем фрагмент при старте
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_placeholder, HomeFragment())
            .addToBackStack(null)
            .commit()
    }
    fun launchDetailsFragment(film: Film) {
        //Создаем "посылку"
        val bundle = Bundle()
        //Кладем наш фильм в "посылку"
        bundle.putParcelable("film", film)
        //Кладем фрагмент с деталями в перменную
        val fragment = DetailsFragment()
        //Прикрепляем нашу "посылку" к фрагменту
        fragment.arguments = bundle
//Запускаем фрагмент
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment)
            .addToBackStack(null)
            .commit()
    }


    private fun initNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.favorites -> {
                    Snackbar.make(binding.main, "Избранное", Toast.LENGTH_SHORT)
                        .setAction("Посмотреть подборку") {
                            Toast.makeText(this, "Приятного просмотра", Toast.LENGTH_SHORT).show()
                        }.show()
                    true
                }

                R.id.watch_later -> {
                    Snackbar.make(binding.main, "Посмотреть похже", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.selections -> {
                    Snackbar.make(binding.main, "Подборки", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> {
                    false
                }
            }
        }
    }
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount <= 1) {
            if (backPressed + TIME_INTERVAL > System.currentTimeMillis()) {
                super.onBackPressed()
                finish()
            } else {
                Toast.makeText(this, getString(R.string.double_back_toast), Toast.LENGTH_SHORT).show()
            }

            backPressed = System.currentTimeMillis()
        } else {
            super.onBackPressed()
        }
    }

    companion object {
        const val TIME_INTERVAL = 2000
    }
}
/*
        binding.bottomNavigation.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.favorites -> {
                    Snackbar.make(binding.main,"Избранное", Toast.LENGTH_SHORT).setAction("Посмотреть подборку"){
Toast.makeText(this,"Приятного просмотра",Toast.LENGTH_SHORT).show()
                    }.show()
                    true
                }
                R.id.watch_later -> {
                    Snackbar.make(binding.main, "Посмотреть похже", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.selections -> {
                    Snackbar.make(binding.main, "Подборки", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }





        //initNavigation()

        //находим наш RV
        binding.mainRecycler.apply {
            //Инициализируем наш адаптер в конструктор передаем анонимно инициализированный интерфейс,
            //оставим его пока пысты, он нам понадобится во второй части задания
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener{
                override fun click(film: Film) {
                    //Создаем бандл и кладем туда объект с данными фильма
                    val bundle = Bundle()
                    //Первым параметром указывается ключ, по которому потом будем искать, вторым сам
                    //передаваемы объект
                    bundle.putParcelable("film", film)
                    //Запускаем наше активити
                    val intent = Intent(this@MainActivity, DetailsFragment::class.java)
                    //Прикрепляем бандл к интенту
                    intent.putExtras(bundle)
                    //Запускаем активити через интент
                    startActivity(intent)
                }
            })
            //Присваиваем адаптер
            adapter = filmsAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(this@MainActivity)
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        //Кладем нашу БД в RV
        filmsAdapter.addItems(filmsDataBase)
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


 */




