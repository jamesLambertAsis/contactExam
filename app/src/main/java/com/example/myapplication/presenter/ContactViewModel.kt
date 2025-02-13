package com.example.myapplication.presenter

import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.repository.ContactRepo
import com.example.myapplication.model.Contact

class ContactViewModel( contactRepo: ContactRepo): ViewModel() {

    private val repo = contactRepo

    fun getAllContacts() = repo.getContactList()

    fun updateContact(contact: Contact) {
        repo.updateContact(contact)
    }

    fun deleteContact(id: String) {
        repo.deleteContactById(id)
    }

    fun getContactById(id: String){
        repo.getContactById(id)
    }

}