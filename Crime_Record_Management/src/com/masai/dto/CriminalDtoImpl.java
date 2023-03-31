package com.masai.dto;

import java.time.LocalDate;

public class CriminalDtoImpl implements CriminalDto{
	private int criminal_id;
	private String name;
	private LocalDate dob;
	private String gender;
	private String identifying_mark;
	private LocalDate first_arrest_date;
	private String arrested_from_ps_area;
	private CrimeDto crime;
	
	
	@Override
	public int getCriminal_id() {
		return criminal_id;
	}

	@Override
	public void setCriminal_id(int criminal_id) {
		this.criminal_id = criminal_id;
	}
	
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public LocalDate getDob() {
		return dob;
	}

	@Override
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String getGender() {
		return gender;
	}

	@Override
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String getIdentifying_mark() {
		return identifying_mark;
	}

	@Override
	public void setIdentifying_mark(String identifying_mark) {
		this.identifying_mark = identifying_mark;
	}

	@Override
	public LocalDate getFirst_arrest_date() {
		return first_arrest_date;
	}

	@Override
	public void setFirst_arrest_date(LocalDate first_arrest_date) {
		this.first_arrest_date = first_arrest_date;
	}

	@Override
	public String getArrested_from_ps_area() {
		return arrested_from_ps_area;
	}

	@Override
	public void setArrested_from_ps_area(String arrested_from_ps_area) {
		this.arrested_from_ps_area = arrested_from_ps_area;
	}

	@Override
	public CrimeDto getCrime() {
		return crime;
	}

	@Override
	public void setCrime(CrimeDto crime) {
		this.crime = crime;
	}
	
	public CriminalDtoImpl(String name, LocalDate dob, String gender, String identifying_mark,
			LocalDate first_arrest_date, String arrested_from_ps_area) {
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.identifying_mark = identifying_mark;
		this.first_arrest_date = first_arrest_date;
		this.arrested_from_ps_area = arrested_from_ps_area;
	}
	
	public CriminalDtoImpl(int criminal_id,String name, LocalDate dob, String gender, String identifying_mark,
			LocalDate first_arrest_date, String arrested_from_ps_area) {
		this.criminal_id=criminal_id;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.identifying_mark = identifying_mark;
		this.first_arrest_date = first_arrest_date;
		this.arrested_from_ps_area = arrested_from_ps_area;
	}

	public CriminalDtoImpl(String name, LocalDate dob, String gender, String identifying_mark,
			LocalDate first_arrest_date, String arrested_from_ps_area, CrimeDto crime) {
		super();
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.identifying_mark = identifying_mark;
		this.first_arrest_date = first_arrest_date;
		this.arrested_from_ps_area = arrested_from_ps_area;
		this.crime = crime;
	}


	@Override
	public String toString() {
		return "Criminal Name=" + name + ", DOB=" + dob + ", Gender=" + gender + ", Identifying_mark="
				+ identifying_mark + ", First_arrest_date=" + first_arrest_date + ", Arrested_from_ps_area="
				+ arrested_from_ps_area + "\n";
	}
	
	
}
