package com.fininfo.timesheet.service.dto;

import java.util.Date;

import lombok.Data;

@Data
public class NoteDTO {

    private Long id;
    private String title;
    private Date startDate;
    private Date endDate;
    private String description;
}
