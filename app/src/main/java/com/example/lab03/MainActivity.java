package com.example.lab03;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Note note1 = new Note();
        Note note2 = new Note();

        note1.tiTle = "Do LAB3";
        note1.conTent = "ออกแบบไดอาแกรม,สร้าง class และ object";
        note1.creatDate = "3 july 2026";
        note1.getSummary();

        note2.tiTle = "เขียนอะไรดี";
        note2.creatDate = "4 july 2026";
        note2.getSummary();

        User user1 = new User();

        user1.userName = "Dodo";
        user1.userId = "4422";
        user1.eMail = "fu@gmail.com";
        user1.passWord = "225544";
        user1.getUserdata();
        user1.logOUt();
    }
}