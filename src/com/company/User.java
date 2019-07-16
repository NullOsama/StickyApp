package com.company;

import java.util.ArrayList;

public class User
{
    private String fName;
    private String lName;
    private ArrayList<Note> Notes = null;
    private static int count = 0;

    public User(String fName, String lName)
    {
        this.fName = fName;
        this.lName = lName;
        Notes = new ArrayList<Note>();
        count++;
    }
    public User()
    {
        count++;
    }

    public String getfName()
    {
        return fName;
    }
    public String getFirstLastName() {
        return fName+" "+lName;
    }
    public String getlName()
    {
        return lName;
    }
    public void addNote(Note note)
    {
        Notes.add(note);
    }
    public static int getCount()
    {
        return count;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "First Name='" + fName + '\'' +
                ", Last Name='" + lName + '\'' +
                '}';
    }
    public int noteCount(){
        return Notes.size();
    }
}
