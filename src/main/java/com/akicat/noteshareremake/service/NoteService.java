package com.akicat.noteshareremake.service;

import com.akicat.noteshareremake.model.Note;
import com.akicat.noteshareremake.model.NoteDetail;

import java.util.List;


public interface NoteService {
    public List<Note> getNoteFormSubject(int id);
    public int uploadNote(Note note);
    public NoteDetail noteDetailFromId(int noteId);

    public int delNoteFromNoteCode(String noteCode);
    public Note getNoteFormNoteId(int id);
    public List<Note> getNoteFromNoteNameLike(String noteName);
}
