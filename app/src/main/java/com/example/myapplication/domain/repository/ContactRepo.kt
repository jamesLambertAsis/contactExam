package com.example.myapplication.domain.repository

import com.example.myapplication.model.Contact

interface ContactRepo {

    fun getContactList(): List<Contact>

    fun deleteContactById(id: String)

    fun updateContact(contact: Contact)

    fun getContactById(id: String)

}