package com.example.lab03;

import android.os.Bundle;
import android.util.Log;
import java.util.List;
import java.util.ArrayList;

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
        //textnote
        TextNote myText = new TextNote();

        myText.setTitle("เซี่ยเป้ เซี่ยกำมะลอ");
        myText.setContent("รวยจัด แต่บอกพอมีพอกิน");

        //checkList
        ChecklistNote myTask = new ChecklistNote();
        myTask.setTitle("รวย เงินหนาทุนหนา");

        List<String> richHuman = new ArrayList<>();
        richHuman.add("รวย");
        richHuman.add("บอกว่าตัวเองไม่รวย");
        richHuman.add("โกหกหน้าตาย");
        myTask.setCheckList(richHuman);

        //logcat
        Log.d("OOP_TEST", "   ผลลัพธ์ของ TextNote   ");
        Log.d("OOP_TEST","ชื่อหัวข้อ : " + myText.getTitle());
        Log.d("OOP_TEST" , myText.getSummary());

        Log.d("OOP_TEST", "   ผลลัพธ์ของ CheckสistNote   ");
        Log.d("OOP_TEST","ชื่อหัวข้อ : " + myTask.getTitle());
        Log.d("OOP_TEST" , myTask.getSummary());

    }

}