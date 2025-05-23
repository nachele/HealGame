package paqueteControles;
import java.awt.event.*;
public class Controles implements KeyListener{
    public boolean w_k = false;
    public boolean a_k = false;
    public boolean s_k = false;
    public boolean d_k = false;
    public Controles(){

    }
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyChar() == 'w'){
            w_k = true;
        }
        if(e.getKeyChar() == 'a'){
            a_k = true;
        }
        if(e.getKeyChar() == 's'){
            s_k = true;
        }
        if(e.getKeyChar() == 'd'){
            d_k = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e){
        if(e.getKeyChar() == 'w'){
            w_k = false;
        }
        if(e.getKeyChar() == 'a'){
            a_k = false;
        }
        if(e.getKeyChar() == 's'){
            s_k = false;
        }
        if(e.getKeyChar() == 'd'){
            d_k = false;
        }
    }
    @Override
    public void keyTyped(KeyEvent e){
    }

}