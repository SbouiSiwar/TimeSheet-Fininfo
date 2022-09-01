package com.fininfo.timesheet.service.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class NoteDTO {

    private Long id;
    private String title;
    private LocalDateTime  startDate;
    private LocalDateTime  endDate;
    private String description;
}
