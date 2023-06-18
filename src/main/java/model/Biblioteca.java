package model;

import data.DBConnector;
import data.Dao.BibliotecaDao;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.util.ArrayList;

public class Biblioteca {
	private String nombre;
	private String direccion;
	private String horario;
	public ArrayList<Libro> libros;

	public Biblioteca(String nombre, String direccion, String horario) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.horario = horario;
		this.libros = new ArrayList<>();
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

}