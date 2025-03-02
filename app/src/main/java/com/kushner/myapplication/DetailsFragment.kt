package com.kushner.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

import com.kushner.myapplication.databinding.FragmentDetailsBinding
import com.kushner.myapplication.databinding.FragmentHomeBinding

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        initDetails()
        return binding.root
    }

    private fun initDetails() {
        val film = arguments?.get("film") as Film

        //Устанавливаем заголовок

        binding.detailsToolbar.title = film.title
        binding.detailsPoster.setImageResource(film.poster)
        binding.detailsDescription.text = film.description
    }
}