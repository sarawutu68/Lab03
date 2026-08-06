package com.example.lab03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;

public class AadNoteActivity extends AppCompatActivity {
    EditText title,content;
    Button baButton,send;
    TextView showNote;
    NoteControler controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_aad_note);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        baButton = findViewById(R.id.button3);
        baButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(back);
            }
        });
        title = findViewById(R.id.editTextText);
        content = findViewById(R.id.editTextText2);
        showNote = findViewById(R.id.button5);
        showNote = findViewById(R.id.textView4);

        controller = new NoteControler(this);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.get data from user (EditText)
                String strOfTitle = title.getText().toString();
                String strOfContent = content.getText().toString();
                String strOfDate = new Date().toString();

                //2.set data to textNote class
                controller.saveNote(strOfTitle,strOfDate,strOfContent);

                //TextNote tNote = new TextNote();
                //tNote.setTitle(strOfTitle);
                //tNote.setContent(strOfContent);
                //tNote.creatDate = strOfDate;

                //3.show note (by method of class)
                //showNote.setText(tNote.getSummary());

            }
        });
    }
    void displayTextNote(TextNote note){
        showNote.setText(note.getSummary());
    }
}