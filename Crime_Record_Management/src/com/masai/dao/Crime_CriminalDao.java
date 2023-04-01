package com.masai.dao;

import com.masai.dto.Crime_CriminalDto;
import com.masai.exception.SomethingWentWrongException;

public interface Crime_CriminalDao {
	public void assignCriminal(Crime_CriminalDto crime_criminal) throws SomethingWentWrongException;
	public void removeCriminal(int crimeId, int criminalId) throws SomethingWentWrongException;
}
