package ua.kiev.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {

    private String login;
    private String pass;
    private boolean statusLogin=false;
    private boolean isOnline;
    private Set<User> usersList=new HashSet<>();

    public User() {
    }

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public boolean getStatusLogin() {
        return statusLogin;
    }

    public Set<User> getUsersList() {
        return usersList;
    }

    public boolean isOnline() {
        return isOnline;
    }


    public String toJSON(){
        Gson gson=new GsonBuilder().create();
        return  gson.toJson(this);
    }
    public static User fromJSON(String s){
        Gson gson=new GsonBuilder().create();
        return gson.fromJson(s,User.class);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) &&
                Objects.equals(pass, user.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, pass);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", isOnline=" + isOnline +
                '}';
    }
}
