package com.venancio.blanco.exercises2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author juan
 */
class add2022_42Registro {

	public add2022_42Registro() {
	}

	public add2022_42Registro(int id, String nombre, int dni, double salario, boolean sexo, boolean lugarTrabajo) {
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.salario = salario;
		this.sexo = sexo;
		this.lugarTrabajo = lugarTrabajo;
	}

	private int id;
	private String nombre;
	private int dni;
	private double salario;
	private boolean sexo;
	private boolean lugarTrabajo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public boolean isLugarTrabajo() {
		return lugarTrabajo;
	}

	public void setLugarTrabajo(boolean lugarTrabajo) {
		this.lugarTrabajo = lugarTrabajo;
	}

}
