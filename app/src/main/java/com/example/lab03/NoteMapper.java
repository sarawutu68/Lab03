package com.example.lab03;

import com.google.gson.Gson;
import java.util.Date;

public class NoteMapper {

    static Gson gson = new Gson();

    // OOP -> Entity
    public static NoteEntity toEntity(AbstractNote note) {
        if (note instanceof TextNote) {
            return new NoteEntity(note.tiTle, "text", null, ((TextNote) note).getContent(), note.creatDate);
        }
        return null;
    }

    // Entity -> OOP
    public static AbstractNote fromEntity(NoteEntity entity) {
        if (entity.type.equals("text")) {
            TextNote note = new TextNote();
            note.setTitle(entity.title);
            note.setContent(entity.content);
            note.creatDate = entity.createdDate;
            return note;
        }
        return null;
    }
}
