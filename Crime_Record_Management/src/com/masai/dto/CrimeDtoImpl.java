package com.masai.dto;

import java.time.LocalDate;

public class CrimeDtoImpl implements CrimeDto{
	private int crimeId;
	private String type;
	private String description;
	private String ps_area;
	private LocalDate date;
	private String victim_name;
	
	@Override
	public String toString() {
		return "Crimetype=" + type + ", Description=" + description + ", Ps_area=" + ps_area + ", Date=" + date
				+ ", Victim_name=" + victim_name + "\n";
	}
	
	public CrimeDtoImpl() {
		
	}
	
	public CrimeDtoImpl(String type, String description, String ps_area, LocalDate date, String victim_name) {
		this.type = type;
		this.description = description;
		this.ps_area = ps_area;
		this.date = date;
		this.victim_name = victim_name;
	}
	public CrimeDtoImpl(int crimeId,String type, String description, String ps_area, LocalDate date, String victim_name) {
		super();
		this.crimeId=crimeId;
		this.type = type;
		this.description = description;
		this.ps_area = ps_area;
		this.date = date;
		this.victim_name = victim_name;
	}
	
	
	@Override
	public int getCrimeId() {
		return crimeId;
	}
	@Override
	public void setCrimeId(int crimeId) {
		this.crimeId = crimeId;
	}
	
	@Override
	public String getType() {
		return type;
	}
	@Override
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String getDescription() {
		return description;
	}
	@Override
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String getPs_area() {
		return ps_area;
	}
	@Override
	public void setPs_area(String ps_area) {
		this.ps_area = ps_area;
	}
	@Override
	public LocalDate getDate() {
		return date;
	}
	@Override
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String getVictim_name() {
		return victim_name;
	}
	@Override
	public void setVictim_name(String victim_name) {
		this.victim_name = victim_name;
	}
	
	
}
