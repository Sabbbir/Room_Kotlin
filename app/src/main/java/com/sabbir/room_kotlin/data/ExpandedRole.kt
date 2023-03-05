package com.sabbir.room_kotlin.data

import androidx.room.Relation

data class ExpandedRole(
    val actorId: String,
    @Relation(parentColumn = "actorId",
    entityColumn = "id")
val actor: Actor,
    val character: String,
    val orderInCredits: Int,
)
