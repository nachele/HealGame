package paqueteMenu;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import paqueteVentana.Ventana;

public class Menu {
    private JButton iniciarJuego;
    private JButton Completados;
    private JButton reiniciarNivel;
    private Ventana ventanaPrincipal;
    private JPanel menuButtonPanel; // Este es el panel que cubre el GamePanel

    private boolean clickIniciarJuego;
    private boolean clickCompletados;
    private boolean clickReiniciarNivel;

    public Menu(int iniciarJuegox, int iniciarJuegoy, int Completadosx, int Completadosy,
                int reiniciarNivelx, int reiniciarNively, int ancho, int alto, Ventana ventana) {
        
        this.ventanaPrincipal = ventana;
        this.menuButtonPanel = new JPanel();
        this.menuButtonPanel.setLayout(null); // Usamos null layout para posicionar los botones
        this.menuButtonPanel.setOpaque(false); // Para que se vea el fondo negro del GamePanel

        iniciarJuego = new JButton("Iniciar Juego");
        iniciarJuego.setBounds(iniciarJuegox, iniciarJuegoy, ancho, alto);
        iniciarJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setClickIniciarJuego(true);
                // Cuando se inicia el juego, ocultamos el panel de botones del menú
                menuButtonPanel.setVisible(false); // ¡Añadido!
                System.out.println("Botón 'Iniciar Juego' presionado. Menú oculto.");
            }
        });
        this.menuButtonPanel.add(iniciarJuego);

        Completados = new JButton("Completados");
        Completados.setBounds(Completadosx, Completadosy, ancho, alto);
        Completados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setClickCompletados(true);
                System.out.println("Botón 'Completados' presionado.");
                // El panel de botones sigue visible si se va a "Completados"
            }
        });
        this.menuButtonPanel.add(Completados);

        reiniciarNivel = new JButton("Reiniciar Nivel");
        reiniciarNivel.setBounds(reiniciarNivelx, reiniciarNively, ancho, alto);
        reiniciarNivel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setClickReiniciarNivel(true);
                System.out.println("Botón 'Reiniciar Nivel' presionado.");
                // El panel de botones sigue visible si se va a "Reiniciar Nivel"
            }
        });
        this.menuButtonPanel.add(reiniciarNivel);

        // KeyBinding para la tecla ESC para pausar el juego y volver al menú
        this.ventanaPrincipal.ventana.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "escapeMenu");
        this.ventanaPrincipal.ventana.getRootPane().getActionMap().put("escapeMenu", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickIniciarJuego && !clickCompletados && !clickReiniciarNivel) {
                    resetMenuState(); // Si el juego está corriendo, lo pausa y muestra el menú
                    System.out.println("Tecla ESC presionada. Menú mostrado.");
                }
            }
        });
    }

    public JPanel getMenuButtonPanel() {
        return menuButtonPanel;
    }

    public boolean getClickIniciarJuego() { return this.clickIniciarJuego; }
    public boolean getClickCompletados() { return this.clickCompletados; }
    public boolean getClickReiniciarNivel() { return this.clickReiniciarNivel; }

    public void setClickIniciarJuego(boolean bul) { this.clickIniciarJuego = bul; }
    public void setClickCompletados(boolean bul) { this.clickCompletados = bul; }
    public void setClickReiniciarNivel(boolean bul) { this.clickReiniciarNivel = bul; }

    public void resetMenuState() {
        clickIniciarJuego = false;
        clickCompletados = false;
        clickReiniciarNivel = false;

        // Cuando se resetea el estado del menú (e.g., al pausar), mostramos el panel de botones
        menuButtonPanel.setVisible(true); // ¡Añadido!
    }
}