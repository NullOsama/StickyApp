package com.company;

import java.util.ArrayList;

public class User
{
    private String fName;
    private String lName;
    private ArrayList<Note> Notes;

    public User(String fName, String lName, ArrayList<Note> notes) {
        this.fName = fName;
        this.lName = lName;
        Notes = notes;
    }
}
