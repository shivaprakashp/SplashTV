package com.spacetv.app

import android.app.Application
import com.spacetv.app.api.ApiService
import com.spacetv.app.api.RetrofitHelper
import com.spacetv.app.api.TmdbRepo

class MyApplication : Application() {

    lateinit var tmdbRepo : TmdbRepo

    override fun onCreate() {
        super.onCreate()

        init()
    }

    private fun init(){
        val service = RetrofitHelper.getInstance().create(ApiService::class.java)
        tmdbRepo = TmdbRepo(service)
    }
}