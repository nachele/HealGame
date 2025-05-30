package paqueteEntityJugador;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import paqueteControles.Controles;
import paqueteEntity.Entity;

public class EntityJugador extends Entity implements Runnable {
    // La bandera finalMapa no es necesaria para el movimiento si el jugador está fijo
    // Pero la mantendremos si la usas para otras lógicas de juego.
    public boolean finalMapa = false; 
    public boolean aura = false;
    public boolean auraInit = false;

    public EntityJugador(int x, int y, int ancho, int alto, int speed, String path) {
       super(path, x, y, ancho, alto, speed);
       // El 'speed' del jugador ya no es relevante si el jugador no se mueve.
       // Lo dejamos aquí si necesitas el campo, pero no se usará para mover al jugador.
    }
    @Override
    public void run(){while(true){
        int milis = 2000;
        if(this.aura && !this.auraInit){
            this.path= "C:/Users/ignacio/Downloads/HealGame-main/HealGame-main/HealGame-main/healGame/img/lightbeingAura.png";
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
            this.auraInit = true;
        }
        try{
            Thread.sleep( milis);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }}
    public void mover(Controles controles) {
        // ¡CAMBIO CLAVE AQUÍ!
        // El jugador NO SE MUEVE. Eliminamos la lógica de movimiento del jugador.
        // Solo el mapa se moverá.
        // Puedes dejar este método vacío o eliminarlo si no lo necesitas para nada más.
    }
}