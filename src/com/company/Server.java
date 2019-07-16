package com.company;

import java.util.ArrayList;

public final class Server {
    static ArrayList<User> usersList;
    static User checkUserExistance(String userFullName)
    {
        for (int i=0 ;i<usersList.size();i++)
        {
            if(usersList.get(i).getFirstLastName().equals(userFullName))
                return usersList.get(i);
        }
        return null;
    }

}
