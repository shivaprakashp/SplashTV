package com.spacetv.app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.spacetv.app.R
import com.spacetv.app.ui.views.TitleDescriptionView
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class HomeActivity : BaseActivity() {

    lateinit var imgBanner: ImageView
    lateinit var listFragment: ListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        imgBanner = findViewById(R.id.img_banner)

        listFragment = ListFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.list_fragment, listFragment)
        transaction.commit()


        val gson = Gson()
        val i: InputStream = this.assets.open("movies.json")
        val br = BufferedReader(InputStreamReader(i))
        val dataList: DataModel = gson.fromJson(br, DataModel::class.java)

        listFragment.bindData(dataList)

        listFragment.setOnContentSelectedListener {
            updateBanner(it)
        }

    }

    private fun updateBanner(dataList: DataModel.Result.Detail) {
        findViewById<TitleDescriptionView>(R.id.view_home_title_description).bindData(dataList)
        val url = "https://www.themoviedb.org/t/p/w780" + dataList.backdrop_path
        Glide.with(this).load(url).into(imgBanner)
        //TODO continue to implement sliding view
    }

}