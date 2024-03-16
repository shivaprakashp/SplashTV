package com.spacetv.app

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.spacetv.app.ui.BaseActivity

/**
 * Loads [MainFragment].
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_browse_fragment, MainFragment())
                .commitNow()
        }
    }
}