 package paqueteVentana;
 import paqueteControles.*;
import javax.swing.JFrame;
public class Ventana{
    public int ancho;
    public int alto;
    public JFrame ventana;
    public Ventana(int ancho, int alto,Controles control){
        this.ancho = ancho;
        this.alto = alto;
        this.ventana = new JFrame("ventana");
        this.ventana.setLayout(null);
        this.ventana.setSize(this.ancho, this.alto);
        this.ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.ventana.addKeyListener(control);
    }
    public void agregarEntidad(Entity entidad){
        this.ventana.add(entidad);
        this.ventana.repaint();
    }
}