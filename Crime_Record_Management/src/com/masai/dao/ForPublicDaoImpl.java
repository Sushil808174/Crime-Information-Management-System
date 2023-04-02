package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.masai.dto.CrimeDto;
import com.masai.dto.CrimeDtoImpl;
import com.masai.dto.CriminalDto;
import com.masai.dto.CriminalDtoImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class ForPublicDaoImpl implements ForPublicDao{

	@Override
	public Map<String,Integer> crimeForEachPoliceStaForDateRange(LocalDate stDate,LocalDate enDate) throws SomethingWentWrongException, NoRecordFoundException {
		Map<String,Integer> map = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			
			String query = "SELECT c.ps_area, COUNT(r.crime_id) Total_crime FROM crime c LEFT JOIN crime_criminal r ON c.crime_id=r.crime_id WHERE date BETWEEN ? AND ? GROUP BY r.crime_id,c.ps_area";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setDate(1, Date.valueOf(stDate));
			ps.setDate(2, Date.valueOf(enDate));
			
			ResultSet rs= ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No Record found ");
			}
			map = new LinkedHashMap<>();
			while(rs.next()) {
				String str = rs.getString(1);
				int val = rs.getInt(2);
				if(map.containsKey(str)) {
					map.put(str, map.get(str)+val);
				}else {
					map.put(str, val);
				}
			}
			
		} catch (ClassNotFoundException |SQLException e) {
			throw new SomethingWentWrongException("Something went wrong because "+e.getMessage());
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return map;
	}

	@Override
	public Map<String,Integer> crimeForEachCrimeTypeForDateRange(LocalDate stDate,LocalDate enDate) throws SomethingWentWrongException, NoRecordFoundException {
		Map<String,Integer> map = null;
		
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();

			String query = "SELECT c.type, COUNT(r.crime_id) FROM crime c LEFT JOIN crime_criminal r ON c.crime_id=r.crime_id WHERE date BETWEEN ? AND ? GROUP BY r.crime_id,c.type";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setDate(1, Date.valueOf(stDate));
			ps.setDate(2, Date.valueOf(enDate));
			
			ResultSet rs= ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No Record found ");
			}
			map = new LinkedHashMap<>();
			while(rs.next()) {
				String str = rs.getString(1);
				int val = rs.getInt(2);
				if(map.containsKey(str)) {
					map.put(str, map.get(str)+val);
				}else {
					map.put(str, val);
				}
			}
			
		} catch (ClassNotFoundException |SQLException e) {
			throw new SomethingWentWrongException("Something went wrong because "+e.getMessage());
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return map;
	}

	

	@Override
	public List<CrimeDto> searchCrimeByDescription(String str) throws SomethingWentWrongException, NoRecordFoundException {
		List<CrimeDto> list = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			
			String query = "SELECT type,description,ps_area,date,victim_name FROM CRIME WHERE description LIKE ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, "%" + str + "%");
			
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No Record Found ");
			}
			
			list = new ArrayList<>();
			
			while(rs.next()) {
				CrimeDto crime = new CrimeDtoImpl();
				crime.setType(rs.getString(1));
				crime.setDescription(rs.getString(2));
				crime.setPs_area(rs.getString(3));
				crime.setDate(rs.getDate(4).toLocalDate());
				crime.setVictim_name(rs.getString(5));
				list.add(crime);
			}
			
		} catch (ClassNotFoundException |SQLException e) {
			throw new SomethingWentWrongException("Can not get data because "+e.getMessage());
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return list;
	}

	@Override
	public List<CriminalDto> searchCriminalByName(String name)
			throws SomethingWentWrongException, NoRecordFoundException {
		List<CriminalDto> list = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			
			String query = "SELECT name,dob,gender,identifying_mark,first_arrest_date, arrested_from_ps_area FROM CRIMINAL WHERE NAME LIKE ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, "%"+name+"%");
			
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No Record Found ");
			}
			
			list = new ArrayList<>();
			
			while(rs.next()) {
				CriminalDto criminal = new CriminalDtoImpl();
				criminal.setName(rs.getString(1));
				criminal.setDob(rs.getDate(2).toLocalDate());
				criminal.setGender(rs.getString(3));
				criminal.setIdentifying_mark(rs.getString(4));
				criminal.setFirst_arrest_date(rs.getDate(5).toLocalDate());
				criminal.setArrested_from_ps_area(rs.getString(6));
				list.add(criminal);
			}
			
		} catch (ClassNotFoundException |SQLException e) {
			throw new SomethingWentWrongException("Can not get data because "+e.getMessage());
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return list;
		
	}

}
