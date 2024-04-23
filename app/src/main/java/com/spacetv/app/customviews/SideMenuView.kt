package com.spacetv.app.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.leanback.widget.BrowseFrameLayout
import com.spacetv.app.R
import com.spacetv.app.utils.Common
import com.spacetv.app.utils.Constants

class SideMenuView(context: Context, attrs: AttributeSet) :LinearLayout(context, attrs),
    View.OnKeyListener {

    private lateinit var navBar: BrowseFrameLayout
    lateinit var btnSearch: TextView
    lateinit var btnHome: TextView
    lateinit var btnTvshow: TextView
    lateinit var btnMovie: TextView
    lateinit var btnSports: TextView
    lateinit var btnSetting: TextView

    var SIDE_MENU = false
    var selectedMenu = Constants.MENU_HOME

    lateinit var lastSelectedMenu: View

    init {
        inflate(context, R.layout.activity_side_menu_view, this)

        initView()
        initFocus()
    }

    private fun initView(){
        btnSearch = findViewById(R.id.btn_search)
        btnHome = findViewById(R.id.btn_home)
        btnTvshow = findViewById(R.id.btn_tv)
        btnMovie = findViewById(R.id.btn_movies)
        btnSports = findViewById(R.id.btn_sports)
        btnSetting = findViewById(R.id.btn_settings)

        navBar = findViewById(R.id.blfNavBar)
        btnSearch.setOnKeyListener(this)
        btnHome.setOnKeyListener(this)
        btnTvshow.setOnKeyListener(this)
        btnMovie.setOnKeyListener(this)
        btnSports.setOnKeyListener(this)
        btnSetting.setOnKeyListener(this)

        btnHome.setOnKeyListener(this)
        btnTvshow.setOnKeyListener(this)
        btnMovie.setOnKeyListener(this)
        btnSports.setOnKeyListener(this)
        btnSetting.setOnKeyListener(this)

        /*lastSelectedMenu = btnHome
        lastSelectedMenu.isActivated = true*/
    }

    private fun initFocus(){
        btnSearch.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) setMenuNameFocusView(btnSearch, true) else setMenuNameFocusView(btnSearch, false)
        }

        btnHome.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) setMenuNameFocusView(btnHome, true) else setMenuNameFocusView(btnHome, false)
        }

        btnMovie.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) setMenuNameFocusView(btnMovie, true) else setMenuNameFocusView(btnMovie, false)
        }

        btnTvshow.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) setMenuNameFocusView(btnTvshow, true) else setMenuNameFocusView(btnTvshow, false)
        }

        btnSports.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) setMenuNameFocusView(btnSports, true) else setMenuNameFocusView(btnSports, false)
        }

        btnSetting.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) setMenuNameFocusView(btnSetting, true) else setMenuNameFocusView(btnSetting, false)
        }
    }

    override fun onKey(view: View?, keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_DPAD_CENTER -> {


            }

            KeyEvent.KEYCODE_DPAD_LEFT -> {
                openMenu()
            }

            KeyEvent.KEYCODE_DPAD_RIGHT -> {
                closeMenu()
            }

        }
        return false
    }

    private fun setMenuNameFocusView(view: TextView, inFocus: Boolean) {
        if (inFocus) {
            view.setTextAppearance(R.style.side_menu_text_focus)
        } else
            view.setTextAppearance(R.style.side_menu_text_non_focus)
    }

    private fun switchToLastSelectedMenu() {
        when (selectedMenu) {
            Constants.MENU_SEARCH -> {
                btnSearch.requestFocus()
            }
            Constants.MENU_HOME -> {
                btnHome.requestFocus()
            }
            Constants.MENU_TV -> {
                btnTvshow.requestFocus()
            }
            Constants.MENU_MOVIE -> {
                btnMovie.requestFocus()
            }
            Constants.MENU_SPORTS -> {
                btnSports.requestFocus()
            }
            Constants.MENU_SETTINGS -> {
                btnSetting.requestFocus()
            }
        }
    }

    private fun openMenu() {
        val animSlide : Animation = AnimationUtils.loadAnimation(context, R.anim.slide_in_left)
        navBar.startAnimation(animSlide)

        navBar.requestLayout()
        navBar.layoutParams.width = Common.getWidthInPercent(context, 16)
    }

    private fun closeMenu() {
        navBar.requestLayout()
        navBar.layoutParams.width = Common.getWidthInPercent(context, 5)

        SIDE_MENU = false
    }
}