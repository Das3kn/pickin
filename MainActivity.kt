package com.bugrakaragozoglu.pickin

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bugrakaragozoglu.pickin.adapter.CardCellAdapter
import com.bugrakaragozoglu.pickin.model.ResponseModel
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel

class MainActivity : AppCompatActivity() ,  OnItemClickListener{
    //private val baseURL: String = "https://api.themoviedb.org/3/"

    //private var ResponseModel : ArrayList<ResponseModel>? = null
    //private lateinit var binding : ActivityMainBinding
    private var listView: ListView? = null
    private var movieAdapter: CardCellAdapter? = null
    private var arrayList: ArrayList<ResponseModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
   //invalidate catch and restart
        val imageList = ArrayList<SlideModel>()
        imageList.add(
            SlideModel(
                "https://image.tmdb.org/t/p/original//nW5fUbldp1DYf2uQ3zJTUdachOu.jpg",
                "Lightyear"
            )
        )
        imageList.add(
            SlideModel(
                "https://image.tmdb.org/t/p/original//wcKFYIiVDvRURrzglV9kGu7fpfY.jpg",
                "Doctor Strange in the Multiverse of Madness"
            )
        )
        imageList.add(
            SlideModel(
                "https://image.tmdb.org/t/p/original//AfvIjhDu9p64jKcmohS4hsPG95Q.jpg",
                "The Black Phone"
            )
        )
        imageList.add(
            SlideModel(
                "https://image.tmdb.org/t/p/original//odJ4hx6g6vBt4lBWKFD1tI8WS4x.jpg",
                "Top Gun: Maverick"
            )
        )
        imageList.add(
            SlideModel(
                "https://image.tmdb.org/t/p/original//393mh1AJ0GYWVD7Hsq5KkFaTAoT.jpg",
                "Jurassic World Dominion"
            )
        )
        imageList.add(
            SlideModel(
                "https://image.tmdb.org/t/p/original//qTkJ6kbTeSjqfHCFCmWnfWZJOtm.jpg",
                "Minions: The Rise of Gru"
            )
        )

        val imageSlider = findViewById<ImageSlider>(R.id.imageSlider)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        listView = findViewById(R.id.card_view_list_view)
        arrayList = ArrayList()
        arrayList = setDataItem()
        movieAdapter = CardCellAdapter(applicationContext, arrayList!!)
        listView?.adapter = movieAdapter
       // listView?.setOnItemClickListener { adapterView, view, i, l ->

       // }
            listView?.onItemClickListener=this


        //api key : 808f9e99f5c44c0619283e52ca6b455c
        //val mainActivity = this
        // binding.recyclerview.apply {
        //   layoutManager = GridLayoutManager(applicationContext,3)
        //  adapter = CardCellAdapter(responseListForExample)
        //}


    }

    private fun setDataItem(): ArrayList<ResponseModel> {
        val listItem: ArrayList<ResponseModel> = ArrayList()
        listItem.add(ResponseModel(
            "Dragonball",
         "SREDTFYGUHJIKOL",
        R.drawable.dragonballposterpath

        ))



        return listItem
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val items: ResponseModel = arrayList?.get(position)!!
        Toast.makeText(applicationContext, items.movieTitle, Toast.LENGTH_LONG).show()
    }

    // override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
     //   val items: ResponseModel = arrayList?.get(position)!!
       // Toast.makeText(applicationContext, items.movieTitle, Toast.LENGTH_LONG).show()
    //}


}






