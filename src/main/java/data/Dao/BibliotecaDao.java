package data.Dao;

import model.Libro;
import org.jooq.*;
import org.jooq.impl.DSL;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;
public class BibliotecaDao {
	public static boolean agregarLibro(DSLContext query, Libro libro){
		int codigoLibro = libro.getCodigoLibro();
		String titulo = libro.getTitulo();
		String autor = libro.getAutor();
		String fechaPublicaion = libro.getFechaPublicacion();
		String genero = libro.getGenero();
		int stock = libro.getStock();
		Table<org.jooq.Record> tablaLibro = table(name("Libro"));
		Field[] columnas = tablaLibro.fields("id",
				"titulo",
				"autor",
				"fecha_publicacion",
				"genero",
				"stock");
		int results = 0;
		try{
			results = query.insertInto(tablaLibro, columnas[0], columnas[1], columnas[2], columnas[3], columnas[4], columnas[5])
				.values(codigoLibro, titulo, autor, fechaPublicaion, genero, stock).execute();
		}catch (Exception e){
			JOptionPane.showMessageDialog(null,"Error favor contactar al administradpr");
		}
		return results == 1;
	}
	public static ArrayList<Libro> buscarLibroAutor(DSLContext query, String autor, boolean estado){
		ArrayList<Libro>librosEncontrados=new ArrayList<>();
		Table<org.jooq.Record> libros=table(name("libros"));
		Result<org.jooq.Record> result=query.select().from(libros).where(
						DSL.field("autor").eq(DSL.inline(autor)))
				.and(DSL.field("stock").eq(estado))
				.fetch();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(autor);

			librosEncontrados.add(
					new Libro(
							Integer.parseInt((String) Objects.requireNonNull(result.getValue(i, "id"))),
							Objects.requireNonNull(result.getValue(i, "titulo")).toString(),
							Objects.requireNonNull(result.getValue(i, "autor")).toString(),
							Objects.requireNonNull(result.getValue(i, "fecha")).toString(),
							Objects.requireNonNull(result.getValue(i, "genero")).toString(),
							Integer.parseInt((String) Objects.requireNonNull(result.getValue(i, "stock"))))
					);
		}
		return librosEncontrados;
	}
	public ArrayList<Libro> obtenerLibros(DSLContext query,boolean estado){
		ArrayList<Libro>librosEncontrados=new ArrayList<>();
		Table<org.jooq.Record> libros=table(name("libros"));
		Result<org.jooq.Record> result=query.select().from(libros).where(DSL.field("stock").eq(estado)).fetch();
		for (int i = 0; i < result.size(); i++) {
			librosEncontrados.add(
					new Libro(
							Integer.parseInt((String) Objects.requireNonNull(result.getValue(i, "id"))),
							Objects.requireNonNull(result.getValue(i, "titulo")).toString(),
							Objects.requireNonNull(result.getValue(i, "autor")).toString(),
							Objects.requireNonNull(result.getValue(i, "fecha")).toString(),
							Objects.requireNonNull(result.getValue(i, "genero")).toString(),
							Integer.parseInt((String) Objects.requireNonNull(result.getValue(i, "stock"))))
			);
		}
		return librosEncontrados;
	}

	public boolean eliminarLibro(DSLContext query, Libro libro, boolean estado) {
		String titulo=libro.getTitulo();
		String autor=libro.getAutor();
		System.out.println(autor);
		String fecha=libro.getFechaPublicacion();
		Table<org.jooq.Record> libros=table(name("libros"));
		int result=query.deleteFrom(libros).where(
						(DSL.field("titulo").eq(titulo)))
				.and(DSL.field("autor").eq(autor)
						.and(DSL.field("fecha").eq(fecha))
						.and(DSL.field("stock").eq(estado)))
				.execute();
		return result==1;
	}

	public boolean prestarLibro(Libro libro,DSLContext query, boolean estado) {
		String titulo=libro.getTitulo();
		String autor=libro.getAutor();
		System.out.println(autor);
		String fecha=libro.getFechaPublicacion();
		Table<org.jooq.Record> libros=table(name("libros"));
		int result = query.update(libros)
				.set(DSL.field("stock"), false)
				.where(DSL.field("titulo").eq(titulo)
						.and(DSL.field("autor").eq(autor))
						.and(DSL.field("fecha").eq(fecha))
						.and(DSL.field("stock").eq(estado)))
				.execute();
		return result==1;
	}

	public boolean devolverLibro(Libro libro, DSLContext query, boolean estado) {
		String titulo=libro.getTitulo();
		String autor=libro.getAutor();
		System.out.println(autor);
		String fecha=libro.getFechaPublicacion();
		Table<org.jooq.Record> libros=table(name("libros"));
		int result = query.update(libros)
				.set(DSL.field("stock"), true)
				.where(DSL.field("titulo").eq(titulo)
						.and(DSL.field("autor").eq(autor))
						.and(DSL.field("fecha").eq(fecha))
						.and(DSL.field("stock").eq(!estado)))
				.execute();
		return result==1;
	}
	public static boolean validarExistenciaLibro(DSLContext query, String columnaTabla, int dato){
		Result<org.jooq.Record> resultados = query.select().from(DSL.table("Libros")).where(DSL.field(columnaTabla).eq(dato)).fetch();
		if(resultados.size()>=1){
			return true;
		}
		else{
			return false;
		}

	}
}