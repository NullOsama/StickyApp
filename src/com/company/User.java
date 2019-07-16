package com.company;

import java.util.ArrayList;

public class User
{
    private String fName;
    private String lName;
    private ArrayList<Note> Notes = null;

    public User(String fName, String lName, ArrayList<Note> notes)
    {
        this.fName = fName;
        this.lName = lName;
        Notes = notes;
    }
    public User()
    {

    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public ArrayList<Note> getNotes() {
        return Notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        Notes = notes;
    }

    @Override
    public String toString() {
        return "User{" +
                "First Name='" + fName + '\'' +
                ", Last Name='" + lName + '\'' +
                '}';
    }

}
