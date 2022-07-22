package com.fininfo.timesheet.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fininfo.timesheet.entities.Note;

public interface NoteRepository extends JpaRepository <Note,Long> {
    
}
