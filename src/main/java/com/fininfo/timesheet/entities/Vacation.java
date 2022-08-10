package com.fininfo.timesheet.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Vacation {
	

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idVacation;
	private Date startDate;
	private Date endDate;
	@Enumerated(EnumType.STRING)
    private Status status;
	private String type;
		
	

	
	public Vacation( Date startDate, Date endDate, Status status, String type) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.type = type;
	}
	public Vacation() {
		super();
	}




public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	

	public Long getIdVacation() {
		return idVacation;
	}



	public void setIdVacation(Long idVacation) {
		this.idVacation = idVacation;
	}
	@Override
	public String toString() {
		return "Vacation [idVacation=" + idVacation + ", startDate=" + startDate + ", endDate=" + endDate + ", status="
				+ status + ", type=" + type + "]";
	}
	
	
}