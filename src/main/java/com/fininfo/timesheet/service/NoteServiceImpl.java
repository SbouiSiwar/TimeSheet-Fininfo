package com.fininfo.timesheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fininfo.timesheet.entities.Note;
import com.fininfo.timesheet.repos.NoteRepository;
import com.fininfo.timesheet.service.dto.NoteDTO;
import com.fininfo.timesheet.service.mapper.NoteMapper;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteRepository  noteRepository ;
    NoteMapper noteMapper;
    @Override
    public NoteDTO save(NoteDTO noteDTO) {
        Note note= noteMapper.toEntity(noteDTO);
         note= noteRepository.save(note);
         return noteMapper.toDto(note);
    }

    @Override
    public NoteDTO update(NoteDTO noteDTO) {
        Note note= noteMapper.toEntity(noteDTO);
        note= noteRepository.save(note);
        return noteMapper.toDto(note);
    }

    @Override
    public void deleteById(Long id) {
        noteRepository.deleteById(id);
        
    }

    @Override
    public Note getNote(Long id) {
        
        return noteRepository.findById(id).get();
    }

    @Override
    public List<Note> getAllNotes() {
        
        return noteRepository.findAll();
    }
    
}
