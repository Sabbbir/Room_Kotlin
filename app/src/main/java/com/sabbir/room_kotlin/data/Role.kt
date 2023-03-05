package com.sabbir.room_kotlin.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(
    primaryKeys = ["actorId", "movieId"],
    indices = [
        Index(value = ["actorId"]),
        Index(value = ["movieId"])
              ],
    foreignKeys = [
        ForeignKey(
            entity = Actor::class,
            parentColumns = ["id"],
            childColumns = ["actorId"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Movie::class,
            parentColumns = ["id"],
            childColumns = ["movieId"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
class Role (
    var movieId: String,
    var actorId: String,
    var character: String,
    var orderInCredits: Int
    )