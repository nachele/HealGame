package paqueteMain;

import javax.swing.SwingUtilities;
import paqueteColisiones.Colisiones;
import paqueteControles.Controles;
import paqueteEntityJugador.EntityJugador;
import paqueteMapa.Mapa;
import paqueteMenu.Menu;
import paqueteNiveles.*;
import paqueteVentana.GamePanel;
import paqueteVentana.Ventana;

public class Main {

    private static boolean running = true;

    public static void main(String[] args) {
        System.out.println("****** INICIANDO MAIN.JAVA - VERSION PARA DEPURAR TILES *******"); // <-- MENSAJE DE DEPURACIÓN

        Controles controles = new Controles();
        Ventana ventana = new Ventana(800, 800, controles);
        GamePanel gamePanel = ventana.getGamePanel(); // Obtiene la instancia de GamePanel

        Menu menu = new Menu(100, 200, 300, 200, 500, 200, 200, 200, ventana);
        gamePanel.setMenu(menu);

        ventana.addMenuPanel(menu.getMenuButtonPanel());

        Mapa mapa = new Mapa();
        EntityJugador jugador = new EntityJugador(
            (ventana.ancho / 2) - (32 * 2 / 2),
            (ventana.alto / 2) - (54 * 2 / 2),
            32 * 2, 54 * 2, 4,
            "C:/Users/ignacio/Downloads/HealGame-main/HealGame-main/HealGame-main/healGame/img/lightbeing.png");
        Thread hilojugador = new Thread(jugador);
        hilojugador.start();
        
        gamePanel.setMapa(mapa);
        gamePanel.setJugador(jugador);
        
        Colisiones colisiones = new Colisiones();
        // ¡IMPORTANTE! Level ahora pasará el String, no un componente Swing.
        // Asegúrate de que Level.java esté actualizado para usar comentarioTexto y setMensajeNivelTexto
        Level level = new Level(mapa.niveles.size(), ventana, gamePanel, jugador,mapa.entidades, colisiones); // Pasa GamePanel a Level
        level.start();

        Thread gameLoopThread = new Thread(() -> {

            long lastTime = System.nanoTime(); // ¡CORREGIDO!
            double amountOfTicks = 60.0;
            double ns = 1000000000 / amountOfTicks;
            double delta = 0;

            while (running) {
                long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;

                if (delta >= 1) {
                    if (menu.getClickIniciarJuego()) {
                        jugador.finalMapa = true;
                        colisiones.colisionDetection(jugador, mapa, controles);
                        mapa.moverMapa(controles);
                        level.LevelAdventure(ventana, jugador, mapa.entidades,colisiones);
                        
                        
                        // Esta sección se mantiene COMENTADA para que el mensaje del nivel NO se vea al iniciar el juego
                        // if (!gamePanel.isMensajeNivelVisible()) {
                        //     gamePanel.setMensajeNivelVisible(true); 
                        //     System.out.println("DEBUG: Se hizo visible el mensaje del nivel.");
                        // }

                    } else if (menu.getClickCompletados() || menu.getClickReiniciarNivel()) {
                        menu.resetMenuState();
                        // Esto asegura que el mensaje se oculte si por alguna razón ya era visible.
                        if (gamePanel.isMensajeNivelVisible()) { 
                            gamePanel.setMensajeNivelVisible(false);
                            System.out.println("DEBUG: Se hizo invisible el mensaje del nivel.");
                        }
                    }
                    delta--;

                    SwingUtilities.invokeLater(() -> {
                        gamePanel.repaint();
                    });
                }

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.err.println("El hilo de juego fue interrumpido inesperadamente.");
                    Thread.currentThread().interrupt();
                    running = false;
                }
            }
        });

        gameLoopThread.start();
    }
}