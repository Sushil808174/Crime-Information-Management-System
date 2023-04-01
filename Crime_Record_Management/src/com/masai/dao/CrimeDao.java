package com.masai.dao;

import com.masai.dto.CrimeDto;
import com.masai.exception.SomethingWentWrongException;

public interface CrimeDao {
	public void addCrimedetails(CrimeDto crime) throws SomethingWentWrongException;
	public void updateCrimeDetails(CrimeDto crime) throws SomethingWentWrongException;
	public void deleteCrime(int crimeId) throws SomethingWentWrongException;
}
