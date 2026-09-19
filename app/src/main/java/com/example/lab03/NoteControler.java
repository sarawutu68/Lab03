package com.example.lab03;

import android.util.Log;
import java.util.Date;
import java.util.concurrent.Executors;

public class NoteControler {
    //Attribute
    private  AadNoteActivity view ;
    public  NoteControler(AadNoteActivity view){
        this.view = view ;
    }

    public void saveNote(String strOftitle, String strOfcontent, String strOfdate){

        TextNote tNote = new TextNote();
        tNote.setTitle(strOftitle);
        tNote.setContent(strOfcontent);
        tNote.creatDate = new Date();

        tNote.setOwner(MainActivity.currentUser); 
        MainActivity.currentUser.addNote(tNote);

        //add data to db
        NoteEntity entity = NoteMapper.toEntity(tNote);
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                // 1. บันทึกข้อมูลลง Database
                AppDatabase.getInstance(view).noteDao().insert(entity);

                // 2. แสดง Log เมื่อบันทึกสำเร็จ
                Log.d("DatabaseAction", "Insert successful: Note saved to database.");

            } catch (Exception e) {
                // กรณีเกิด Error ระหว่างบันทึก
                Log.e("DatabaseAction", "Error inserting note: " + e.getMessage());
            }
        });
    }
}
