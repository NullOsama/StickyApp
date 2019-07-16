package com.company;

import java.util.Calendar;
import java.util.Date;

public class Note
{
    private int Id;
    private String Title;
    private String Text;
    private Date noteDate;
    public Note(int id, String title, String text) {
        Id = id;
        Title = title;
        Text = text;
        this.noteDate = Calendar.getInstance().getTime(); //getting the current date
    }

    public Note()
    {
        this.noteDate = Calendar.getInstance().getTime(); //getting the current date
    }
}
