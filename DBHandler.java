/*
    Author: Hiten Patel
    CS4V95.015
    4/28/16
    Project Phase 3

    This class handles the database part of the app which stores the contact info
 */
package com.example.hitenpatel.contactmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Arrays;

public class DBHandler extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    public static final String TABLE_CONTACTS = "Contacts";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_PHONE = "PhoneNum";
    public static final String COLUMN_EMAIL = "Email";
    public static final String COLUMN_ADDRESS = "Address";
    public static final String COLUMN_NOTES = "Notes";
    ArrayList<String> namesList;

    //setting up the database
    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    //creating the database and inputting the column names
    @Override
    public void onCreate(SQLiteDatabase db){
        String query = "CREATE TABLE " + TABLE_CONTACTS + "(" +
                COLUMN_NAME + " TEXT PRIMARY KEY " +
                COLUMN_PHONE + " INTEGER " +
                COLUMN_EMAIL + " TEXT " +
                COLUMN_ADDRESS + " TEXT " +
                COLUMN_NOTES + " TEXT " +
                ");";
        db.execSQL(query);
    }

    //creates a new database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_CONTACTS);
        onCreate(db);
    }

    //add new row
    public void addContact(ContactInfo contact) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, contact.get_name());
        values.put(COLUMN_PHONE, contact.get_phoneNum());
        values.put(COLUMN_EMAIL, contact.get_email());
        values.put(COLUMN_ADDRESS, contact.get_address());
        values.put(COLUMN_NOTES, contact.get_notes());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_CONTACTS, null, values);
        db.close();
    }

    //delete contact
    public void deleteContact(String name){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_CONTACTS, COLUMN_NAME + "=" + name, null);
    }

    //display contacts
    public ArrayList<String> displayContacts(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_CONTACTS, null);
        c.moveToFirst();
        String[] names = c.getColumnNames();
        namesList = new ArrayList<String>();
        namesList.addAll(Arrays.asList(names));
        c.close();
        db.close();
        return namesList;
    }

}
