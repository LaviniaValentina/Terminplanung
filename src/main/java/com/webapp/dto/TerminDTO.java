package com.webapp.dto;

import java.util.ArrayList;
import java.util.Date;

import com.webapp.entities.Benutzer;

public class TerminDTO {

	private String titel;
	private Date start;
	private Date end;
	private ArrayList<Benutzer> benutzerList;

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public ArrayList<Benutzer> getBenutzerList() {
		return benutzerList;
	}

	public void setBenutzerList(ArrayList<Benutzer> benutzerList) {
		this.benutzerList = benutzerList;
	}

}
