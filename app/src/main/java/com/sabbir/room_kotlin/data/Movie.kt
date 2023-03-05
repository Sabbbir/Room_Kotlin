package com.sabbir.room_kotlin.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Movie(
    @PrimaryKey var id: String = UUID.randomUUID().toString(),
    var title: String,
    var description: String,


)
