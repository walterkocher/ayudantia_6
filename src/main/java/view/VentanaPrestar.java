package view;
import controller.BibliotecaController;
import model.Libro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class VentanaPrestar extends JFrame{
	private JButton cancelarButton;
	private JComboBox comboBox1;
	private JButton prestarLibroButton;
	private JPanel panel;

	public VentanaPrestar(){
		setContentPane(panel);
		setVisible(true);
		setSize(900,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Prestar Libro");
		ActionListeners();
		iniciarComboBox();
	}
	public void ActionListeners(){
		prestarLibroButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String [] data= Objects.requireNonNull(comboBox1.getSelectedItem()).toString().split("/");
				BibliotecaController bibliotecaController=new BibliotecaController();
				boolean result= bibliotecaController.prestarLibro(
						new Libro(0,data[0],data[1],data[2],"",1),true);
				if(result){
					JOptionPane.showMessageDialog(
							null,
							"Ya esta registrado que se presto el libro"
					);
				}
			}
		});
		cancelarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaMenu();
				dispose();
			}
		});
	}
	public void iniciarComboBox(){
		ArrayList<Libro> librosEncontrados=new BibliotecaController().obtenerLibros(true);
		for(Libro libro:librosEncontrados){
			comboBox1.addItem(
					libro.getTitulo()+"/"+libro.getAutor()+"/"+libro.getFechaPublicacion());
		}
	}
}