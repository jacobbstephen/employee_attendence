package com.iginite2025.service;

import java.time.LocalDate;
import java.util.List;

import com.iginite2025.entity.Attendance;

public interface AttendenceServiceInterface {
	List<Attendance> findPresentByDate(LocalDate date);
	List<Attendance> findAbsentByDate(LocalDate date);
	int countAbsentByDate(LocalDate date);
}
