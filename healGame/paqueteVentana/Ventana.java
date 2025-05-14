package paqueteVentana;
import javax.swing.JFrame;
public class Ventana{
    public int ancho;
    public int alto;
    public JFrame ventana;
    public Ventana(int ancho, int alto){
        this.ancho = ancho;
        this.alto = alto;
        this.ventana = new JFrame("ventana");
        this.ventana.setLayout(null);
        this.ventana.setSize(this.ancho, this.alto);
        this.ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}