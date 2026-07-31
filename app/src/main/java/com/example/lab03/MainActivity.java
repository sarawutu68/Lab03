package com.example.lab03;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;
import java.util.ArrayList;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button mButton,addButton;
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
        /*
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

        //เรียกใช้ classUser
        Log.d("OOP_TEST","UserUnggor");
        User EcoUser = new User();  //new ClassUser

        EcoUser.setName("Mafeppy");   //use method of User
        Log.d("OOP_TEST",EcoUser.getUserdata());

        EcoUser.logIn();
        Log.d("OOP_TEST",EcoUser.getUserdata());
        EcoUser.logOUt();

        Log.d("OOP_TEST", "normalUserEGO");//new ClassnormalUser
        normalUser Newbei = new normalUser() ;
        Newbei.setuserName("ราชาปีโป้อีโก้นูปๆ");//use method of normalUser
        Log.d("OOP_TEST",Newbei.getUserdata());
        Newbei.setproFile("ผู้เล่นโกรทไมน์เซ็ต");

        Log.d("OOP_TEST",Newbei.setproFile(""));//new ClassVIPUser
        VIPUser King = new VIPUser() ;
        King.logIn();
        Log.d("OOP_TEST",King.getUserdata());
        King.setSpacialFront("Woooooooooooo");
        Log.d("OOP_TEST",King.setSpacialFront(""));
        King.setuserName("HEHEEBOY");
        Log.d("OOP_TEST",King.setuserName(""));
        Log.d("OOP_TEST",King.getUserdata());
        King.logOUt();*/

        //event source
        mButton = findViewById(R.id.button);
        addButton = findViewById(R.id.button4);
        //event listener
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //handler
                System.out.println("clickkkkk");
                Intent aboutMe = new Intent(getApplicationContext(),AboutMeActivity.class);
                startActivity(aboutMe);
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("start your note");
                Intent AadNote = new Intent(getApplicationContext(), AddNoteActivity.class);
                startActivity(AadNote);
            }
        });


    }

}