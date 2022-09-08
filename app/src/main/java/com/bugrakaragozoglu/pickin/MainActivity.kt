package com.bugrakaragozoglu.pickin

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.bugrakaragozoglu.pickin.adapter.CardCellAdapter
import com.bugrakaragozoglu.pickin.model.CommonResponse
import com.bugrakaragozoglu.pickin.model.ResponseModel
import com.bugrakaragozoglu.pickin.service.TheMovieClient
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() ,  OnItemClickListener{


    //private var ResponseModel : ArrayList<ResponseModel>? = null
    //private lateinit var binding : ActivityMinBinding
    private var listView: ListView? = null
    private var movieAdapter: CardCellAdapter? = null
    private var arrayList: ArrayList<ResponseModel>? = null

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        TheMovieClient.getInstance().getNowPlaying()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleNowPlayingResponse, this::onError)


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

    private fun handleNowPlayingResponse(result: CommonResponse){
        print(Gson().toJson(result))
        result.movies
    }

    private fun onError(t : Throwable){
        print(t.message)
    }

    private fun setDataItem(): ArrayList<ResponseModel> {
        val listItem:ArrayList<ResponseModel> = ArrayList()
        listItem.add(ResponseModel(
            "Dragonball",
         "Dragonball Overview",
        R.drawable.dragonballposterpath,
            R.drawable.backdroppath

        ))
        listItem.add(ResponseModel(
            "Chickenhare",
            "Chickenhare Overview",
            R.drawable.chickenhareposterpath,
            R.drawable.backdroppath

        ))
        listItem.add(ResponseModel(
            "Fireheart",
            "Fireheart Overview",
            R.drawable.fireheartposterpath,
            R.drawable.backdroppath

        ))
        listItem.add(ResponseModel(
            "Memory",
            "Memory Overview",
            R.drawable.memoryposterpath,
            R.drawable.backdroppath

        ))
        listItem.add(ResponseModel(
            "Minions",
            "Minions Overview",
            R.drawable.minionsposterpath,
            R.drawable.backdroppath

        ))
        listItem.add(ResponseModel(
            "Sharkbait",
            "Sharkbait Overview",
            R.drawable.sharkbaitposterpath,
            R.drawable.backdroppath

        ))
        listItem.add(ResponseModel(
            "Spiderman",
            "Spiderman Overview",
            R.drawable.spidermanposterpath,
            R.drawable.backdroppath

        ))
        listItem.add(ResponseModel(
            "Superpets",
            "Superpets Overview",
            R.drawable.superpetsposterpath,
            R.drawable.backdroppath

        ))
        listItem.add(ResponseModel(
            "The Northman",
            "The Northman Overview",
            R.drawable.thenorthmanposterpath,
            R.drawable.backdroppath

        ))

        return listItem
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item: ResponseModel = arrayList?.get(position)!!
        val movieId = item.id
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val detailFragment = DetailFragment()
        val bundle = Bundle()
        bundle.putInt("movieId",movieId.toInt())
        detailFragment.arguments=bundle
        fragmentTransaction.replace(R.id.mainAct,detailFragment)
        fragmentTransaction.addToBackStack("mainAct")
        fragmentTransaction.commit()




    //Toast.makeText(applicationContext, items.movieTitle, Toast.LENGTH_LONG).show()
    }


}






