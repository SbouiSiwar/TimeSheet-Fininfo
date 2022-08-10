package com.fininfo.timesheet.dto;

	import java.util.Date;

	import lombok.Data;

	@Data
	public class VacationDto  {
		
		private Long idVacation;
		private Date startDate;
		private Date endDate;
		private Boolean status;
		private String type;

	}
