package com.fininfo.timesheet.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fininfo.timesheet.entities.Note;

@Repository
public interface NoteRepository extends JpaRepository <Note,Long> {
    
}
