package model;

public class Libro {
	private int codigoLibro;
	private String titulo;
	private String autor;
	private String fechaPublicacion;
	private String genero;
	private int stock;

	public Libro(int codigoLibro, String titulo, String autor, String fechaPublicacion, String genero, int stock) {
		this.codigoLibro = codigoLibro;
		this.titulo = titulo;
		this.autor = autor;
		this.fechaPublicacion = fechaPublicacion;
		this.genero = genero;
		this.stock = stock;
	}

	public int getCodigoLibro() {
		return codigoLibro;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getFechaPublicacion() {
		return this.fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Libro{" +
				"titulo='" + titulo + '\'' +
				", autor='" + autor + '\'' +
				", fechaPublicacion='" + fechaPublicacion + '\'' +
				", genero='" + genero + '\'' +
				", stock=" + stock +
				'}';
	}
}