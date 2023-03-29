package com.masai.dto;

import java.time.LocalDate;

public interface CriminalDto {
	public String getName();
	public void setName(String name);
	public LocalDate getDob();
	public void setDob(LocalDate dob);
	public String getGender();
	public void setGender(String gender);
	public String getIdentifying_mark();
	public void setIdentifying_mark(String identifying_mark);
	public LocalDate getFirst_arrest_date();
	public void setFirst_arrest_date(LocalDate first_arrest_date);
	public String getArrested_from_ps_area();
	public void setArrested_from_ps_area(String arrested_from_ps_area);
}
