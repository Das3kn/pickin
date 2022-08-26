package com.bugrakaragozoglu.pickin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView





class DetailFragment : Fragment() {

    private var movieId: Int? = null
    private lateinit var movieTitle: TextView
    private lateinit var movieOverview: TextView
    private lateinit var movieBackdropPath: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = arguments
        val movieId = data!!.getInt("movieId")
            movieTitle = view?.findViewById<View>(R.id.movieTitle) as TextView
            movieOverview = view?.findViewById<View>(R.id.movieOverview) as TextView
            movieBackdropPath = view?.findViewById<View>(R.id.movieBackdropPath) as ImageView
            movieTitle.id = movieId
            movieOverview.id = movieId
            movieBackdropPath.id = movieId

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }




