package com.masai.dto;

import java.time.LocalDate;

public interface CrimeDto {
	public String getType();
	public void setType(String type);
	public String getDescription();
	public void setDescription(String description);
	public String getPs_area();
	public void setPs_area(String ps_area);
	public LocalDate getDate();
	public void setDate(LocalDate date);
	public String getVictim_name();
	public void setVictim_name(String victim_name);
}
