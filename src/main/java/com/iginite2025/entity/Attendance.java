package com.iginite2025.entity;

import java.time.LocalDate;

public class Attendance {
	private int id;
	private String name;
	private LocalDate date;
	private String status;
	private String remarks;
	public Attendance(int id, String name, LocalDate date, String status, String remarks) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.status = status;
		this.remarks = remarks;
	}
	public Attendance() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "Attendance [id=" + id + ", name=" + name + ", date=" + date + ", status=" + status + ", remarks="
				+ remarks + "]";
	}
	
}
