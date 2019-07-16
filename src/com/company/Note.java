package com.company;

import java.util.Calendar;
import java.util.Date;

public class Note
{
    private int Id;
    private String Text;
    private Date noteDate;
    private static int count = 0;

    public Note(int id, String text)
    {
        Id = id;
        Text = text;
        this.noteDate = Calendar.getInstance().getTime(); //getting the current date
        count++;
    }

    public Note()
    {
        count++;
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


    @Override
    public String toString() {
        return  Text + '\'' +
                '}';
    }

    public void setNoteDate(Date date)
    {
        this.noteDate = date;
    }
}
