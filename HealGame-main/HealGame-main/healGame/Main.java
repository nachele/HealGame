import paqueteMenu.*;
import paqueteVentana.*;
import paqueteEntity.*;
import java.io.File;

//metodo donde se ejecuta el juego 
public class Main {
    public static void main(String[] args) {
        //creando ventana para acceder a la ventana ventana.ventana
        Ventana ventana = new Ventana(800, 800);
        //creando el menu del juego
        Menu menu = new Menu(100,200,300,200,500,200,200,200,ventana.ventana);
        Entity entidad = new Entity("C:/Users/ignac/Desktop/HealGame-main/HealGame-main/healGame/img/arbol.png", 100, 100, 100, 100, 0);
        ventana.ventana.add(entidad);
        ventana.ventana.revalidate();
        ventana.ventana.repaint();
        boolean runing = true;
        Thread hiloPrincipal = new Thread(() -> {
            while (runing) {
                if(menu.getClickIniciarJuego() == true){
                    ventana.ventana.add(entidad);
                    entidad.pintar();
                    ventana.ventana.repaint();
                }else if(menu.getClickCompletados() == false){
                    ventana.ventana.remove(entidad);
                    ventana.ventana.repaint();
                }
                
                //paradormir el hilo
                try {
                    Thread.sleep(1000 / 60);
                } catch (InterruptedException e) {
                    System.out.println("fuera del hilo");
                }
            }
        });
        hiloPrincipal.start();
    }
}