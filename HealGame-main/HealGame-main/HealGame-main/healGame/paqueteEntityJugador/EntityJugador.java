package paqueteEntityJugador;
import paqueteControles.*;
import paqueteEntity.*;

public class EntityJugador extends Entity{
    int xInicial;
    public EntityJugador(int x, int y, int ancho,int alto,int speed, String path){
       super(path,x,y,ancho,alto,speed);
       xInicial = x;
    }
    public void mover(Controles controles){
        if(controles.w_k == true){
            this.y -= this.speed;
        }
        if(controles.s_k == true){
            this.y += this.speed;
        }
        if(controles.a_k == true){
            this.x -= this.speed;
        }
        if(controles.d_k == true){
            this.x += this.speed;
        }
    }
}
