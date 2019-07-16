package com.company;

import java.util.Calendar;
import java.util.Date;

public class Note
{
    private int Id;
    private String Title;
    private String Text;
    private Date noteDate;
    private static int count;

    public Note(int id, String title, String text)
    {
        Id = id;
        Title = title;
        Text = text;
        this.noteDate = Calendar.getInstance().getTime(); //getting the current date
    }

    public Note()
    {
        this.noteDate = Calendar.getInstance().getTime(); //getting the current date
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
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

    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return  Text + '\'' +
                '}';
    }
}
