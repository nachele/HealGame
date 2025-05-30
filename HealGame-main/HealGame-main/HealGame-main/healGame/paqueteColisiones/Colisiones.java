package paqueteColisiones;
import paqueteControles.*;
import paqueteEntity.*;
import paqueteEntityJugador.*;
import paqueteMapa.*;

public class Colisiones {
    public int bordeColision = 10;
    public boolean choqueArbolSagrado = false;
    public Colisiones() {
    }

    public void colisionDetection(EntityJugador jugador, Mapa mapa,Controles controles) {
        for(Entity ent : mapa.entidades) {
            // Ejemplo de colisión con un tile llamado "a" (árbol)
            if (ent.getName().equals("a"  ) || ent.getName().equals("d") || ent.getName().equals("e")) {
                if(jugador.getX() < ent.getX() + ent.getAncho() && jugador.getX() + jugador.getAncho() > ent.getX() && jugador.getY() < ent.getY() + ent.getAlto() && jugador.getY() + jugador.getAlto() > ent.getY()){
                    if(jugador.getX() + jugador.getAncho() >= ent.getX() && jugador.getX() + jugador.getAncho() <= ent.getX() + this.bordeColision){
                           
                        for(Entity en : mapa.entidades){en.x += mapa.mapSpeed;}
                        if(ent.getName().equals("d")){
                            
                            this.choqueArbolSagrado = true;
                        }
                        if(ent.getName().equals("e") && this.choqueArbolSagrado){
                            System.out.println("choque con enfermo y curacion");
                        }
                    }
                    if(jugador.getX() <= ent.getX() + ent.getAncho() && jugador.getX() >= ent.getX() + ent.getAncho() - this.bordeColision){
                        for(Entity en : mapa.entidades){en.x -= mapa.mapSpeed;}
                        if(ent.getName().equals("d")){
                            this.choqueArbolSagrado = true;
                        }
                             if(ent.getName().equals("e") && this.choqueArbolSagrado){
                            System.out.println("choque con enfermo y curacion");
                        }
                    }
                    if(jugador.getY() <= ent.getY() + ent.getAlto() && jugador.getY() >= ent.getY() + ent.getAlto() - this.bordeColision){
                        System.out.println("chocando debajo del arbol");
                        for(Entity en : mapa.entidades){en.y -= mapa.mapSpeed;}
                        if(ent.getName().equals("d")){
                            System.out.println("chocando arbol sagrado");
                            this.choqueArbolSagrado = true;
                        }
                             if(ent.getName().equals("e") && this.choqueArbolSagrado){
                            System.out.println("choque con enfermo y curacion");
                        }
                    }
                    if(jugador.getY() + jugador.getAlto() >= ent.getY() && jugador.getY() + jugador.getAlto() <= ent.getY() + this.bordeColision){
                        System.out.println("chocando por arriba del arbol");
                        for(Entity en : mapa.entidades){en.y += mapa.mapSpeed;}
                        if(ent.getName().equals("d")){
                            System.out.println("chocando arbol sagrado");
                            this.choqueArbolSagrado = true;
                        }
                            if(ent.getName().equals("e") && this.choqueArbolSagrado){
                            System.out.println("choque con enfermo y curacion");
                            mapa.cambiarNivel(1);

                        }
                    }
                    }
                }

            }
        }
        public boolean choqueConArbolSagrado(){
            return this.choqueArbolSagrado;
        }
    }
