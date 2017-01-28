/*
    Author: Hiten Patel
    CS4V95.015
    4/28/16
    Project Phase 3

    This class saves all the contact info for one person. An instance of the class is used in the
    NewContactScreen class to represent 1 contact.
 */
package com.example.hitenpatel.contactmanager;

public class ContactInfo {
    private String name=null;
    private String phoneNum=null;
    private String email=null;
    private String address=null;
    private String notes=null;

    public ContactInfo () {

    }
    public void set_name(String cName){
        this.name = cName;
    }
    public void set_phoneNum(String cPhone){
        this.phoneNum = cPhone;
    }

    public void set_email(String cEmail){
        this.email = cEmail;
    }

    public void set_address(String cAddress) {
        this.address = cAddress;
    }

    public void set_notes(String cNotes){
        this.notes = cNotes;
    }

    public String get_name(){
        return name;
    }
    public String get_phoneNum(){
        return phoneNum;
    }
    public String get_email(){
        return email;
    }
    public String get_address(){
        return address;
    }
    public String get_notes(){
        return notes;
    }
}
