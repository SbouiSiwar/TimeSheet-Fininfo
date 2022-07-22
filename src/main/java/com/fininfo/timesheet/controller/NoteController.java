package com.fininfo.timesheet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fininfo.timesheet.entities.Note;
import com.fininfo.timesheet.service.NoteService;
import com.fininfo.timesheet.service.dto.NoteDTO;

@RestController
public class NoteController {
   
    @Autowired
    NoteService noteService;

    @GetMapping("/notes")
    @ResponseBody
    public List<Note> getALLNotes(){
        List<Note> list= noteService.getAllNotes();
        return list;
     }

    @PostMapping("/saveNote")
    @ResponseBody
    public NoteDTO saveNote(@RequestBody NoteDTO noteDTO){
        return noteService.save(noteDTO);
    }
    @DeleteMapping("/deleteById/{id}")
    @ResponseBody
    public void  deleteNoteById ( @PathVariable("id") Long id){
        noteService.deleteById(id);
    }
}
