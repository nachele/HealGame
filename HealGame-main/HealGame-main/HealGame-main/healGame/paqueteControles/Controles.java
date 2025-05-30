package paqueteControles;
import java.awt.event.*;
public class Controles implements KeyListener{
    public boolean w_k = false;
    public boolean a_k = false;
    public boolean s_k = false;
    public boolean d_k = false;
    public boolean j_k = false;
    public Controles(){
    }
    @Override
    public void keyPressed(KeyEvent e){
        char keyChar = Character.toLowerCase(e.getKeyChar()); // Convertir a minúsculas
        if(keyChar == 'w'){
            w_k = true;
        }
        if(keyChar == 'a'){
            a_k = true;
        }
        if(keyChar == 's'){
            s_k = true;
        }
        if(keyChar == 'd'){
            d_k = true;
        }
        if(keyChar == 'j'){
            j_k = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e){
        char keyChar = Character.toLowerCase(e.getKeyChar()); // Convertir a minúsculas
        if(keyChar == 'w'){
            w_k = false;
        }
        if(keyChar == 'a'){
            a_k = false;
        }
        if(keyChar == 's'){
            s_k = false;
        }
        if(keyChar == 'd'){
            d_k = false;
        }
        if(keyChar == 'j'){
            j_k = false;
        }
    }
    @Override
    public void keyTyped(KeyEvent e){
        
        // No necesitamos implementar lógica aquí para este juego
    }
}