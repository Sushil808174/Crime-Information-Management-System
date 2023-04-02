package com.masai.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.masai.dto.CrimeDto;
import com.masai.dto.CriminalDto;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface ForPublicDao {
	public Map<String,Integer> crimeForEachPoliceStaForDateRange(LocalDate stDate,LocalDate enDate) throws SomethingWentWrongException, NoRecordFoundException;
	public Map<String,Integer> crimeForEachCrimeTypeForDateRange(LocalDate stDate,LocalDate enDate) throws SomethingWentWrongException,NoRecordFoundException;
	public List<CriminalDto> searchCriminalByName(String name) throws SomethingWentWrongException,NoRecordFoundException;
	public List<CrimeDto> searchCrimeByDescription(String str) throws SomethingWentWrongException,NoRecordFoundException;
}
