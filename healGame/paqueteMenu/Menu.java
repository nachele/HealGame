package paqueteMenu;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import java.awt.datatransfer.FlavorListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import javax.swing.SwingUtilities;
import java.awt.event.MouseEvent;


//clase del menu para el juego 
public class Menu{
    //botones
    private JButton iniciarJuego;
    private JButton Completados;
    private JButton reiniciarNivel; 
    //ventana
    private JFrame ventana;
    //posicion botones
    private int iniciarJuegox;
    private int iniciarJuegoy;
    private int Completadosx;
    private int Completadosy;
    private int reiniciarNivelx;
    private int reiniciarNively;
    private int ancho;
    private int alto;
    //click en los diferentes botones 
    private boolean clickIniciarJuego;
    private boolean clickCompletados;
    private boolean clickReiniciarNivel;

    //constructor
    public Menu(int iniciarJuegox, int iniciarJuegoy, int Completadosx, int Completadosy, int reiniciarNivelx, int reiniciarNively, int ancho, int alto, JFrame ventana){
        //inicializando las propiedades
        this.ventana = ventana;
        this.iniciarJuegox = iniciarJuegox;
        this.iniciarJuegoy = iniciarJuegoy;
        this.Completadosx =  Completadosx;
        this.Completadosy = Completadosy;
        this.reiniciarNivelx = reiniciarNivelx;
        this.reiniciarNively = reiniciarNively;
        this.ancho = ancho;
        this.alto = alto;
        this.iniciarJuego = new JButton("INICIAR JUEGO"); // botones iniciar juego
        this.Completados = new JButton("COMPLETADOS"); //boton completados
        this.reiniciarNivel = new JButton("REINICIAR NIVEL");//boton reiniciar nivel
        //poniendo posicion ancho y alto de los botones 
        this.iniciarJuego.setBounds(iniciarJuegox,iniciarJuegoy,ancho,alto);
        this.Completados.setBounds(Completadosx,Completadosy,ancho,alto);
        this.reiniciarNivel.setBounds(reiniciarNivelx,reiniciarNively,ancho,alto);

        //iniciando booleanso
        this.clickIniciarJuego = false;
        this.clickCompletados = false;
        this.clickReiniciarNivel = false;
        this.pintar(ventana);
        this.clickBotones();
        this.teclaEscape();
        System.out.println("menu creado");
    }
    //geter
    public boolean getClickIniciarJuego(){
        return this.clickIniciarJuego;
    }
    //geter
    public boolean getClickCompletados(){
        return this.clickCompletados;
    }
    //geter
    public boolean getClickReiniciarNivel(){
        return this.clickReiniciarNivel;
    }
    public void setClickIniciarJuego(boolean bul){
        this.clickIniciarJuego = bul;
    }
    public void  setClickCompletados(boolean bul){
        this.clickCompletados = bul;
    }
    public void setClickReiniciarNivel(boolean bul){
        this.clickReiniciarNivel = bul;
    }
    //dibujar botones
    public void pintar(JFrame ventana){
        ventana.add(this.iniciarJuego);
        ventana.add(this.reiniciarNivel);
        ventana.add(this.Completados);
    }
    
    //funcion al darle al escape
    public void teclaEscape(){
        JRootPane rootPane = this.ventana.getRootPane();
        String accionEscape = "accion_escape";
        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), accionEscape);
        rootPane.getActionMap().put(accionEscape, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("escape presionado");
                if(Menu.this.clickCompletados | Menu.this.clickIniciarJuego | Menu.this.clickReiniciarNivel){
                    //añadiendo los botones 
                    Menu.this.ventana.add(Menu.this.Completados);
                    Menu.this.ventana.add(Menu.this.iniciarJuego);
                    Menu.this.ventana.add(Menu.this.reiniciarNivel);
                    Menu.this.ventana.repaint();
                    //booleanos
                    Menu.this.clickCompletados = false;
                    Menu.this.clickIniciarJuego = false;
                    Menu.this.clickReiniciarNivel = false;
                }
            }
        });
    }
    //funcion al hacer click en los botones 
    public void clickBotones(){
        this.iniciarJuego.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                if(SwingUtilities.isLeftMouseButton(e)){

                    //boleano
                    Menu.this.clickIniciarJuego = true;
                    //remover los botones 
                    Menu.this.ventana.remove(Menu.this.iniciarJuego);    
                    Menu.this.ventana.remove(Menu.this.Completados);
                    Menu.this.ventana.remove(Menu.this.reiniciarNivel);
                    Menu.this.ventana.repaint();
                }
            }
        });
        this.Completados.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                if(SwingUtilities.isLeftMouseButton(e)){
                    
                    //booleano
                    Menu.this.clickCompletados = true;
                    //remover botones
                    Menu.this.ventana.remove(Menu.this.iniciarJuego);    
                    Menu.this.ventana.remove(Menu.this.Completados);
                    Menu.this.ventana.remove(Menu.this.reiniciarNivel);
                    Menu.this.ventana.repaint();
                }
            }
        });
        this.reiniciarNivel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
        
                //booleano
                Menu.this.clickReiniciarNivel = true;
                //remover botones
                Menu.this.ventana.remove(Menu.this.iniciarJuego);    
                Menu.this.ventana.remove(Menu.this.Completados);
                Menu.this.ventana.remove(Menu.this.reiniciarNivel);
                Menu.this.ventana.repaint();
            }
        });
    }
}