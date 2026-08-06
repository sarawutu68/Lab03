package com.example.lab03;

public class NoteControler {
    //Attribute
    private AadNoteActivity view;

    //Contructor
    public NoteControler(AadNoteActivity view){
        this.view = view;
    }
    //Method
    public void saveNote(String strOfTitle,String strOfContent,String strOfDate){
        //set data to TextNote Class
        TextNote tNote = new TextNote();
        tNote.setTitle(strOfTitle);
        tNote.setContent(strOfContent);
        tNote.creatDate = strOfDate;
        //Show note to view
        view.displayTextNote(tNote);
    }

}
