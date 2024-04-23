package com.spacetv.app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.leanback.widget.BrowseFrameLayout
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.spacetv.app.HomeFragment
import com.spacetv.app.R
import com.spacetv.app.fragment.GenresFragment
import com.spacetv.app.fragment.LanguageFragment
import com.spacetv.app.fragment.MovieFragment
import com.spacetv.app.fragment.SearchFragment
import com.spacetv.app.fragment.SettingsFragment
import com.spacetv.app.fragment.SportsFragment
import com.spacetv.app.fragment.TvShowFragment
import com.spacetv.app.ui.views.TitleDescriptionView
import com.spacetv.app.utils.Common
import com.spacetv.app.utils.Constants
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class HomeActivity : FragmentActivity(){

    private lateinit var fragmentContainer: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentContainer = findViewById(R.id.container)
        changeFragment(HomeFragment())
    }

    private fun changeFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()

    }


}