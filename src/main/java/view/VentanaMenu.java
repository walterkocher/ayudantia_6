package view;

import controller.BibliotecaController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaMenu extends Ventana {

    private JLabel textoMenu;
    private JButton botonRegistrarLibro;
    private JButton botonSalida;
    private JButton botonDevolverLibro;
    private JButton botonBuscarLibro;
    private JButton botonPrestarLibro;

    public VentanaMenu() {
        super("Menu Biblioteca", 500, 520);
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarMensajeMenu();
        generarBotonRegistrarLibro();
        generarBotonPrestarLibro();
        generarBotonBuscarLibro();
        generarBotonDevolverLibro();
        generarBotonSalir();
    }

    private void generarMensajeMenu() {
        String textoBienvenida = "Sistema de gestión biblioteca";
        super.generarJLabelEncabezado(this.textoMenu, textoBienvenida, 20, 10, 500, 30);
    }

    private void generarBotonRegistrarLibro() {
        String textoBoton = "Registrar Libro";
        this.botonRegistrarLibro = super.generarBoton(textoBoton, 150, 100, 200, 50);
        this.add(this.botonRegistrarLibro);
        this.botonRegistrarLibro.addActionListener(this);
    }

    private void generarBotonBuscarLibro() {
        String textoBoton = "Buscar Libro";
        this.botonBuscarLibro = super.generarBoton(textoBoton, 150, 180, 200, 50);
        this.add(this.botonBuscarLibro);
        this.botonBuscarLibro.addActionListener(this);
    }
    private void generarBotonPrestarLibro(){
        String textoBoton = "Prestar Libro";
        this.botonPrestarLibro=super.generarBoton(textoBoton, 150, 260, 200, 50);
        this.add(this.botonPrestarLibro);
        this.botonPrestarLibro.addActionListener(this);
    }
    private void generarBotonDevolverLibro(){
        String textoBoton = "Devolver Libro";
        this.botonDevolverLibro=super.generarBoton(textoBoton, 150, 340, 200, 50);
        this.add(this.botonDevolverLibro);
        this.botonDevolverLibro.addActionListener(this);
    }
    private void generarBotonSalir() {
        String textoBoton = "Salir";
        this.botonSalida = super.generarBoton(textoBoton, 175, 420, 150, 40);
        this.add(this.botonSalida);
        this.botonSalida.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonRegistrarLibro) {
            VentanaRegistro ventanaRegistrar= new VentanaRegistro();
            //Cierra la ventana actual
            this.dispose();
        }
        if(e.getSource() == this.botonBuscarLibro){
            VentanaBuscar ventanaBuscar= new VentanaBuscar();
            this.dispose();
        }
        if(e.getSource() == this.botonPrestarLibro){
            VentanaPrestar ventanaPrestar= new VentanaPrestar();
            this.dispose();
        }
        if(e.getSource() == this.botonDevolverLibro){
            VentanaDevolver ventanaDevolver = new VentanaDevolver();
            this.dispose();
        }
        if (e.getSource() == this.botonSalida){
            this.dispose();
            System.exit(0);
        }
    }
}
