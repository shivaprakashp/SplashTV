package com.spacetv.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spacetv.app.api.Response
import com.spacetv.app.api.TmdbRepo
import com.tutorial.tvapp.model.CastResponse
import com.tutorial.tvapp.model.DetailResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewmodel(val repo: TmdbRepo, id: Int) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getMovieDetails(id)
            repo.getMovieCast(id)
        }
    }

    val movieDetails: LiveData<Response<DetailResponse>>
        get() = repo.movieDetail

    val castDetails: LiveData<Response<CastResponse>>
        get() = repo.castDetail
}