package com.akicat.noteshareremake.service.impl;

import com.akicat.noteshareremake.mapper.NoteMapper;
import com.akicat.noteshareremake.model.Note;
import com.akicat.noteshareremake.model.NoteDetail;
import com.akicat.noteshareremake.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    NoteMapper noteService;

    @Override
    public List<Note> getNoteFormSubject(int id) {
        return noteService.getNoteFormSubject(id);
    }

    @Override
    public int uploadNote(Note note) {
        return noteService.uploadNote(note);
    }

    @Override
    public NoteDetail noteDetailFromId(int noteId) {
        return noteService.noteDetailFromId(noteId);
    }

    @Override
    public int delNoteFromNoteCode(String noteCode) {
        return noteService.delNoteFromNoteCode(noteCode);
    }

    @Override
    public Note getNoteFormNoteId(int id) {
        return noteService.getNoteFormNoteId(id);
    }

    @Override
    public List<Note> getNoteFromNoteNameLike(String noteName) {
        return noteService.getNoteFromNoteNameLike(noteName);
    }
}
