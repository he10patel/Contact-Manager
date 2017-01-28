/*
    Author: Hiten Patel
    CS4V95.015
    4/28/16
    Project Phase 3
 */
package com.example.hitenpatel.contactmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity  {

    //declaring UI buttons and fields
    DBHandler dbHandler;
    EditText nameField;
    EditText phoneField;
    EditText emailField;
    EditText addressField;
    EditText notesField;
    TextView addButton;
    TextView dialButton;
    ListView contactList;
    ArrayList<String> namesList = new ArrayList<String>();
    ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = (TextView) findViewById(R.id.add);
        dialButton = (TextView) findViewById(R.id.dial);
        contactList = (ListView) findViewById(R.id.contactList);
        dbHandler = new DBHandler(this, null, null, 1);
        nameField = (EditText) findViewById(R.id.name);
        phoneField = (EditText) findViewById(R.id.phone);
        emailField = (EditText) findViewById(R.id.email);
        addressField = (EditText) findViewById(R.id.address);
        notesField = (EditText) findViewById(R.id.notes);


        //create new contact
        addButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, NewContactScreen.class);
                startActivity(intent);

            }
        });
        //dial button sends an intent to the phone app where the user can dial a number
        dialButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
            }
        });


        namesList = dbHandler.displayContacts();
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, namesList);
        contactList.setAdapter(listAdapter);




    }



}