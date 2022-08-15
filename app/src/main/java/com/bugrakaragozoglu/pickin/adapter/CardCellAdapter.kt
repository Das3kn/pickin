package com.bugrakaragozoglu.pickin.adapter


import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bugrakaragozoglu.pickin.R
import com.bugrakaragozoglu.pickin.model.ResponseModel

class CardCellAdapter(var context: Context, var arrayList: ArrayList<ResponseModel>):BaseAdapter() {
     override fun getCount(): Int {
         return arrayList.size
     }

     override fun getItem(position: Int): Any {
         return arrayList.get(position)
     }

     override fun getItemId(position: Int): Long {
         return position.toLong()
     }

     @SuppressLint("ViewHolder")
     override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
         val view:View = View.inflate(context , R.layout.card_cell,null)
         val moviePosterPath: ImageView = view.findViewById(R.id.moviePosterPath)
         val movieTitle: TextView = view.findViewById(R.id.movieTitle)
         val movieOverView: TextView = view.findViewById(R.id.movieOverview)

         val items:ResponseModel = arrayList.get(position)

         moviePosterPath.setImageResource(items.moviePosterPath)
         movieTitle.text = items.movieTitle
         movieOverView.text = items.movieOverview


         return view
     }


 }







