package paqueteNiveles;

import java.util.ArrayList;
import paqueteColisiones.Colisiones; // Importar GamePanel
import paqueteEntity.Entity;
import paqueteEntityJugador.EntityJugador;
import paqueteVentana.GamePanel;
import paqueteVentana.Ventana;


public class Level extends Thread{
    // CAMBIO CLAVE: Ahora solo guardamos el String del comentario.
    // El JTextArea/JLabel ya no se crea aquí.
    public String comentarioTexto = "hola este es el nivel 1"; 

    public int currentLevel = 0;
    public ArrayList <Integer> levels =  new ArrayList<>();
    private GamePanel gamePanel; // Referencia al GamePanel

    // El constructor ahora acepta GamePanel para poder pasarle el texto del nivel
    public Level(int nlevels, Ventana ventana, GamePanel gamePanel, EntityJugador jugador, ArrayList<Entity> entidades, Colisiones colisiones){ // ¡Ahora recibe GamePanel!
        this.gamePanel = gamePanel; // Guardar la referencia al GamePanel
        for(int i = 0; i < nlevels; i++){
            levels.add(i);
        }
        
    }
    @Override
    public void run(){

    }

    public void LevelAdventure(Ventana ventana, EntityJugador jugador, ArrayList<Entity>entidades,Colisiones colisiones ){
        if(this.currentLevel == 0){
           if(colisiones.choqueArbolSagrado == true){
            jugador.aura = true;
           }
        }
        // No hay configuraciones de JLabel ni de setVisible aquí, porque no hay JLabel.
        // Toda la lógica de visibilidad y dibujo se maneja en GamePanel y Main.
    }
}