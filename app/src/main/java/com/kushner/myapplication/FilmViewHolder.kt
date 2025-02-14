package com.kushner.myapplication

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kushner.myapplication.databinding.FilmItemBinding

//В конструктор класс передается layout, который мы создали(film_item.xml)
class FilmViewHolder(private val bindingItem : FilmItemBinding) : RecyclerView.ViewHolder(bindingItem.root) {
    //Привязываем view из layout к переменным
    private val title = bindingItem.title
    private val poster = bindingItem.poster
    private val description = bindingItem.description

    //В этом методе кладем данные из film в наши view
    fun bind(film: Film) {
        //Устанавливаем заголовок
        title.text = film.title
        //Устанавливаем постер
        poster.setImageResource(film.poster)
        //Устанавливаем описание
        description.text = film.description
    }
}