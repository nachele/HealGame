package paqueteMenu;
import javax.swing.JButton;
import javax.swing.JFrame;



public class Menu{
    //botones
    public JButton iniciarJuego;
    public JButton Completados;
    public JButton reiniciarNivel; 
    //posicion botones
    private int iniciarJuegox;
    private int iniciarJuegoy;
    private int Completadosx;
    private int Completadosy;
    private int reiniciarNivelx;
    private int reiniciarNively;
    private int ancho;
    private int alto;

    //constructor
    public Menu(int iniciarJuegox, int iniciarJuegoy, int Completadosx, int Completadosy, int reiniciarNivelx, int reiniciarNively, int ancho, int alto){
        
        this.iniciarJuegox = iniciarJuegox;
        this.iniciarJuegoy = iniciarJuegoy;
        this.Completadosx =  Completadosx;
        this.Completadosy = Completadosy;
        this.reiniciarNivelx = reiniciarNivelx;
        this.reiniciarNively = reiniciarNively;
        this.ancho = ancho;
        this.alto = alto;
        this.iniciarJuego = new JButton("INICIAR JUEGO");
        this.Completados = new JButton("COMPLETADOS");
        this.reiniciarNivel = new JButton("REINICIAR NIVEL");
        this.iniciarJuego.setBounds(iniciarJuegox,iniciarJuegoy,ancho,alto);
        this.Completados.setBounds(Completadosx,Completadosy,ancho,alto);
        this.reiniciarNivel.setBounds(reiniciarNivelx,reiniciarNively,ancho,alto);

    }
    //dibujar botones
    public void pintar(JFrame ventana){
        ventana.add(this.iniciarJuego);
        ventana.add(this.reiniciarNivel);
        ventana.add(this.Completados);
    }
    
}