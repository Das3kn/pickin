package com.bugrakaragozoglu.pickin.adapter


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import coil.Coil.enqueue
import coil.Coil.imageLoader
import coil.ImageLoader
import coil.load
import coil.request.ImageRequest
import com.bugrakaragozoglu.pickin.R
import com.bugrakaragozoglu.pickin.model.Movie
import kotlinx.android.synthetic.main.card_cell.view.*


class CardCellAdapter(var context: Context, var arrayList: ArrayList<Movie>):BaseAdapter() {
     override fun getCount(): Int {
         return arrayList.size
     }

     override fun getItem(position: Int): Any {
         return arrayList.get(position)
     }

     override fun getItemId(position: Int): Long {
         return position.toLong()
     }

     @SuppressLint("ViewHolder", "CheckResult")
     override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
         val view:View = View.inflate(context , R.layout.card_cell,null)

         val moviePosterImageView: ImageView = view.findViewById(R.id.moviePosterPath)
         val movieTitle: TextView = view.findViewById(R.id.movieTitle)
         val movieOverView: TextView = view.findViewById(R.id.movieOverview)

         val items:Movie = arrayList.get(position)

         val baseImageUrl: String = "https://image.tmdb.org/t/p/original"

         moviePosterImageView.load(baseImageUrl+items.poster_path)

         movieTitle.text = items.title
         movieOverView.text = items.overview


         return view
     }


 }













