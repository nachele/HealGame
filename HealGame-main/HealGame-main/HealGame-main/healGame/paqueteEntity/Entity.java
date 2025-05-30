package paqueteEntity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Entity {
    public String name = " ";
    public String path;
    public int x;
    public int y;
    public int ancho;
    public int alto;
    public int speed;
    public BufferedImage imagen;



    public Entity(String path, int x, int y, int ancho, int alto, int speed) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.speed = speed;
        this.path = path;

        try {
            File imageFile = new File(this.path);
            if (!imageFile.exists()) {
                System.err.println("ERROR: Imagen no encontrada en la ruta: " + this.path);
            }
            this.imagen = ImageIO.read(imageFile);
            if (this.imagen == null) {
                System.err.println("Advertencia: ImageIO.read devolvió null para: " + this.path + ". Archivo podría estar corrupto o no ser una imagen válida.");
            } else {
                System.out.println("Imagen cargada exitosamente: " + this.path);
            }
        } catch (IOException e) {
            System.err.println("Error al cargar la imagen desde: " + this.path + " - " + e.getMessage());
            e.printStackTrace();
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getAncho() { return ancho; }
    public int getAlto() { return alto; }
    public String getName() { return name; }
}