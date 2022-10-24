package peval1acda2223;

import java.io.Serializable;

public class Investor implements Serializable{

	int codigo;
	char company;
	String name;
	String surname;
	String calidad;
	String sort;

	public Investor(int codigo, char company, String name, String surname, String calidad, String sort) {
		this.codigo = codigo;
		this.company = company;
		this.name = name;
		this.surname = surname;
		this.calidad = calidad;
		this.sort = sort;
	}

	public Investor() {
		this.codigo = codigo;
		this.company = company;
		this.name = name;
		this.surname = surname;
		this.calidad = calidad;
		this.sort = null;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public char getCompany() {
		return company;
	}

	public void setCompany(char company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCalidad() {
		return calidad;
	}

	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

}
