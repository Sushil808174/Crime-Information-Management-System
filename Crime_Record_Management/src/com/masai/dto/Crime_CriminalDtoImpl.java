package com.masai.dto;

public class Crime_CriminalDtoImpl implements Crime_CriminalDto{
	private CrimeDto CrimeId;
	private CriminalDto CriminalId;
	private int crimeId2;
	private int criminalId2;
	public Crime_CriminalDtoImpl(CrimeDto crimeId, CriminalDto criminalId, int crimeId2, int criminalId2) {
		super();
		CrimeId = crimeId;
		CriminalId = criminalId;
		this.crimeId2 = crimeId2;
		this.criminalId2 = criminalId2;
	}
	@Override
	public CrimeDto getCrimeId() {
		return CrimeId;
	}
	@Override
	public void setCrimeId(CrimeDto crimeId) {
		CrimeId = crimeId;
	}
	@Override
	public CriminalDto getCriminalId() {
		return CriminalId;
	}
	@Override
	public void setCriminalId(CriminalDto criminalId) {
		CriminalId = criminalId;
	}
	@Override
	public int getCrimeId2() {
		return crimeId2;
	}
	@Override
	public void setCrimeId2(int crimeId2) {
		this.crimeId2 = crimeId2;
	}
	@Override
	public int getCriminalId2() {
		return criminalId2;
	}
	@Override
	public void setCriminalId2(int criminalId2) {
		this.criminalId2 = criminalId2;
	}
	@Override
	public String toString() {
		return "CrimeId=" + CrimeId + ", CriminalId=" + CriminalId + ", crimeId2=" + crimeId2
				+ ", criminalId2=" + criminalId2 + "\n";
	}
	
	
	
	
}
