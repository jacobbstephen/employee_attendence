package com.iginite2025.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.iginite2025.entity.Attendance;
import com.iginite2025.service.AttendenceService;
import com.iginite2025.util.AttendanceUtil;



public class Main {
	public static void main(String[] args) {
		try(Connection conn = AttendanceUtil.getConnection()){
			AttendenceService attendenceService = new AttendenceService(conn);
			LocalDate date = LocalDate.of(2025, 7, 10);
			System.out.println("<- TOTAL PRESENT ->");
			List<Attendance>  list = attendenceService.findPresentByDate(date);
			for(Attendance a: list) System.out.println(a);
			System.out.println("<- TOTAL ABSENT ->");
			list = attendenceService.findAbsentByDate(date);
			for(Attendance a: list) System.out.println(a);
			System.out.println("Count of Absentees: " +  attendenceService.countAbsentByDate(date));
			
			
		}catch( SQLException e) {
			e.printStackTrace();
		}
	}
}
