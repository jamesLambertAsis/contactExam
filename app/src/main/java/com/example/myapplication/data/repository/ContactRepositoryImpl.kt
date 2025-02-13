package com.example.myapplication.data.repository

import com.example.myapplication.data.ContactDao
import com.example.myapplication.domain.repository.ContactRepo
import com.example.myapplication.model.Contact

class ContactRepositoryImpl(contactDao: ContactDao): ContactRepo {

    private val dao = contactDao

    override fun getContactList(): List<Contact> {
        return dao.getAllContacts()
    }

    override fun deleteContactById(id: String) {
        dao.deleteContactById(id)
    }

    override fun updateContact(contact: Contact) {
        dao.updateContact(contact)
    }

    override fun getContactById(id: String) {
        dao.getContactById(id)
    }

}