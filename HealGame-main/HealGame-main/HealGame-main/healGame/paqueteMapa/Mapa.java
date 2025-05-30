package paqueteMapa;

import java.util.ArrayList;
import java.util.List;
import paqueteControles.Controles;
import paqueteEntity.Entity;

public class Mapa {
    public List<String[]> niveles = new ArrayList<>();
    public   int nivelActual = 0;

    public int tileSize = 100;
    public int mapSpeed = 2;

    public ArrayList<Entity> entidades = new ArrayList<>();

    public Mapa() {
        // --- Define tus niveles de mapa aquí ---

        // Nivel 1
        String[] mapaNivel1 = {
            "aaaaaaaaaaa",
            "aaaaaaaaaaa",
            "aaaaaaaaaaa",
            "aaassaaaaaa",
            "aaasaaaaaaa",
            "aaassaaaaaa",
            "aaassdssaaaaa",
            "aaassallaaa",
            "aaassallaaa",
            "aaassallaaa",
            "aaassaaaaaa",
            "aaassaaaaaa",
            "aaassaaaaaa",
            "aaassaaaaaa",
            "aaaesaaaaaa",
            "aaassallaaa",
            "aaassallaaa",
            "aaassallaaa",
            "aaassaaaaaa",
            "aaaaaaaaaaa",
            "aaaaaaaaaaa",
            "aaaaaaaaaaa"
        };
        niveles.add(mapaNivel1);

        // Nivel 2
        String[] mapaNivel2 = {
            "sssssssssss",
            "saaasssalaa",
            "saaasssalaa",
            "saaassssaaa",
            "saaassssaaa",
            "saaassssaaa",
            "saaassssaaa",
            "saaassssaaa",
            "saaasssaaa",
            "saaassssaaa",
            "saaassssaaa",
            "saaassssaaa",
            "saaassssaaa",
            "saaaaaasaaa",
            "saaaaaasaaa",
            "saaaaaasaaa",
            "saaaaaasaaa",
            "saaaaaasaaa",
            "saaaaaasaaa",
            "saaaaaasaaa",
            "saaaaaasaaa",
            "sssssssssss"
        };
        niveles.add(mapaNivel2);

        loadMapEntities(); // Carga el mapa inicial (que será el de nivelActual = 0)
    }

    private void loadMapEntities() {
        this.entidades.clear(); // CRUCIAL: Limpia todas las entidades existentes

        String[] currentMapText = niveles.get(nivelActual);

        for(int row = 0; row < currentMapText.length; row++) {
            String fila = currentMapText[row];
            for(int col = 0; col < fila.length(); col++) {
                char tileChar = fila.charAt(col);
                String imagePath = "C:/Users/ignacio/Downloads/HealGame-main/HealGame-main/HealGame-main/healGame/img/" + tileChar + ".png";

                int xPos = col * tileSize;
                int yPos = (row * tileSize) - 800;

                Entity entidad = new Entity(imagePath, xPos, yPos, tileSize, tileSize, 0);
                entidad.name = Character.toString(tileChar);
                this.entidades.add(entidad);
            }
        }
        System.out.println("Mapa cargado con " + entidades.size() + " tiles.");
    }

    /**
     * Cambia el nivel actual del juego y recarga el mapa.
     * @param nuevoNivelIndex El índice del nuevo nivel a cargar (ej. 0 para el primer nivel).
     */
    public synchronized void cambiarNivel(int nuevoNivelIndex) {
        if (nuevoNivelIndex >= 0 && nuevoNivelIndex < niveles.size()) {
            // Only change if it's actually a new level to avoid unnecessary reloads
            if (this.nivelActual != nuevoNivelIndex) {
                this.nivelActual = nuevoNivelIndex;
                loadMapEntities(); // Recarga las entidades para el nuevo mapa
                System.out.println("Cambiando a Nivel: " + (nuevoNivelIndex + 1));
            }
        } else {
            System.err.println("Índice de nivel inválido: " + nuevoNivelIndex + ". El nivel no ha cambiado.");
        }
    }

    public void moverMapa(Controles controles){
        // --- CHECK FOR LEVEL CHANGE *BEFORE* MOVING ENTITIES ---
        // This ensures the level change happens once and the new map is loaded
        if(controles.j_k){
            // For now, let's hardcode to level 2 (index 1).
            // You might want more sophisticated logic later, like:
            // cambiarNivel((this.nivelActual + 1) % niveles.size()); // To cycle through levels
            cambiarNivel(1); // Calls the method to change level and reload entities
            return; // Exit the method early if a level change just happened,
                    // as the old entities are gone and new ones need a new frame to be drawn.
        }

        // --- MOVEMENT LOGIC (Only if no level change occurred) ---
        for(Entity ent : this.entidades){
            if(controles.w_k){ // Si el jugador quiere ir ARRIBA, el mapa se mueve hacia ABAJO
                ent.y += this.mapSpeed;
            }
            if(controles.s_k){ // Si el jugador quiere ir ABAJO, el mapa se mueve hacia ARRIBA
                ent.y -= this.mapSpeed;
            }
            if(controles.a_k){ // Si el jugador quiere ir IZQUIERDA, el mapa se mueve hacia DERECHA
                ent.x += this.mapSpeed;
            }
            if(controles.d_k){ // Si el jugador quiere ir DERECHA, el mapa se mueve hacia IZQUIERDA
                ent.x -= this.mapSpeed;
            }
        }
    }
}