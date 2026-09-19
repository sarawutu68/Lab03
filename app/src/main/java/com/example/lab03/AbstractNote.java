package com.example.lab03;

import java.util.Date;

public abstract class AbstractNote {
    //attributes
    public String tiTle;
    public String conTent;
    public Date creatDate;
    public User owner;

    public void setOwner(User owner) {
        this.owner = owner;
    }
    //method
    public String getTitle(){
        return tiTle;
    }
    public void setTitle ( String newtiTle){
        this.tiTle = newtiTle ;
    }
    public abstract String getSummary();

}
