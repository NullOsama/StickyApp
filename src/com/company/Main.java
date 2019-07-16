package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        ShowMenu();
        Select();
    }
    private static ArrayList<User> fetchUsers()
    {
        return new ArrayList<User>();
    }

    private static void saveUser(User user)
    {
        String userName = user.getfName() + "_" + user.getlName();
        String userFilePath = "Resources" + "//" + userName + ".txt";
        try {
            File file = new File(userFilePath);
            if(!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateUser(User user, Note note)
    {
        String userName = user.getfName() + "_" + user.getlName();
        String userFilePath = "Resources" + "//" + userName + ".txt";

        try(FileWriter fw = new FileWriter(userFilePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(note.getNoteDate());
            out.println(note.getText());
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
            e.printStackTrace();
        }
    }

    private static void Select()
    {
        Scanner cin = new Scanner(System.in);
        System.out.println("What Is Your Choice: ");
        String Choice = cin.nextLine();
        switch (Choice)
        {
            case "1":break;
            case "2":break;
            case "3":break;
            case "4":
                System.exit(0);
                break;
        }
    }


    private static void ShowMenu()
    {
        System.out.println("Welcome to the brand new “Sticky Notes”!\n" +
                "Here is the list of operation this program offers:\n" +
                "1- Add new user\n" +
                "2- Add new note\n" +
                "3- View notes for a specific user\n" +
                "4- Exit\n");
    }

}
