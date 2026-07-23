package com.example.lab03;

public class normalUser extends User{
    //Attributes
    private String proFile;
    //method
    //เปลี่ยนชื่อ
    public void setuserName(String newuserName){
        this.userName = proFile ;
    }
    public String setproFile(String newproFile){
        this.proFile = newproFile ;
        System.out.println(" " + proFile);
        return proFile ;
    }
    @Override
    public String getUserdata() {
        System.out.println(userName+"  "+userId +"  "+passWord+" "+eMail);
        return userName ;
    }
}
