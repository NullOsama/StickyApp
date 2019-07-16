package com.company;

import java.util.ArrayList;

public class User
{
    private String fName;
    private String lName;
    private ArrayList<Note> notes = null;
    private static int count = 0;

    public User(String fName, String lName)
    {
        this.fName = fName;
        this.lName = lName;
        notes = new ArrayList<Note>();
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
    public void setfName(String fName)
    {
        this.fName = fName;
    }
    public String getlName()
    {
        return lName;
    }
    public void setlName(String lName)
    {
        this.lName = lName;
    }

    public ArrayList<Note> getNotes()
    {
        return notes;
    }

    public void addNote(Note note)
    {
        this.notes.add(note);
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
        return notes.size();
    }
}
