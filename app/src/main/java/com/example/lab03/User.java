package com.example.lab03;

public class User {
    //attributes
    public String userName;
    public String userId;
    public String passWord;
    public String eMail;
    public java.util.List<AbstractNote> notes = new java.util.ArrayList<>();

    public void addNote(AbstractNote note) {
        notes.add(note);
    }
    //method
    public void logIn() {
        System.out.println("ชื่อผู้ใช้ " + userName);
        System.out.println("Login ");
    }
    public  void setName (String newName){    //เปลี่ยนชื่อ
        this.userName = newName ;
    }
    public String getUserdata() {
        System.out.println(userName+"  "+userId +"  "+passWord+" "+eMail);
        return userName ;
    }
    public void logOUt() {
        System.out.println("ชื่อผู้ใช้ " + userName);
        System.out.println("Logout ");
    }

}