package com.sabbir.room_kotlin.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
abstract class MovieDao {
    @Query("SELECT * FROM Movie")
    abstract fun getAllMovies(): Flow< List<Movie>>

    @Query("SELECT * FROM Actor")
    abstract fun getAllActor() : Flow<List<Actor>>

    @Query("SELECT * FROM Movie WHERE id= :id")
    abstract fun getMovie(id: String): Movie

    @Query("SELECT * FROM Actor WHERE id= :id")
    abstract fun getActor(id: String): Actor


    @Transaction
    @RewriteQueriesToDropUnusedColumns
    @Query("SELECT * FROM Role WHERE movieId = :movieId ORDER BY orderInCredits")
    abstract fun getCast(movieId: String): Flow<List<ExpandedRole>>

    @Insert
    abstract fun insert(vararg movies: Movie)
    @Insert
    abstract fun insert(vararg actors: Actor)
    @Insert
    abstract fun insert(vararg roles: Role)

    @Update
    abstract fun update(vararg movies: Movie)
    @Update
    abstract fun update(vararg actors: Actor)
    @Update
    abstract fun update(vararg roles: Role)

    @Delete
    abstract fun delete(vararg movies: Movie)
    @Delete
    abstract fun delete(vararg actors: Actor)
    @Delete
    abstract fun delete(vararg roles: Role)

    @Query("DELETE FROM Movie")
    abstract fun clearMovies()

    @Query("DELETE FROM Actor")
    abstract fun clearActors()

    @Query("DELETE FROM Role")
    abstract fun clearRoles()

    @Transaction
open fun resetDatabase(){
    clearMovies()
    clearActors()
    clearRoles()
    insert(
        Movie("m1", "Transporter 1","A Desc Transporter 1"),
        Movie("m2", "Transporter 2","A Desc Transporter 2"),
        Movie("m3", "Transporter 3","A Desc Transporter 3"),
        Movie("m4", "Transporter 4","A Desc Transporter 4"),
    )
    insert(
        Actor("a1","Jason 1"),
        Actor("a2","Jason 2"),
        Actor("a3","Jason 3"),
        Actor("a4","Jason 4"),
        Actor("a5","Jason 5"),
    )
    insert(
        Role("m1","a1","Frank Morty",1),
        Role("m1","a3","Franky",2),
        Role("m2","a1","Mortyr",1),
        Role("m2","a4","Frany",2),
        Role("m3","a2","Franrty",2),
        Role("m3","a1","Fnk y",2),
        Role("m4","a2","Frads Sfoa",1),
        Role("m4","a5","Afdfy aAF",2),
        )
}




}