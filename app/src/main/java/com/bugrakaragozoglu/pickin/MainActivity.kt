package com.bugrakaragozoglu.pickin

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import coil.imageLoader
import coil.request.ImageRequest
import com.bugrakaragozoglu.pickin.adapter.CardCellAdapter
import com.bugrakaragozoglu.pickin.model.CommonResponse
import com.bugrakaragozoglu.pickin.model.Movie
import com.bugrakaragozoglu.pickin.service.TheMovieClient
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.card_cell.*

class MainActivity : AppCompatActivity() ,  OnItemClickListener {


    private var listView: ListView? = null
    private var movieAdapter: CardCellAdapter? = null
    private var arrayList: ArrayList<Movie>? = null

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        TheMovieClient.getInstance().getNowPlaying()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleNowPlayingResponse, this::onError)

        TheMovieClient.getInstance().getUpComing()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleUpComingResponse, this::onError)

        listView = findViewById(R.id.card_view_list_view)
        arrayList = ArrayList()



    }

    private fun buildSlideView(movieList: List<Movie>) {
        val imageList = ArrayList<SlideModel>()
        movieList.forEach { movie ->
            val slideModel = SlideModel(
                imageUrl = "https://image.tmdb.org/t/p/original" + movie.backdrop_path,
                title = movie.title
            )
            imageList.add(slideModel)
        }
        val imageSlider = findViewById<ImageSlider>(R.id.imageSlider)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)
    }

    private fun setListItem(itemList: ArrayList<Movie>) {
        movieAdapter = CardCellAdapter(applicationContext, itemList)
        listView?.adapter = movieAdapter
        listView?.onItemClickListener = this
        listView?.setOnItemClickListener { parent, view, position, id ->

        }
    }

    private fun handleUpComingResponse(result: CommonResponse) {
        print(Gson().toJson(result))
        setListItem(itemList = ArrayList(result.movies))
    }

    private fun handleNowPlayingResponse(result: CommonResponse) {
        print(Gson().toJson(result))
        buildSlideView(movieList = result.movies)
    }

    private fun onError(t: Throwable) {
        print(t.message)
    }


    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item: Movie = arrayList?.get(position)!!
        val movieId = item.id
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val detailFragment = DetailFragment()
        val bundle = Bundle()
        bundle.putInt("movieId", movieId.toInt())
        detailFragment.arguments = bundle
        fragmentTransaction.replace(R.id.mainAct, detailFragment)
        fragmentTransaction.addToBackStack("mainAct")
        fragmentTransaction.commit()


        //Toast.makeText(applicationContext, items.movieTitle, Toast.LENGTH_LONG).show()
    }

}





