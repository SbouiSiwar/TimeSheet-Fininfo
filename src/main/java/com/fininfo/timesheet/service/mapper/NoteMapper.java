package com.fininfo.timesheet.service.mapper;



 import org.mapstruct.Mapper;


import com.fininfo.timesheet.entities.Note;
import com.fininfo.timesheet.service.dto.NoteDTO;


@Mapper(componentModel = "spring", uses = {})
public interface NoteMapper extends EntityMapper<NoteDTO, Note>{
 
    

}
