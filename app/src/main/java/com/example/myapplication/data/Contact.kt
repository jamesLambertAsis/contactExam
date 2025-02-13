package com.example.myapplication.data

import androidx.room.Database
import com.example.myapplication.model.Contact

@Database (entities = [Contact::class], version = 1)
abstract class AppDataBase {
}