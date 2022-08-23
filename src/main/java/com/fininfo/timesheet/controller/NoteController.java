package com.fininfo.timesheet.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fininfo.timesheet.service.NoteService;
import com.fininfo.timesheet.service.dto.NoteDTO;
import com.fininfo.timesheet.service.mapper.NoteMapper;

@RestController
@CrossOrigin(origins = "*")
public class NoteController {
   
    @Autowired
    NoteService noteService;

    @Autowired
    NoteMapper noteMapper;

    @GetMapping("/notes")
    @ResponseBody
    public List<NoteDTO> getALLNotes(){
      noteService.getAllNotes();
      
        return  noteMapper.toDto(noteService.getAllNotes())  ;
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
