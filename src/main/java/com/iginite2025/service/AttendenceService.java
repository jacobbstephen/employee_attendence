package com.iginite2025.service;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import com.iginite2025.DAO.AttendenceDAO;
import com.iginite2025.entity.Attendance;

public class AttendenceService {
	private AttendenceDAO dao;
	public AttendenceService(Connection conn) {
		this.dao = new AttendenceDAO(conn);
	}
	
	public List<Attendance> findPresentByDate(LocalDate date) {
		return dao.findPresentByDate(date);
	}
	public List<Attendance> findAbsentByDate(LocalDate date) {
		return dao.findAbsentByDate(date);
	}
	public int countAbsentByDate(LocalDate date) {
		return dao.countAbsentByDate(date);
	}
}
