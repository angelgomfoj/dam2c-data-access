package com.venancio.blanco.exercises2;

import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name1;
	private String name2;
	private String surname1;
	private String surname2;
	private int id;
	private int phoneNumber;
	private LocalDate dateOfBirth;
	private String birthCity;

	public Person(String name1, String name2, String surname1, String surname2, int id, int phoneNumber,
			LocalDate dateOfBirth, String birthCity) {
		super();
		this.name1 = name1;
		this.name2 = name2;
		this.surname1 = surname1;
		this.surname2 = surname2;
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.birthCity = birthCity;
	}

	public Person() {

	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getSurname1() {
		return surname1;
	}

	public void setSurname1(String surname1) {
		this.surname1 = surname1;
	}

	public String getSurname2() {
		return surname2;
	}

	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getBirthCity() {
		return birthCity;
	}

	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}

}
