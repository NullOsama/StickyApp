package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Main {
    public static void printAppName(int times,int waitperiod){
        String colors[]={"\u001B[33m","\u001B[31m","\u001B[32m","\u001B[34m","\u001B[33m" };
        for(int i=0;i<times;i++)
        {
            System.out.println(colors[i%colors.length]+"                                                                                                 \n" +
                    " ad88888ba        88            88                      888b      88                             \n" +
                    "d8\"     \"8b ,d    \"\"            88                      8888b     88              ,d             \n" +
                    "Y8,         88                  88                      88 `8b    88              88             \n" +
                    "`Y8aaaaa, MM88MMM 88  ,adPPYba, 88   ,d8 8b       d8    88  `8b   88  ,adPPYba, MM88MMM ,adPPYba,\n" +
                    "  `\"\"\"\"\"8b, 88    88 a8\"     \"\" 88 ,a8\"  `8b     d8'    88   `8b  88 a8\"     \"8a  88   a8P_____88\n" +
                    "        `8b 88    88 8b         8888[     `8b   d8'     88    `8b 88 8b       d8  88   8PP\"\"\"\"\"\"\"\n" +
                    "Y8a     a8P 88,   88 \"8a,   ,aa 88`\"Yba,   `8b,d8'      88     `8888 \"8a,   ,a8\"  88,  \"8b,   ,aa\n" +
                    " \"Y88888P\"  \"Y888 88  `\"Ybbd8\"' 88   `Y8a    Y88'       88      `888  `\"YbbdP\"'   \"Y888 `\"Ybbd8\"'\n" +
                    "                                             d8'                                                 \n" +
                    "                                            d8'                                                  \n");
            try{TimeUnit.MILLISECONDS.sleep(waitperiod);}catch (Exception e){};
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
        System.out.println(colors[2]+"                                                                                                 \n" +
                " ad88888ba        88            88                      888b      88                             \n" +
                "d8\"     \"8b ,d    \"\"            88                      8888b     88              ,d             \n" +
                "Y8,         88                  88                      88 `8b    88              88             \n" +
                "`Y8aaaaa, MM88MMM 88  ,adPPYba, 88   ,d8 8b       d8    88  `8b   88  ,adPPYba, MM88MMM ,adPPYba,\n" +
                "  `\"\"\"\"\"8b, 88    88 a8\"     \"\" 88 ,a8\"  `8b     d8'    88   `8b  88 a8\"     \"8a  88   a8P_____88\n" +
                "        `8b 88    88 8b         8888[     `8b   d8'     88    `8b 88 8b       d8  88   8PP\"\"\"\"\"\"\"\n" +
                "Y8a     a8P 88,   88 \"8a,   ,aa 88`\"Yba,   `8b,d8'      88     `8888 \"8a,   ,a8\"  88,  \"8b,   ,aa\n" +
                " \"Y88888P\"  \"Y888 88  `\"Ybbd8\"' 88   `Y8a    Y88'       88      `888  `\"YbbdP\"'   \"Y888 `\"Ybbd8\"'\n" +
                "                                             d8'                                                 \n" +
                "                                            d8'                                                  \n");


    }
    public static  Scanner cin= new Scanner(System.in);

    public static void main(String[] args) {
         int choice;
        printAppName(10,100);
            fetchUsers();
            do {
                showMainMenu();
                choice = cin.nextInt();
                cin.nextLine();
                switch (choice)
                {
                    case 1:
                        showNewUserMenu();
                        break;

                    case 2:
                        addNoteUserMenu();
                        break;

                    case 3:
                        printUserNotes();
                        break;

                    default:
                        System.out.println("\u001B[30m Goodbye");
                        System.exit(0);
                }
            }while(true);
    }


    private static void printUserNotes()
    {
        //System.out.println((char)27 + "[31mThis text would show up red" + (char)27 + "[0m");
        System.out.println("\u001B[32mRetrieve your notes? Absolutely! \nPlease let know your full name first: \n");
                String name = Main.cin.nextLine();
        User exist=Server.checkUserExistance(name);
        if(exist==null)
        {
            System.out.println("User Not Found");
            return;
        }
        ArrayList<Note> userNotes = exist.getNotes();
        if(!userNotes.equals(null))
        {
            System.out.println("\u001B[34mFound it!\nHere are your stored notes:\n");
            for (int i = 0; i < userNotes.size(); i++)
            {
                System.out.println("-------------");
                System.out.println(userNotes.get(i).toString());
            }
        }
        else
        {
            System.out.println("Umm, can’t find any saved notes for you.");
        }
        System.out.println("Click Enter to return to main menu\u001B[0m");
        Main.cin.nextLine();
    }

    private static void fetchUsers()
    {
        try (Stream<Path> paths = Files.walk(Paths.get("Resources")))
        {
            var stringPaths = paths.toArray();
            for(int i = 1; i < stringPaths.length; i++)
            {
                File file = new File(stringPaths[i].toString());
                Scanner sc = new Scanner(file);
                String []name = stringPaths[i].toString().substring(10).split("_");


                User user = new User();
                user.setfName(name[0]);
                user.setlName(name[1].substring(0,name[1].length()-4));


                String line = null;
                while (sc.hasNext())
                {
                    line = sc.nextLine();
                    if(!line.trim().equals(""))
                    {
                        Note note = new Note();
                        note.setNoteDate(line);
                        note.setText(sc.nextLine());
                        user.addNote(note);
                    }
                }
                Server.usersList.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static void showMainMenu()
    {
        System.out.println("\u001B[32mWelcome to the brand new \"Sticky Notes\"!\n" +
                "Here is the list of operation this program offers:\n" +
                "\u001B[33m1- Add new user\n" +
                "\u001B[36m2- Add new note\n" +
                "\u001B[35m3- View notes for a specific user\n" +
                "\u001B[37m4- Exit\n\u001B[0m");
    }
    private static void showNewUserMenu()
    {

        System.out.println("\u001B[36mWelcome aboard new user!\n");
        System.out.println("Please let me know your first name:");
        String firstName=Main.cin.nextLine();
        System.out.println("\u001B[32mGreat "+ firstName+", now please enter your last name:");
        String lastName=Main.cin.nextLine();
        //check if its exist or not
        if(firstName.indexOf('_')!= -1  || lastName.indexOf('_')!=-1)
        {
            System.out.println("\u001B[31mAre you kidding with me :( ");
            return ;
        }
        if(Server.checkUserExistance(firstName+" "+lastName)!=null)
        {
            System.out.println("This user exist :) ");
            return;
        }

        System.out.println(" \u001B[31mNice to meet you "+firstName+" " +lastName);
        User newUser= new User(firstName,lastName);
        Server.usersList.add(newUser);
        Server.saveUser(newUser);
        System.out.println("Click Enter to return to main menu");
        Main.cin.nextLine();

    }
    private static void addNoteUserMenu()
    {
        System.out.println(
                "\u001B[36mLet’s add a new note ...\n" +
                "Please enter your full name first:");
        String firstLastName=Main.cin.nextLine();
        //check Userexistance
        User exist=Server.checkUserExistance(firstLastName);
        if(exist==null)
        {
            System.out.println
                    (
                    "\u001B[31m\nOh! Sorry the user name was not found, please check the name again and if this is your first time here," +
                            " please go ahead and create a new user from the main menu ...\n" +
                    "Click Enter to return to main menu"
                    );
            return ;
        }
        System.out.println
                (
                "\u001B[36mYour record is found, I’m now opening your file ….\n" +
                "Ready!\n" +
                "Please enter your note:\u001B[32m"
                );
        String newNote=Main.cin.nextLine();
        if(newNote.trim().equals(""))
            {
                System.out.println("Are you kidding me ");
                return ;
            }
        System.out.println("################");
        //Add Node
        Note new_Note=new Note(exist.noteCount()+1,newNote);
        exist.addNote(new_Note);
        Server.updateUser(exist, new_Note);
        System.out.println
                (
                "\u001B[35mYour note has been well received, 1 second while saving it ….\n" +
                "Done!\n"
                );
        System.out.println("Click Enter to return to main menu");
        Main.cin.nextLine();
    }
}
