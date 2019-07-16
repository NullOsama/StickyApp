package com.company;

import java.util.Scanner;

public class Main {
    static public  Scanner cin;
    static{
        Scanner cin = new Scanner(System.in);
    }
    public static void main(String[] args)
    {
        showMainMenu();
        Select();
    }
    private static void Select()
    {

        System.out.println("What Is Your Choice: ");
        String Choice = Main.cin.nextLine();
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


    private static void showMainMenu()
    {
        System.out.println("Welcome to the brand new “Sticky Notes”!\n" +
                "Here is the list of operation this program offers:\n" +
                "1- Add new user\n" +
                "2- Add new note\n" +
                "3- View notes for a specific user\n" +
                "4- Exit\n");
    }
    private static void showNewUserMenu()
    {
        System.out.println("Welcome aboard new user!\n");
        System.out.println("Please let me know your first name:");
        String firstName=Main.cin.nextLine();
        System.out.println("Great "+ firstName+", now please enter your last name:");
        String lastName=Main.cin.nextLine();
        System.out.println("Nice to meet you "+firstName+" " +lastName);
        System.out.println("Click Enter to return to main menu");
        Main.cin.nextLine();
        User newUser= new User(firstName,lastName);

    }
}
