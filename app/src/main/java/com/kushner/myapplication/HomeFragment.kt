package com.kushner.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kushner.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    val filmsDataBase = listOf(
        Film(
            "Темный Рыцарь",
            R.drawable.posters_3,
            "Когда угроза, известная как Джокер, сеет хаос и разрушения " +
                    "среди жителей Готэма, Бэтмену, Джеймсу Гордону и Харви Денту приходится объединить усилия, чтобы положить " +
                    "конец безумию."
        ),
        Film(
            "Рокки",
            R.drawable.posters_1,
            "Боксеру из Филадельфии, который играет второразрядную роль, выпадает " +
                    "редчайший шанс сразиться с чемпионом мира в тяжелом весе в бою, в котором он стремится пройти всю дистанцию " +
                    "ради собственного достоинства."
        ),
        Film(
            "История игрушек",
            R.drawable.posters_12,
            "Кукла-ковбой испытывает глубокую угрозу и ревность," +
                    " когда новая фигурка космонавта заменяет его в качестве главной игрушки в спальне мальчика."
        ),
        Film(
            "12 лет рабства",
            R.drawable.posters_5,
            "В довоенных Соединенных Штатах Соломон Нортап," +
                    " свободный чернокожий мужчина из северной части штата Нью-Йорк, был похищен и продан в рабство."
        ),
        Film(
            "Дэдпул и Росомаха",
            R.drawable.posters_8,
            "Управление по изменению времени предлагает" +
                    " Дэдпулу место в киновселенной Marvel, но вместо этого он нанимает вариант Росомахи, чтобы спасти свою вселенную от вымирания."
        ),
        Film(
            "Соник Ёж 3",
            R.drawable.posters_11,
            "Соник, Наклз и Тейлз воссоединяются против нового могущественного противника," +
                    " Шэдоу, таинственного злодея с силами, не похожими ни на что, с чем они сталкивались раньше. " +
                    "Поскольку их способности превосходят все, что им нужно, команда Соника должна найти маловероятный союз."
        ),
        Film(
            "Гладиатор",
            R.drawable.posters_6,
            "Бывший римский полководец намеревается отомстить продажному " +
                    "императору, который убил его семью и отправил его в рабство."
        ),
        Film(
            "Форсаж: Токийский дрифт",
            R.drawable.posters_4,
            "Подросток становится серьезным конкурентом " +
                    "в мире дрифт-гонок после того, как переезжает к отцу в Токио, чтобы избежать тюремного заключения в Америке."
        ),
        Film(
            "Трансформеры",
            R.drawable.posters_9,
            "Нерассказанная история происхождения Оптимуса Прайма и" +
                    " Мегатрона, более известных как заклятые враги, но когда-то они были друзьями, связанными " +
                    "как братья и навсегда изменившими судьбу Кибертрона."
        ),
        Film(
            "Королевство планеты обезьян",
            R.drawable.posters_10,
            "Спустя много лет после правления Цезаря молодая " +
                    "обезьяна отправляется в путешествие, которое заставит ее подвергнуть сомнению все, чему ее учили о прошлом," +
                    " и сделать выбор, который определит будущее как обезьян, так и людей."
        ),
        Film(
            "Аватар",
            R.drawable.posters_2,
            "Страдающий параличом морской пехотинец, отправленный на луну " +
                    "Пандору с уникальной миссией, разрывается между выполнением приказов и защитой мира, который он считает своим домом."
        ),
        Film(
            "Интерстеллар",
            R.drawable.posters_7,
            "Когда в будущем Земля станет непригодной для жизни, фермеру и бывшему " +
                    "пилоту НАСА Джозефу Куперу поручают управлять космическим кораблем вместе с группой исследователей," +
                    " чтобы найти новую планету для людей"
        )

        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.mainRecycler.layoutManager = LinearLayoutManager(requireActivity())

        initHomeFragment()
        return binding.root
    }

    //находим наш RV
    private fun initHomeFragment() {
        filmsAdapter =
            FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                override fun click(film: Film) {
                    (requireActivity() as MainActivity).launchDetailsFragment(film)
                }
            })
        filmsAdapter.addItems(filmsDataBase)
        //Присваиваем адаптер
        binding.mainRecycler.adapter = filmsAdapter
        //Применяем декоратор для отступов
        val decorator = TopSpacingItemDecoration(8)
        binding.mainRecycler.addItemDecoration(decorator)
    }
}

/*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        initHomeFragment()
        return binding.root
    }

    //находим наш RV
    private fun initHomeFragment() {
        filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
            override fun click(film: Film) {
                (requireActivity() as MainActivity).launchDetailsFragment(film)
            }
        })
        filmsAdapter.addItems(filmsDataBase)
        //Присваиваем адаптер
        binding.mainRecycler.adapter = filmsAdapter
        //Применяем декоратор для отступов
        val decorator = TopSpacingItemDecoration(8)
        binding.mainRecycler.addItemDecoration(decorator)
    }
}


 */