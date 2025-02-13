package com.example.myapplication.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDao {

    @Query("SELECT * FROM contact")
    fun getAllContacts(): List<ContactDao>

    @Query("SELECT * FROM contact where id IN (:contactId)")
    fun getContactById(contactId: String)

    @Query("DELETE FROM contact where id IN (:contactId)")
    fun deleteContactById(contactId: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateContact(contactId: String)
}