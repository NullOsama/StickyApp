package com.company;

import java.util.Calendar;
import java.util.Date;

public class Note
{
    private int Id;
    private String Text;
    private Date noteDate;
    private static int count;

    public Note(int id, String text)
    {
        Id = id;
        Text = text;
        this.noteDate = Calendar.getInstance().getTime(); //getting the current date
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public Date getNoteDate() {
        return noteDate;
    }


    public static void setCount(int count) {
        Note.count = count;
    }

    @Override
    public String toString() {
        return  Text + '\'' +
                '}';
    }
}
