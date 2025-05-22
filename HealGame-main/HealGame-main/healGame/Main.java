import paqueteControles.*;
import paqueteEntity.*;
import paqueteEntityJugador.*;
import paqueteMenu.*;
import paqueteVentana.*;

//metodo donde se ejecuta el juego 
public class Main {
    public static void main(String[] args) {
        //creando ventana para acceder a la ventana ventana.ventana
        Controles controles = new Controles();
        Ventana ventana = new Ventana(800, 800,controles);
        //creando el menu del juego
        Menu menu = new Menu(100,200,300,200,500,200,200,200,ventana.ventana);
        Entity entidad = new Entity("C:/Users/ignacio/Downloads/HealGame-main/HealGame-main/HealGame-main/healGame/img/arbol.png", 100, 100, 150, 150, 0);
        EntityJugador jugador = new EntityJugador(200,200 , 32 * 2, 54 * 2, 1, "C:/Users/ignacio/Downloads/HealGame-main/HealGame-main/HealGame-main/healGame/img/lightbeing.png");       
        ventana.ventana.add(entidad);
        ventana.ventana.add(jugador);
        ventana.ventana.revalidate();
        ventana.ventana.repaint();
        boolean runing = true;
        Thread hiloPrincipal = new Thread(() -> {
            
            while (runing) {
                if(menu.getClickIniciarJuego() == true){
                    ventana.ventana.add(jugador);
                    ventana.ventana.add(entidad);
                    
                    entidad.pintar();
                    jugador.pintar();
                    jugador.mover(controles);
                    ventana.ventana.repaint();
                }else if(menu.getClickCompletados() == false){
                    ventana.ventana.remove(entidad);
                    ventana.ventana.remove(jugador);
                    ventana.ventana.repaint();
                }
                
                //paradormir el hilo
                try {
                    Thread.sleep(1000 / 120);
                } catch (InterruptedException e) {
                    System.out.println("fuera del hilo");
                }
            }
        });
        hiloPrincipal.start();
    }
}