package com.example.myapplication.presenter

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.myapplication.R
import com.example.myapplication.domain.repository.ContactRepo

@Composable
fun Home(
    modifier: Modifier = Modifier,
) {

    val showDialog = remember { mutableStateOf(false) }
    val isEditContact = remember { mutableStateOf(false) }

    val contactName = remember { mutableStateOf("") }
    val contactNumber = remember { mutableStateOf("") }

    Box {
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 14.dp, vertical = 6.dp)
        ) {
            for (i in 1..20){
                item {
                    Spacer(modifier = Modifier.height(4.dp))
                    HorizontalDivider()
                    ContactItem("Name - $i", number = "12345 - $i") {
                        isEditContact.value = true
                        showDialog.value = !showDialog.value
                        contactName.value = "Name - $i"
                        contactNumber.value = "12345 - $i"
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
        }
        Button(
            onClick = {
                showDialog.value = !showDialog.value
                isEditContact.value = false
                contactName.value = ""
                contactNumber.value = ""
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 40.dp, bottom = 40.dp)

        ) {
            Text("Add")
        }

        if (showDialog.value){
            Dialog(
                onDismissRequest = { showDialog.value = false }
            ) {
                DialogContact(isEditContact.value, contactName.value, contactNumber.value)
            }
        }
    }
}

@Composable
fun ContactItem(name: String, number: String, onClick: () -> Unit) {

        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Spacer(modifier = Modifier.height(10.dp))
            Text(name[0].toString().uppercase(), textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(name)
                Spacer(modifier = Modifier.height(4.dp))
                Text(number)
            }
            Icon(
                modifier = Modifier.clickable {
                    onClick()
                },
                painter = painterResource(R.drawable.ic_edit),
                contentDescription = null
            )
        }

}

@Composable
fun DialogContact(isEdit: Boolean, name: String, number: String) {

    val contactName = remember { mutableStateOf(name) }
    val contactNumber = remember { mutableStateOf(number) }

    val posBtnLabel = remember { mutableStateOf(if (isEdit) "Ok" else "Add") }

    Column(
        modifier = Modifier.fillMaxWidth().background(Color.White).padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(if (!isEdit) "Add Contact" else "Edit Contact")
        Spacer(modifier = Modifier.height(10.dp))
        //name
        OutlinedTextField(
            value = contactName.value,
            onValueChange = { contactName.value = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        //number
        OutlinedTextField(
            value = contactNumber.value,
            onValueChange = { contactNumber.value = it }
        )
        Spacer(Modifier.height(20.dp))
        Row (
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {}
            ) {
                Text(posBtnLabel.value)
            }

            Button(
                onClick = {}
            ) {
                Text("Cancel")
            }

            if (isEdit) {
                Button(
                    onClick = {}
                ) {
                    Text("Delete")
                }
            }
        }
    }

}