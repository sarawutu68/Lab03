package com.example.lab03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;
import java.util.concurrent.Executors;

public class BrowseNoteActivity2 extends AppCompatActivity {

    Button buttonSearch, backMain;
    ProgressBar searchProgressBar;
    EditText Search;
    TextView showNote;
    ImageView logoImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_browse_note2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        backMain = findViewById(R.id.button8);
        searchProgressBar = findViewById(R.id.progressBar2);
        buttonSearch = findViewById(R.id.button7);
        Search = findViewById(R.id.editTextText3);
        showNote = findViewById(R.id.textViewNoteList);
        showNote.setMovementMethod(new android.text.method.ScrollingMovementMethod());

        logoImage = findViewById(R.id.imageView2);
        logoImage.setImageResource(R.drawable.images);

        searchProgressBar.setVisibility(View.GONE);

        backMain.setOnClickListener(v -> {
            Intent intent = new Intent(BrowseNoteActivity2.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        buttonSearch.setOnClickListener(v -> performSearch());
    }

    private void performSearch() {
        String query = Search.getText().toString();
        searchProgressBar.setVisibility(View.VISIBLE);
        showNote.setText("");

        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                // เพิ่มดีเลย์เล็กน้อยเพื่อให้เห็น ProgressBar (ถ้าต้องการ)
                Thread.sleep(1000);
                
                List<NoteEntity> results;
                if (query.isEmpty() || query.equals("ค้นหา")) {
                    results = AppDatabase.getInstance(this).noteDao().getAll();
                } else {
                    results = AppDatabase.getInstance(this).noteDao().searchNotes("%" + query + "%");
                }

                runOnUiThread(() -> {
                    searchProgressBar.setVisibility(View.GONE);
                    if (results.isEmpty()) {
                        showNote.setText("ไม่พบข้อมูล");
                        Toast.makeText(BrowseNoteActivity2.this, "ไม่พบข้อมูล", Toast.LENGTH_SHORT).show();
                    } else {
                        StringBuilder sb = new StringBuilder();
                        for (NoteEntity entity : results) {
                            AbstractNote note = NoteMapper.fromEntity(entity);
                            if (note != null) {
                                sb.append(note.getSummary()).append("\n----------------\n");
                            }
                        }
                        showNote.setText(sb.toString());
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
