package com.company;

import java.util.Calendar;
import java.util.Date;

public class Note
{
    private int Id;
    private String Text;
    private String  noteDate;
    private static int count = 0;

    public Note(int id, String text)
    {
        Id = id;
        Text = text;
        Calendar calendar = Calendar.getInstance();
        this.noteDate =calendar.get(Calendar.DATE) +"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get( Calendar.YEAR)+" "+ calendar.get( Calendar.HOUR)+":"+calendar.get( Calendar.MINUTE ); //getting the current date
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

    public String getNoteDate() {
        return noteDate;
    }


    @Override
    public String toString() {
        return  Text + '\'' +
                '}';
    }

    public void setNoteDate(String date)
    {
        this.noteDate = date;
    }
}
