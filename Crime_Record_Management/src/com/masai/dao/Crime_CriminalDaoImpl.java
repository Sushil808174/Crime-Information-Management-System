package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.dto.Crime_CriminalDto;
import com.masai.exception.SomethingWentWrongException;

public class Crime_CriminalDaoImpl implements Crime_CriminalDao{

	@Override
	public void assignCriminal(Crime_CriminalDto crime_criminal) throws SomethingWentWrongException {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			
			String query = "INSERT INTO CRIME_CRIMINAL (crime_id,criminal_id) VALUES (?,?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, crime_criminal.getCrimeId2());
			ps.setInt(2, crime_criminal.getCriminalId2());
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException |SQLException e) {
			throw new SomethingWentWrongException("Assigning criminal unsuccessful because "+e.getMessage());
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				throw new SomethingWentWrongException("Some went wrong");
			}
		}
		
	}

	@Override
	public void removeCriminal(int crimeId, int criminalId) throws SomethingWentWrongException {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			
			String query = "DELETE FROM CRIME_CRIMINAL WHERE crime_id=? AND criminal_id=?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, crimeId);
			ps.setInt(2, criminalId);
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException |SQLException e) {
			throw new SomethingWentWrongException("Not able to remove because "+e.getMessage());
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				throw new SomethingWentWrongException("Something went wrong");
			}
		}
		
	}

}
