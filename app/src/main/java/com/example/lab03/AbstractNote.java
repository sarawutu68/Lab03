package com.example.lab03;

public abstract class AbstractNote {
    //attributes
    public String tiTle;
    public String conTent;
    public String creatDate;
    //method
    public String getTitle(){
        return tiTle;
    }
    public void setTitle ( String newtiTle){
        this.tiTle = newtiTle ;
    }
    public abstract String getSummary();

}
