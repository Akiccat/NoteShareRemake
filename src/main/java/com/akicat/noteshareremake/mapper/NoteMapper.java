package com.akicat.noteshareremake.mapper;

import com.akicat.noteshareremake.model.Note;
import com.akicat.noteshareremake.model.NoteDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoteMapper {
    public List<Note> getNoteFormSubject(int id);
    public Note getNoteFormNoteId(int id);
    public int uploadNote(Note note);

    public NoteDetail noteDetailFromId(int noteId);

    public int delNoteFromNoteCode(String noteCode);
    public List<Note> getNoteFromNoteNameLike(String noteName);
}
