package com.fininfo.timesheet.service;

import java.util.List;

import com.fininfo.timesheet.entities.Note;
import com.fininfo.timesheet.service.dto.NoteDTO;

public interface NoteService {
    
    NoteDTO save(NoteDTO noteDTO);
    NoteDTO update(NoteDTO noteDTO);
    void deleteById(Long id);
    Note getNote(Long id);
    List<Note> getAllNotes();
}
