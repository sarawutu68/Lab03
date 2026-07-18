package com.example.lab03;

public class User {
    //attributes
    private String userName;
    private String userId;
    private String passWord;
    private String eMail;
    //method
    public void logIn() {
        System.out.println("ชื่อผู้ใช้ " + userName);
        System.out.println("Login ");
    }
    public String getUserdata() {
        System.out.println(userName+"  "+userId +"  "+passWord+" "+eMail);
        return userName ;
    }
    void logOUt() {
        System.out.println("ชื่อผู้ใช้ " + userName);
        System.out.println("Logout ");
    }

}