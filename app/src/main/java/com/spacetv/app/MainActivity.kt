package com.spacetv.app

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.leanback.widget.BrowseFrameLayout
import com.spacetv.app.fragment.GenresFragment
import com.spacetv.app.fragment.LanguageFragment
import com.spacetv.app.fragment.MovieFragment
import com.spacetv.app.fragment.SearchFragment
import com.spacetv.app.fragment.SettingsFragment
import com.spacetv.app.fragment.SportsFragment
import com.spacetv.app.fragment.TvShowFragment
import com.spacetv.app.utils.Common
import com.spacetv.app.utils.Constants

class MainActivity : FragmentActivity(){

    private lateinit var navBar: BrowseFrameLayout
    private lateinit var fragmentContainer: FrameLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}