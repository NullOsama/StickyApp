package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        ShowMenu();
        Select();
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
