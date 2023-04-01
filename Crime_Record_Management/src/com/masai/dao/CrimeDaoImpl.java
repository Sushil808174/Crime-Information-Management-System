package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.dto.CrimeDto;
import com.masai.exception.SomethingWentWrongException;

public class CrimeDaoImpl implements CrimeDao{

	@Override
	public void addCrimedetails(CrimeDto crime) throws SomethingWentWrongException {
		Connection conn =  null;
		
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "INSERT INTO CRIME (type,description,ps_area,date,victim_name) VALUES (?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, crime.getType());
			ps.setString(2, crime.getDescription());
			ps.setString(3, crime.getPs_area());
			ps.setDate(4, Date.valueOf(crime.getDate()));
			ps.setString(5, crime.getVictim_name());
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException |SQLException e) {
			throw new SomethingWentWrongException("Data added unsuccessfully because "+e.getMessage());
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				throw new SomethingWentWrongException("Something went wrong ");
			}
		}
	}

	@Override
	public void updateCrimeDetails(CrimeDto crime) throws SomethingWentWrongException {
		Connection conn =  null;
		
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "UPDATE CRIME SET type=?,description=?,ps_area=?,date=?,victim_name=? WHERE CRIME_ID=?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, crime.getType());
			ps.setString(2, crime.getDescription());
			ps.setString(3, crime.getPs_area());
			ps.setDate(4, Date.valueOf(crime.getDate()));
			ps.setString(5, crime.getVictim_name());
			ps.setInt(6, crime.getCrimeId());
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException |SQLException e) {
			throw new SomethingWentWrongException("Data Updated unsuccessfully because "+e.getMessage());
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				throw new SomethingWentWrongException("Something went wrong ");
			}
		}
	}

	@Override
	public void deleteCrime(int crimeId) throws SomethingWentWrongException {
		Connection conn =  null;
		
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "DELETE FROM CRIME WHERE CRIME_ID=?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, crimeId);
			
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException |SQLException e) {
			throw new SomethingWentWrongException("Data Updated unsuccessfully because "+e.getMessage());
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				throw new SomethingWentWrongException("Something went wrong ");
			}
		}
	}

}
