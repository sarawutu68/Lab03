package com.example.lab03;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

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
    public static normalUser currentUser = new normalUser();
    Button mButton,aadButton,BrowseNoteButton;
    ImageView logoImage;
    ProgressBar  loadData;
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



        //event source
        mButton = findViewById(R.id.button);
        aadButton = findViewById(R.id.button4);
        BrowseNoteButton = findViewById(R.id.button6);
        loadData = findViewById(R.id.progressBar);
        //event listener
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //handler
                System.out.println("So Lazyyyyyyyyyyyyyyyyyyyyyy");
                Intent aboutMe = new Intent(getApplicationContext(),AboutMeActivity.class);
                startActivity(aboutMe);
            }
        });
        aadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("start your note");
                Intent AadNote = new Intent(getApplicationContext(), AadNoteActivity.class);
                startActivity(AadNote);
            }
        });
        loadData.setVisibility(View.GONE);
        BrowseNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show progress
                loadData.setVisibility(View.VISIBLE);
                //Creat Threat
                new Thread(()->{
                    //load data from DB (delay 4 seconds)
                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException e){
                    }

                    //return to main Thread
                    runOnUiThread(() -> {
                        loadData.setVisibility(View.GONE);//Progress bat is gone
                        System.out.println("Go to Browse");
                        Intent BrowseNote = new Intent(getApplicationContext(),BrowseNoteActivity2.class);
                        startActivity(BrowseNote);
                        finish();

                    });


                }).start();

            }
        });

        logoImage = findViewById(R.id.imageView);
        logoImage.setImageResource(R.drawable.logo);


    }

}