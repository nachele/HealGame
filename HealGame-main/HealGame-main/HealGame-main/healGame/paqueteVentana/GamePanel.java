package paqueteVentana;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel; // Solo necesitamos JPanel, no JLabel para el mensaje de nivel
import paqueteEntity.Entity;
import paqueteEntityJugador.EntityJugador;
import paqueteMapa.Mapa;
import paqueteMenu.Menu;

public class GamePanel extends JPanel {

    private Mapa mapa;
    private EntityJugador jugador;
    private Menu menu;
    
    // Para el mensaje del nivel:
    private String mensajeNivelTexto;
    private boolean mensajeNivelVisible = false; // Por defecto, el mensaje no es visible

    public GamePanel() {
        setDoubleBuffered(true); // Ayuda a prevenir el parpadeo
        setFocusable(true);
        setBackground(Color.BLACK); // Este es el color de fondo del juego
        // setLayout(null); // Ya no es necesario si no añades componentes Swing directamente a GamePanel
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public void setJugador(EntityJugador jugador) {
        this.jugador = jugador;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
    // Método para que Level pueda pasar el texto del mensaje
    public void setMensajeNivelTexto(String texto) {
        this.mensajeNivelTexto = texto;
        repaint(); // Solicita un repintado para que el texto se actualice
        System.out.println("DEBUG: GamePanel: Texto de nivel establecido a: '" + texto + "'");
    }

    // Método para controlar la visibilidad del texto dibujado
    public void setMensajeNivelVisible(boolean visible) {
        this.mensajeNivelVisible = visible;
        repaint(); // Solicita un repintado para reflejar el cambio de visibilidad
        System.out.println("DEBUG: GamePanel: Visibilidad del texto del nivel establecida a: " + visible);
    }

    // Método para que Main pueda consultar la visibilidad
    public boolean isMensajeNivelVisible() {
        return this.mensajeNivelVisible;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // SIEMPRE LLAMAR A super.paintComponent(g) para limpiar el fondo
        Graphics2D g2d = (Graphics2D) g;

        // SOLO dibuja el contenido del juego si la bandera clickIniciarJuego está activa
        if (menu != null && menu.getClickIniciarJuego()) {
            if (mapa != null) {
                for (Entity ent : mapa.entidades) {
                    if (ent.imagen != null) {
                        // Dibuja el tile. Añadimos +1 al ancho y alto para superponerlo ligeramente
                        // Esto ayuda a prevenir los "espacios negros" debido al antialiasing.
                        g2d.drawImage(ent.imagen, ent.x, ent.y, ent.ancho + 1, ent.alto + 1, null);
                    }
                    
                    // --- DIBUJO DE DEPURACIÓN PARA TILES: CONTORNO ROJO ---
                    // Comenta o elimina estas líneas después de depurar.
                    g2d.setColor(Color.RED); 
                    g2d.drawRect(ent.x, ent.y, ent.ancho, ent.alto);
                    // --- FIN DIBUJO DE DEPURACIÓN ---
                }
            }
            if (jugador != null && jugador.imagen != null) {
                g2d.drawImage(jugador.imagen, jugador.x, jugador.y, jugador.ancho, jugador.alto, null);
            }

            // --- DIBUJAR EL TEXTO DEL NIVEL DIRECTAMENTE ---
            // Solo se dibuja si mensajeNivelVisible es 'true' y el texto no es nulo/vacío
            if (mensajeNivelTexto != null && !mensajeNivelTexto.isEmpty() && mensajeNivelVisible) {
                g2d.setFont(new Font("SansSerif", Font.BOLD, 36));
                g2d.setColor(Color.RED); 
                g2d.drawString(mensajeNivelTexto, 100, 136); 
                System.out.println("DEBUG: GamePanel paintComponent - Dibujando texto: '" + mensajeNivelTexto + "'");
            }
            // --- FIN DE DIBUJO DE TEXTO ---
        }
        
        // --- DIBUJO DE DEPURACIÓN TEMPORAL (RECTÁNGULO MAGENTA para el área del texto) ---
        // Este rectángulo también solo se dibuja si mensajeNivelVisible es 'true'
        if (mensajeNivelVisible) {
            g2d.setColor(Color.MAGENTA);
            g2d.drawRect(100, 100, 600, 150);
            System.out.println("DEBUG: GamePanel paintComponent - Dibujando contorno MAGENTA para el área del texto.");
        }
        // --- FIN DE DIBUJO DE DEPURACIÓN ---

        g2d.dispose(); // Libera los recursos de gráficos
    }
}