package com.fininfo.timesheet.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
public class Note {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDateTime  startDate;
    private LocalDateTime  endDate;
    private String description;
}
