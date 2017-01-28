/*
    Author: Hiten Patel
    CS4V95.015
    4/28/16
    Project Phase 3

    This is where the user inputs info for the new contact and gets saved to the database
 */
package com.example.hitenpatel.contactmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NewContactScreen extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact_screen);
        nameField = (EditText) findViewById(R.id.name);
        phoneField = (EditText) findViewById(R.id.phone);
        emailField = (EditText) findViewById(R.id.email);
        addressField = (EditText) findViewById(R.id.address);
        notesField = (EditText) findViewById(R.id.notes);
        final TextView cancelButton = (TextView) findViewById(R.id.cancel);
        final TextView saveButton = (TextView) findViewById(R.id.save);
        final ContactInfo newContact = new ContactInfo();

        //cancel new contact and go back to home screen
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewContactScreen.this, MainActivity.class);
                startActivity(intent);

            }
        });

        //save new contact to database
        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                newContact.set_name(nameField.getText().toString());
                newContact.set_phoneNum(phoneField.getText().toString());
                newContact.set_email((emailField.getText().toString()));
                newContact.set_address(emailField.getText().toString());
                newContact.set_notes(notesField.getText().toString());
                dbHandler.addContact(newContact);

            }
        });
    }
}