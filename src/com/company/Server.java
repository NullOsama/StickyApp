package com.company;

import java.util.ArrayList;

public class Server {
    static ArrayList<User> usersList;
    static User checkExistance(String userFullName)
    {
        for (int i=0 ;i<usersList.size();i++)
        {
            if(usersList.get(i).getFirstLastName()==userFullName)
                return usersList.get(i);
        }
        return null;
    }

}
