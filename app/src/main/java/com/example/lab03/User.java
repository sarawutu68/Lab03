package com.example.lab03;

public class User {
    //attributes
    String userName;
    String userId;
    String passWord;
    String eMail;
    //method
    void logIn() {
        System.out.println("ชื่อผู้ใช้ " + userName);
        System.out.println("Login ");
    }
    void getUserdata() {
        System.out.println("ชื่อผู้ใช้ " + userName);
        System.out.println("ชื่อผู้ใช้ " + userId);
        System.out.println("รหัสผู้ใช้ " + passWord);
        System.out.println("อีเมลล์ผู้ใช้ " + eMail);
    }
    void logOUt() {
        System.out.println("ชื่อผู้ใช้ " + userName);
        System.out.println("Logout ");
    }
}