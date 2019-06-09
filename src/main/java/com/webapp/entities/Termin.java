package com.webapp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Termin")
public class Termin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2397187420829638580L;

	@Id
	@Column(name = "termin_id", unique = true, nullable = false)
	@GeneratedValue
	private Integer id;

	@Column(name = "titel")
	private String titel;

	@Column(name = "start")
	private Date start;

	@Column(name = "end")
	private Date end;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "benutzer_id")
	@Column(name = "benutzer")
	private List<Benutzer> benutzerList;

	public Termin() {
		this.benutzerList = new ArrayList<>();
	};

	public Termin(String titel, Date start, Date end, List<Benutzer> benutzerList) {

		this.titel = titel;
		this.start = start;
		this.end = end;
		this.benutzerList = benutzerList;
	}
	
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

	public List<Benutzer> getBenutzerList() {
		return benutzerList;
	}

	public void setBenutzerList(ArrayList<Benutzer> benutzerList) {
		this.benutzerList = benutzerList;
	}

	public Integer getId() {
		return id;
	}


}
