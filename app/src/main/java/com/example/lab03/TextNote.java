package com.example.lab03;

public class TextNote extends AbstractNote{
    private String conTent;
    public String getContent(){
        return conTent;
    }
    public void setContent(String newContent){
        this.conTent = newContent ;
    }

    @Override
    public String getSummary() {
        return "สรุปบันทึกข้อความ : "+getTitle() + "( เนื้อหา " + conTent.length() + " ตัวอังษร )";
    }
}