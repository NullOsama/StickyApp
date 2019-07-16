package com.company;

import java.io.*;
import java.util.ArrayList;

public final class Server {
    static ArrayList<User> usersList = new ArrayList<>();
    static User checkUserExistance(String userFullName)
    {
        for (int i=0 ;i<usersList.size();i++)
        {
            if(usersList.get(i).getFirstLastName().equals(userFullName))
                return usersList.get(i);
        }
        return null;
    }
    public static void saveUser(User user)
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

    public static void updateUser(User user, Note note) {
        String userName = user.getfName() + "_" + user.getlName();
        String userFilePath = "Resources" + "//" + userName + ".txt";

        try (FileWriter fw = new FileWriter(userFilePath, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(note.getNoteDate());
            out.println(note.getText());
            out.print("\n");
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
            e.printStackTrace();
        }
    }
}
