package com.iginite2025.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.iginite2025.entity.Attendance;

public class AttendenceDAO {
	final static String ID = "ID";
	final static String NAME = "NAME";
	final static String DATE = "DATE";
	final static String STATUS = "STATUS";
	final static String REMARKS = "REMARKS";
	
	private Connection conn;

	public AttendenceDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public List<Attendance> findPresentByDate(LocalDate date) {
		String sql = "SELECT *  FROM Attendance WHERE DATE = ? AND STATUS = 'P'";
		List<Attendance> list = new ArrayList<Attendance>();
		try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
			preparedStatement.setDate(1, java.sql.Date.valueOf(date));
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Attendance a = new Attendance();
				a.setId(resultSet.getInt(ID));
				a.setName(resultSet.getString(NAME));
				a.setDate(resultSet.getDate(DATE).toLocalDate());
				a.setStatus(resultSet.getString(STATUS));
				a.setRemarks(resultSet.getString(REMARKS));
				list.add(a);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public List<Attendance> findAbsentByDate(LocalDate date) {
		String sql = "SELECT * FROM Attendance WHERE DATE = ? AND STATUS IS NULL";
		List<Attendance> list = new ArrayList<Attendance>();
		try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
			preparedStatement.setDate(1, java.sql.Date.valueOf(date));
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Attendance a = new Attendance();
				a.setId(resultSet.getInt(ID));
				a.setName(resultSet.getString(NAME));
				a.setDate(resultSet.getDate(DATE).toLocalDate());
				a.setStatus(resultSet.getString(STATUS));
				a.setRemarks(resultSet.getString(REMARKS));
				list.add(a);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return list;
		
	}
	
	public int countAbsentByDate(LocalDate date) {
		String sql = "SELECT COUNT(*) FROM Attendance WHERE DATE = ? AND STATUS IS NULL";
		int count = 0;
		try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
			preparedStatement.setDate(1, java.sql.Date.valueOf(date));
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) count = resultSet.getInt(1);
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return count;
		
	}
}
