package com.example.myapplication.model

import androidx.room.Entity

@Entity(tableName = "contact")
data class Contact(
    val id: String = "",
    val name: String = "",
    val contact: String = ""
)
