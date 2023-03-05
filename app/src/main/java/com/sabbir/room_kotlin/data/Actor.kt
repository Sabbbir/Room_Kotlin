package com.sabbir.room_kotlin.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Actor(
    @PrimaryKey var id: String = UUID.randomUUID().toString(),
    var name: String
    )