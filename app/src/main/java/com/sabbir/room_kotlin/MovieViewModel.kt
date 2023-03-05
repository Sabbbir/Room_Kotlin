package com.sabbir.room_kotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.sabbir.room_kotlin.data.ExpandedRole
import com.sabbir.room_kotlin.data.Movie
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow

class MovieViewModel(application: Application) : AndroidViewModel(application) {
    private val repositoty = MovieDatabaseRepository(application)

    val movies = repositoty.movies
    val actors = repositoty.actors

    private val selectedMovie = MutableSharedFlow<Movie?>()
    @ExperimentalCoroutinesApi
    val cast = selectedMovie.flatMapLatest {
        it?.let{movie ->
            repositoty.getCast(movie.id)

    }?: flow {
        emit(emptyList<ExpandedRole>())
        }
    }

    suspend fun selectMovie(id: String) = selectedMovie.emit(repositoty.getMovie(id))
    suspend fun getMovie(id: String) = repositoty.getMovie(id)
    suspend fun getActor(id: String) = repositoty.getActor(id)
    suspend fun deleteMovie(id: String) = repositoty.delete(repositoty.getMovie(id))
    suspend fun deleteActor(id: String) = repositoty.delete(repositoty.getActor(id))
    suspend fun reserDatabase() = repositoty.resetDatabase()

}