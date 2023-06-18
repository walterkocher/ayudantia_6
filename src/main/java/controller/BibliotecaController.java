package controller;

import data.DBConnector;
import data.DBGenerator;
import data.Dao.BibliotecaDao;
import model.Biblioteca;
import model.Libro;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import view.VentanaLibros;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaController {
	private Biblioteca biblioteca= new Biblioteca("Biblioteca Libre", "Calle Uruguay","8 am - 20 pm");

	public static boolean registrarLibro(int codigoLibro, String titulo, String autor, String fechapublicacion, String genero, int stock) throws ClassNotFoundException {
		DSLContext query = DBGenerator.conectarBD("Biblioteca");
		if(!BibliotecaDao.validarExistenciaLibro(query,"id",codigoLibro)){
			Libro libro = new Libro(codigoLibro,titulo,autor,fechapublicacion,genero,stock);
			BibliotecaDao.agregarLibro(query,libro);
			DBConnector.closeConnection();
			return true;
		}
		else{
			DBConnector.closeConnection();
			return false;
		}
	}

	public static ArrayList<Libro> buscarLibroAutor(String autor, boolean estado){
		Connection connection= DBConnector.connection("Biblioteca","root","");
		DSLContext query= DSL.using(connection);
		return new BibliotecaDao().buscarLibroAutor(query,autor,estado);
	}

	public boolean eliminarLibro(Libro libro, boolean estado) {
		Connection connection= DBConnector.connection("Biblioteca","root","");
		DSLContext query= DSL.using(connection);
		return new BibliotecaDao().eliminarLibro(query,libro,estado);
	}
	public ArrayList<Libro> obtenerLibros(boolean estado) {
		Connection connection = DBConnector.connection("Biblioteca", "root", "");
		DSLContext query = DSL.using(connection);
		return new BibliotecaDao().obtenerLibros(query, estado);
	}

	public boolean prestarLibro(Libro libro,boolean estado) {
		Connection connection = DBConnector.connection("Biblioteca", "root", "");
		DSLContext query = DSL.using(connection);
		return new BibliotecaDao().prestarLibro(libro,query, estado);
	}

	public boolean devolverLibro(Libro libro, boolean estado) {
		Connection connection = DBConnector.connection("Biblioteca", "root", "");
		DSLContext query = DSL.using(connection);
		return new BibliotecaDao().devolverLibro(libro,query, estado);
	}

}