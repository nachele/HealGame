package paqueteVentana;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLayeredPane; // Importante: Para superponer componentes
import javax.swing.JPanel;
import paqueteControles.Controles;

public class Ventana {
    public int ancho;
    public int alto;
    public JFrame ventana;
    private GamePanel gamePanel;
    private JLayeredPane layeredPane; // Nuevo: Para superponer componentes

    public Ventana(int ancho, int alto, Controles control) {
        this.ancho = ancho;
        this.alto = alto;
        this.ventana = new JFrame("HealGame");
        this.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.ventana.setSize(this.ancho, this.alto);
        this.ventana.setResizable(false);
        this.ventana.setLayout(new BorderLayout()); // El JFrame usa BorderLayout para el JLayeredPane

        // Crea el JLayeredPane y lo añade al centro del JFrame
        this.layeredPane = new JLayeredPane();
        this.layeredPane.setPreferredSize(new java.awt.Dimension(ancho, alto));
        this.ventana.add(this.layeredPane, BorderLayout.CENTER);

        // Crea e inicializa el GamePanel (el lienzo de dibujo del juego)
        this.gamePanel = new GamePanel();
        this.gamePanel.setBounds(0, 0, ancho, alto); // El GamePanel ocupa todo el layeredPane
        this.gamePanel.setFocusable(true);
        this.gamePanel.addKeyListener(control);

        // Añade el GamePanel a la capa de fondo del layeredPane (DEFAULT_LAYER)
        this.layeredPane.add(this.gamePanel, JLayeredPane.DEFAULT_LAYER);

        this.ventana.pack();
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);

        // Asegura que el GamePanel tenga el foco para la entrada del teclado al inicio
        this.gamePanel.requestFocusInWindow();
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    /**
     * Nuevo método para añadir un panel (e.g., el panel de botones del menú) al layeredPane.
     * Este panel se añade a la capa de PALETTE_LAYER para que esté por encima del GamePanel.
     * @param menuPanel El JPanel a añadir (usualmente el panel que contiene los botones del menú).
     */
    public void addMenuPanel(JPanel menuPanel) {
        // Asegúrate de que el tamaño y la posición del menuPanel sean correctos
        menuPanel.setBounds(0, 0, ancho, alto); // El panel de menú ocupa todo el layeredPane
        // Añade el panel de menú a una capa superior para que se vea sobre el GamePanel
        this.layeredPane.add(menuPanel, JLayeredPane.PALETTE_LAYER); 
        // Vuelve a validar y repintar el layeredPane para asegurar que el nuevo componente se muestre.
        this.layeredPane.revalidate();
        this.layeredPane.repaint();
    }
}