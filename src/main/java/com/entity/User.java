package com.entity;

public class User {
    private int uid;
    private String uname;
    private String password;
    private String ugender;

    public User(){}

    public User(int uid, String uname, String password, String ugender) {
        this.uid = uid;
        this.uname = uname;
        this.password = password;
        this.ugender = ugender;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUgender() {
        return ugender;
    }

    public void setUgender(String ugender) {
        this.ugender = ugender;
    }

    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", ugender='" + ugender + '\'' +
                '}';
    }
}
