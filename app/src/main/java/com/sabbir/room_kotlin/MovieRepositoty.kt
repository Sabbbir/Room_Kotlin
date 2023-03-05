package com.sabbir.room_kotlin

import com.sabbir.room_kotlin.data.Actor
import com.sabbir.room_kotlin.data.ExpandedRole
import com.sabbir.room_kotlin.data.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepositoty {
    val movies: Flow<List<Movie>>
    val actors: Flow<List<Actor>>

    fun getCast(movieId: String): Flow<List<ExpandedRole>>
    suspend fun getMovie(id: String): Movie
    suspend fun getActor(id: String): Actor
    suspend fun insert(vararg movies: Movie)
    suspend fun insert(vararg actors: Actor)
    suspend fun delete(vararg movies: Movie)
    suspend fun delete(vararg actors: Actor)
    suspend fun resetDatabase()



}