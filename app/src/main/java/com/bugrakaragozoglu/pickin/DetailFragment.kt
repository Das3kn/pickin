package com.bugrakaragozoglu.pickin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView


class DetailFragment : Fragment() {

    private var movieId: Int = 0
    private lateinit var movieTitle: TextView
    private lateinit var movieOverview: TextView
    private lateinit var movieBackdropPath: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = arguments
        if (data == null) {
            println("Error")
        } else {
            movieId = data.getInt("movieId")


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_detail, container, false)

        movieTitle = root?.findViewById<View>(R.id.movieTitle) as TextView
        movieOverview = root?.findViewById<View>(R.id.movieOverview) as TextView
        movieBackdropPath = root?.findViewById<View>(R.id.movieBackdropPath) as ImageView
        movieTitle.id = movieId
        movieOverview.id = movieId
        movieBackdropPath.id = movieId
        return root
    }



}









