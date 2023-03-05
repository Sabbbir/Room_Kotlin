package com.sabbir.room_kotlin.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        Movie::class,
    Actor::class,
    Role::class
    ],
    exportSchema = false
)
abstract class MovieDatabase: RoomDatabase() {
    abstract fun dao(): MovieDao
}