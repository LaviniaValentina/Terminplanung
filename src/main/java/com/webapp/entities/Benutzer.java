package com.webapp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Benutzer", uniqueConstraints = {@UniqueConstraint(columnNames ="email")})
public class Benutzer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5251757686705679224L;

	@Id
	@GeneratedValue
	@Column(name = "benutzer_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "email", nullable = false)
	private String email;


	public Benutzer() {
	};

	public Benutzer(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}
	
	

}
