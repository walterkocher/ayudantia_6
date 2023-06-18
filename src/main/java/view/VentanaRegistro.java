package view;
import controller.BibliotecaController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaRegistro extends Ventana {
    private JLabel textoEncabezado, textoCodigo,textoTitulo, textoAutor, textoFechaPublicacion, textoGenero, textoStock;
    private JTextField  campoCodigo, campoTitulo, campoAutor, campoFechaPublicacion, campoGenero, campoStock;
    private JButton botonRegistrar, botonCancelar;


    public VentanaRegistro(){
        super("Registro de libros", 500, 520);
        generarElementosVentana();
    }
    private void generarElementosVentana() {
        generarEncabezado();
        generarBotonCancelar();
        generarBotonRegistrar();
        generarCampoAutor();
        generarCampoFechaPublicacion();
        generarCampoGenero();
        generarCampoTitulo();
        generarCampoStock();
        generarCampoCodigo();
    }
    private void generarEncabezado() {
        String textoCabecera = "Registro de libros";
        super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 190, 10, 200, 50);

    }
    private void generarBotonRegistrar() {
        String textoBoton= "Registrar Libro";
        this.botonRegistrar = super.generarBoton(textoBoton, 75, 400, 150, 20);
        this.add(this.botonRegistrar);
        this.botonRegistrar.addActionListener(this);
    }
    private void generarBotonCancelar() {
        String textoBotonCancelar = "Cancelar";
        this.botonCancelar = super.generarBoton(textoBotonCancelar, 275, 400, 150, 20);
        this.add(this.botonCancelar);
        this.botonCancelar.addActionListener(this);
    }
    private void generarCampoCodigo(){
        String textoNombre= "Código de libro:";
        super.generarJLabel(this.textoCodigo,textoNombre,20,50,150,20);
        this.campoCodigo= super.generarJTextField(200,50,250,20);
        this.add(this.campoCodigo);
    }
    private void generarCampoTitulo(){
        String textoNombre= "Título:";
        super.generarJLabel(this.textoTitulo,textoNombre,20,100,150,20);
        this.campoTitulo= super.generarJTextField(200,100,250,20);
        this.add(this.campoTitulo);
    }
    private void generarCampoAutor(){
        String textoDireccion= "Autor:";
        super.generarJLabel(this.textoAutor,textoDireccion,20,150,150,20);
        this.campoAutor= super.generarJTextField(200,150,250,20);
        this.add(this.campoAutor);
    }
    private void generarCampoFechaPublicacion(){
        String textoCorreo= "Año de publicación:";
        super.generarJLabel(this.textoFechaPublicacion,textoCorreo,20,200,150,20);
        this.campoFechaPublicacion= super.generarJTextField(200,200,250,20);
        this.add(this.campoFechaPublicacion);
    }
    private void generarCampoGenero(){
        String textoNumero= "Género:";
        super.generarJLabel(this.textoGenero,textoNumero,20,250,150,20);
        this.campoGenero= super.generarJTextField(200,250,250,20);
        this.add(this.campoGenero);
    }
    private void generarCampoStock(){
        String textoNumero= "Cantidad de libros:";
        super.generarJLabel(this.textoStock,textoNumero,20,300,150,20);
        this.campoStock = super.generarJTextField(200,300,250,20);
        this.add(this.campoStock);
    }
    private boolean registrarLibro() throws ClassNotFoundException {
        if(this.campoTitulo.getText().length()== 0|| this.campoAutor.getText().length()==0 || this.campoFechaPublicacion.getText().length()==0 ||
                this.campoGenero.getText().length()==0 || this.campoStock.getText().length() == 0 || this.campoCodigo.getText().length()==0){
            return false;
        }
        else{
            return BibliotecaController.registrarLibro(Integer.parseInt(this.campoCodigo.getText()), this.campoTitulo.getText()
                    , this.campoAutor.getText(), this.campoFechaPublicacion.getText(), this.campoGenero.getText()
                    , Integer.parseInt(this.campoStock.getText()));
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonRegistrar) {
            try {
                if(registrarLibro()) {
                    JOptionPane.showMessageDialog(this,"Libro registrado correctamente");
                    VentanaMenu ventanaMenu = new VentanaMenu();
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(this,"Ingrese datos válidos");
                    VentanaRegistro ventanaRegistro = new VentanaRegistro();
                    this.dispose();
                }
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == this.botonCancelar){
            VentanaMenu ventanaMenu = new VentanaMenu();
            this.dispose();
        }
    }
}