package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.dto.CriminalDto;
import com.masai.exception.SomethingWentWrongException;

public class CriminalDaoImpl implements CriminalDao{

	@Override
	public void addCriminalDetails(CriminalDto criminal) throws SomethingWentWrongException {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "INSERT INTO CRIMINAL (name,dob,gender,identifying_mark,first_arrest_date,arrested_from_ps_area) VALUES (?,?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, criminal.getName());
			ps.setDate(2, Date.valueOf(criminal.getDob()));
			ps.setString(3, criminal.getGender());
			ps.setString(4, criminal.getIdentifying_mark());
			ps.setDate(5, Date.valueOf(criminal.getFirst_arrest_date()));
			ps.setString(6, criminal.getArrested_from_ps_area());
			
			ps.executeUpdate();
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("Date added not successfully because "+e.getMessage());
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				throw new SomethingWentWrongException("Something went wrong ");
			}
		}
		
	}

	@Override
	public void updateCriminalDetails(CriminalDto criminal) throws SomethingWentWrongException {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "UPDATE CRIMINAL SET name=?,dob=?,gender=?,identifying_mark=?,first_arrest_date=?,arrested_from_ps_area=? WHERE criminal_id=?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, criminal.getName());
			ps.setDate(2, Date.valueOf(criminal.getDob()));
			ps.setString(3, criminal.getGender());
			ps.setString(4, criminal.getIdentifying_mark());
			ps.setDate(5, Date.valueOf(criminal.getFirst_arrest_date()));
			ps.setString(6, criminal.getArrested_from_ps_area());
			ps.setInt(7, criminal.getCriminal_id());
			
			ps.executeUpdate();
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("Date updated not successfully because "+e.getMessage());
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				throw new SomethingWentWrongException("Some thing went wrong ");
			}
		}
		
	}

	@Override
	public void deleteCriminal(int criminalId) throws SomethingWentWrongException {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			
			String query = "DELETE FROM CRIMINAL WHERE CRIMINAL_ID=?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, criminalId);
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException |SQLException e) {
			throw new SomethingWentWrongException("Data deleted unsuccessfully because "+e.getMessage());
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				throw new SomethingWentWrongException("Some went wrong ");
			}
		}
		
	}

}
