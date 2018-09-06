package com.example.demoJPA.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table (name="coche")
public class Coche {

	@Id
	@Column(name="Matricula")
	private String matricula;
	
	@Column(name="Fabricante",nullable=true)
	private String fabricante;
	
	@Column(name="Modelo",nullable=true)
	private String modelo;
	
	@ManyToOne
	@JoinColumn(name="Propietario_Id",nullable=true)
	private Persona persona;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getFabricante1() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Coche(String matricula, String fabricante, String modelo, Persona persona) {
		super();
		this.matricula = matricula;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", fabricante=" + fabricante + ", modelo=" + modelo + ", persona="
				+ persona + "]";
	}

	

	public Coche() {
		super();
	}
	

	
	
	
	
	

}
