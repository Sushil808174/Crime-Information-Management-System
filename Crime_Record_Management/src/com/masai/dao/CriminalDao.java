package com.masai.dao;



import com.masai.dto.CriminalDto;
import com.masai.exception.SomethingWentWrongException;

public interface CriminalDao {
	public void addCriminalDetails(CriminalDto criminal) throws SomethingWentWrongException;
	public void updateCriminalDetails(CriminalDto criminal) throws SomethingWentWrongException;
	public void deleteCriminal(int criminal_id) throws SomethingWentWrongException;
}
