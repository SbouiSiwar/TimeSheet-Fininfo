package com.fininfo.timesheet.Dto;




import java.sql.Date;

import lombok.Data;
@Data
public class ProjetDto {
	private Long id;
	private String titre,descreption;
	private Date dateDebut,dateFin;
}
