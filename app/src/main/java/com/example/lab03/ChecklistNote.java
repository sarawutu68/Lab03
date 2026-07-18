package com.example.lab03;

import java.util.List;

public class ChecklistNote extends AbstractNote {
    private List<String> checkList ;
    public List<String> getCheckList(){
        return checkList ;
    }
    public void setCheckList(List<String> newList){
        this.checkList = newList ;
    }
    //Method
    @Override
    public String getSummary() {
        return "สรุป: " + getTitle() + " ( ทั้งหมด " + checkList.size() + " รายการที่ต้องทำ )";
    }
}