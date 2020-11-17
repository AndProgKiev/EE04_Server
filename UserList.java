package ua.kiev.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashSet;
import java.util.Set;

public class UserList {
    private  static final UserList ulist=new UserList();
    private final Gson gson;

    private final Set<User> userSet=new HashSet<>();

    private UserList(){
        gson=new GsonBuilder().create();
    }

    public static UserList getInstance(){
        return ulist;
    }


    public synchronized void addUser(User user){
        userSet.add(user);
    }

    public synchronized String toJSON(){
        return gson.toJson(userSet);
}

    public synchronized boolean contains(User user){
        boolean b=false;
        if(userSet.contains(user)){
            b=true;
        }
        return b;
    }
}
