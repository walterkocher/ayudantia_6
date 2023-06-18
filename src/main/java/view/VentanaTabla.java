package view;

import model.Libro;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class VentanaTabla extends JFrame {
    private ArrayList<Libro> datos;
    private String[] nombreColumnas;


    public VentanaTabla(ArrayList<Libro> datos, String[] nombreColumnas) {
        super("Lista de datos");
        this.datos = datos;
        this.nombreColumnas = nombreColumnas;
        generarTabla(datos,nombreColumnas);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        this.pack();
        this.setVisible(true);

    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public void generarTabla(ArrayList<Libro> libros, String[] nombreColumnas) {
        Object[][] datos = new Object[libros.size()][4];
        for (int i = 0; i <libros.size(); i++) {
            Libro libro=libros.get(i);
            datos[i][0]=libro.getAutor();
            datos[i][1]=libro.getTitulo();
            datos[i][2]=libro.getFechaPublicacion();
            datos[i][3]=libro.getGenero();
        }
        DefaultTableModel dtm = new DefaultTableModel(datos, nombreColumnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        final JTable tabla = new JTable(dtm);

        tabla.setPreferredScrollableViewportSize(new Dimension(500, 200));
        JScrollPane scrollPane = new JScrollPane(tabla);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
            }
        });
    }

    private void cerrarVentana() {
        this.dispose();
    }
}


