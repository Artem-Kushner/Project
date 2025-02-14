package com.kushner.myapplication

import android.animation.Animator
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.kushner.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    val filmsDataBase = listOf(
        Film("Темный Рыцарь", R.drawable.posters_3, "Когда угроза, известная как Джокер, сеет хаос и разрушения " +
                "среди жителей Готэма, Бэтмену, Джеймсу Гордону и Харви Денту приходится объединить усилия, чтобы положить " +
                "конец безумию."),
        Film("Рокки", R.drawable.posters_1,"Боксеру из Филадельфии, который играет второразрядную роль, выпадает " +
                "редчайший шанс сразиться с чемпионом мира в тяжелом весе в бою, в котором он стремится пройти всю дистанцию " +
                "ради собственного достоинства."),
        Film("История игрушек", R.drawable.posters_12,"Кукла-ковбой испытывает глубокую угрозу и ревность," +
                " когда новая фигурка космонавта заменяет его в качестве главной игрушки в спальне мальчика."),
        Film("12 лет рабства", R.drawable.posters_5,"В довоенных Соединенных Штатах Соломон Нортап," +
                " свободный чернокожий мужчина из северной части штата Нью-Йорк, был похищен и продан в рабство."),
        Film("Дэдпул и Росомаха", R.drawable.posters_8,"Управление по изменению времени предлагает" +
                " Дэдпулу место в киновселенной Marvel, но вместо этого он нанимает вариант Росомахи, чтобы спасти свою вселенную от вымирания."),
        Film("Соник Ёж 3", R.drawable.posters_11,"Соник, Наклз и Тейлз воссоединяются против нового могущественного противника," +
                " Шэдоу, таинственного злодея с силами, не похожими ни на что, с чем они сталкивались раньше. " +
                "Поскольку их способности превосходят все, что им нужно, команда Соника должна найти маловероятный союз."),
        Film("Гладиатор", R.drawable.posters_6,"Бывший римский полководец намеревается отомстить продажному " +
                "императору, который убил его семью и отправил его в рабство."),
        Film("Форсаж: Токийский дрифт", R.drawable.posters_4,"Подросток становится серьезным конкурентом " +
                "в мире дрифт-гонок после того, как переезжает к отцу в Токио, чтобы избежать тюремного заключения в Америке."),
        Film("Трансформеры", R.drawable.posters_9,"Нерассказанная история происхождения Оптимуса Прайма и" +
                " Мегатрона, более известных как заклятые враги, но когда-то они были друзьями, связанными " +
                "как братья и навсегда изменившими судьбу Кибертрона."),
        Film("Королевство планеты обезьян", R.drawable.posters_10,"Спустя много лет после правления Цезаря молодая " +
                "обезьяна отправляется в путешествие, которое заставит ее подвергнуть сомнению все, чему ее учили о прошлом," +
                " и сделать выбор, который определит будущее как обезьян, так и людей."),
        Film("Аватар", R.drawable.posters_2,"Страдающий параличом морской пехотинец, отправленный на луну " +
                "Пандору с уникальной миссией, разрывается между выполнением приказов и защитой мира, который он считает своим домом."),
        Film("Интерстеллар", R.drawable.posters_7,"Когда в будущем Земля станет непригодной для жизни, фермеру и бывшему " +
                "пилоту НАСА Джозефу Куперу поручают управлять космическим кораблем вместе с группой исследователей," +
                " чтобы найти новую планету для людей"),

        )


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


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
                    val intent = Intent(this@MainActivity, DetailsActivity::class.java)
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



/*        val animationUpdateListener = object : Animator.AnimatorListener{
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

    }


