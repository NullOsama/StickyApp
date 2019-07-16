package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static  Scanner cin= new Scanner(System.in);

    public static void main(String[] args)
    {
        showMainMenu();
    }

    private static void fetchUsers()
    {
        try (Stream<Path> paths = Files.walk(Paths.get("Resources")))
        {
            var stringPaths = paths.toArray();
            for(int i = 0; i < stringPaths.length; i++)
            {
                File file = new File(stringPaths[i].toString());
                Scanner sc = new Scanner(file);
                String []name = stringPaths[i].toString().substring(9).split("_");


                User user = new User();
                user.setfName(name[0]);
                user.setlName(name[1]);


                String line = null;
                while (sc.hasNextLine())
                {
                    line = sc.nextLine();
                    if(!line.equals("\n"))
                    {
                        Note note = new Note();
                        note.setNoteDate(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(line));
                        note.setText(sc.nextLine());
                        user.addNote(note);
                    }
                }
                Server.usersList.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
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
        //check if its exist or not
        if(Server.checkUserExistance(firstName+" "+lastName)!=null)
        {
            System.out.println("This user exist :) ");
            return;
        }

        System.out.println("Nice to meet you "+firstName+" " +lastName);
        User newUser= new User(firstName,lastName);
        Server.usersList.add(newUser);
        Server.saveUser(newUser);
        System.out.println("Click Enter to return to main menu");
        Main.cin.nextLine();

    }
    private static void addNoteUserMenu()
    {
        System.out.println(
                "Let’s add a new note ...\n" +
                "Please enter your full name first:");
        String firstLastName=Main.cin.nextLine();
        //check Userexistance
        User exist=Server.checkUserExistance(firstLastName);
        if(exist==null)
        {
            System.out.println
                    (
                    "\nOh! Sorry the user name was not found, please check the name again and if this is your first time here," +
                            " please go ahead and create a new user from the main menu ...\n" +
                    "Click Enter to return to main menu"
                    );
            return ;
        }
        System.out.println
                (
                "Your record is found, I’m now opening your file ….\n" +
                "Ready!\n" +
                "Please enter your note:"
                );
        String newNote=Main.cin.nextLine();
        System.out.println("################");
        //Add Node
        Note new_Note=new Note(exist.noteCount()+1,newNote);
        exist.addNote(new_Note);
        System.out.println
                (
                "Your note has been well received, 1 second while saving it ….\n" +
                "Done!\n"
                );
        System.out.println("Click Enter to return to main menu");
        Main.cin.nextLine();
    }
}
