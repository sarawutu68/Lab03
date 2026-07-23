package com.example.lab03;

public class VIPUser extends User{
    //Attributes
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_RESET = "\u001B[0m";
    private String spacialFront;

    //method
    public String setSpacialFront(String newSpacialFront) {
        this.spacialFront = newSpacialFront;

        System.out.println(TEXT_RED + ("j") + this.spacialFront + TEXT_RESET);

        return spacialFront;
    }
    public String setuserName(String newuserName) {
        this.userName = newuserName;

        System.out.println(TEXT_RED + this.userName + TEXT_RESET);
        return userName ;
    }
    @Override
    public String getUserdata() {
        System.out.println(userName+"  "+userId +"  "+passWord+" "+eMail);
        return userName ;
    }
}
