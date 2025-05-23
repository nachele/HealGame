package paqueteEntity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
//clase para pintar imagenes con una x e y.
public class Entity extends JPanel {
    // Propiedades.
    public String path;
    public int x;
    public int y;
    public int ancho;
    public int alto;
    public int speed;
    public BufferedImage imagen;

    // Constructor.
    public Entity(String path, int x, int y, int ancho, int alto, int speed) {
        //inicializando propiedades.
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.speed = speed;
        this.path = path;


        // cargando la imagen
        try {
            this.imagen = ImageIO.read(new File(this.path));
            if (this.imagen == null) {
                System.out.println("Imagen no cargada");
            }
        } catch (IOException e) {
            System.out.println("Error al cargar la imagen.");
            e.printStackTrace();
        }
    }

    // Método de dibujo
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.imagen != null) {
             // Esto nos confirma que paintComponent se llama
            //donde quiero que se pinte la imagen y tamaño del panel el tamaño e la imagen y posicion en ventana esta en setBounds
            g.drawImage(this.imagen,0, 0, this.ancho, this.alto, null);
        } else {
            System.out.println("Imagen es null");
        }
    }


    //pintando la imagen en la pantalla.
    public void pintar(){
         this.setBounds(this.x, this.y, this.ancho, this.alto);
    }
}
