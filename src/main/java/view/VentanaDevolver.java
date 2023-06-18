package view;

import controller.BibliotecaController;
import model.Libro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class VentanaDevolver extends JFrame{
	private JButton cancelarButton;
	private JButton devolverLibroButton;
	private JComboBox comboBox1;
	private JPanel panel;
	public VentanaDevolver(){
		setContentPane(panel);
		setVisible(true);
		setSize(900,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Devolver Libro");
		ActionListeners();
		iniciarComboBox();
	}
	public void ActionListeners(){
		devolverLibroButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String [] data= Objects.requireNonNull(comboBox1.getSelectedItem()).toString().split("/");
				BibliotecaController bibliotecaController=new BibliotecaController();
				boolean result= bibliotecaController.devolverLibro(
						new Libro(0,data[0],data[1],data[2],"",1),true);
				if(result) {
					JOptionPane.showMessageDialog(
							null,
							"Ya esta registrado que se ha devuelto el libro"
					);
				}else{
					JOptionPane.showMessageDialog(null,
							"Ha ocurrido un problema");
				}
			}
		});
		cancelarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BibliotecaController bibliotecaController = new BibliotecaController();
				new VentanaMenu();
				dispose();
			}
		});
	}
	public void iniciarComboBox(){
		ArrayList<Libro> librosEncontrados=new BibliotecaController().obtenerLibros(false);
		for(Libro libro:librosEncontrados){
			comboBox1.addItem(
					libro.getTitulo()+"/"+libro.getAutor()+"/"+libro.getFechaPublicacion());
		}
	}
}