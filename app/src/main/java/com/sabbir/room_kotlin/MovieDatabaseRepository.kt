package com.sabbir.room_kotlin

import android.app.Application
import androidx.room.Room
import com.sabbir.room_kotlin.data.Actor
import com.sabbir.room_kotlin.data.ExpandedRole
import com.sabbir.room_kotlin.data.Movie
import com.sabbir.room_kotlin.data.MovieDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class MovieDatabaseRepository(application: Application)
    : MovieRepositoty {

    private val db =
        Room.databaseBuilder(
            application,
            MovieDatabase::class.java,
            "MOVIES"
        ).build()



    override val movies = db.dao().getAllMovies()
    override val actors = db.dao().getAllActor()

    override fun getCast(movieId: String)=db.dao().getCast(movieId)

    override suspend fun getMovie(id: String) = withContext(Dispatchers.IO){
        db.dao().getMovie(id)
    }

    override suspend fun getActor(id: String) = withContext(Dispatchers.IO){
        db.dao().getActor(id)
    }

    override suspend fun insert(vararg movies: Movie) = withContext(Dispatchers.IO){
        db.dao().insert(*movies)
    }

    override suspend fun insert(vararg actors: Actor)  = withContext(Dispatchers.IO){
        db.dao().insert(*actors)
    }

    override suspend fun delete(vararg movies: Movie)  = withContext(Dispatchers.IO){
        db.dao().delete(*movies)
    }

    override suspend fun delete(vararg actors: Actor) = withContext(Dispatchers.IO){
        db.dao().insert(*actors)
    }
    override suspend fun resetDatabase()  = withContext(Dispatchers.IO){
        db.dao().resetDatabase()
    }
}