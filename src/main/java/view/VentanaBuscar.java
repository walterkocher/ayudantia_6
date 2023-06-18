package view;

import controller.BibliotecaController;
import model.Libro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class VentanaBuscar extends Ventana {
	private JButton botonBuscar, botonRegresar;
	private JLabel textoEncabezado, textoAutor;
	private JTextField campoAutor;

	public VentanaBuscar(){
		super("Búsqueda de Estudiante", 500, 520);
		generarElementosVentana();
	}
	private void generarElementosVentana() {
		generarCampoAutor();
		generarBotonBuscarLibro();
		generarBotonCancelar();
	}
	private void generarCampoAutor(){
		String textoAutor= "Autor:";
		super.generarJLabel(this.textoAutor,textoAutor,20,50,150,20);
		this.campoAutor= super.generarJTextField(200,50,250,20);
		this.add(this.campoAutor);
	}
	private void generarBotonBuscarLibro() {
		String textoBoton= "Buscar Libros";
		this.botonBuscar = super.generarBoton(textoBoton, 75, 400, 150, 20);
		this.add(this.botonBuscar);
		this.botonBuscar.addActionListener(this);
	}
	private void generarBotonCancelar() {
		String textoBotonRegresar = "Regresar";
		this.botonRegresar = super.generarBoton(textoBotonRegresar, 275, 400, 150, 20);
		this.add(this.botonRegresar);
		this.botonRegresar.addActionListener(this);
	}
	private ArrayList<Libro> exportarDatos() throws ClassNotFoundException {
		if(this.campoAutor.getText().length()==0){
			JOptionPane.showMessageDialog(this,"Ingrese datos validos");
			return null;
		}
		else{
			return BibliotecaController.buscarLibroAutor(this.campoAutor.getText(),true);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.botonBuscar){
			String[] nombreColumnas={"id",
					"titulo",
					"autor",
					"fecha_publicacion",
					"genero",
					"stock"};
			try {
				VentanaTabla ventanaTabla= new VentanaTabla(exportarDatos(),nombreColumnas);
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
		}
		if (e.getSource() == this.botonRegresar){
			VentanaMenu ventanaMenu = new VentanaMenu();
			this.dispose();
		}

	}
}