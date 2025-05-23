import paqueteMenu.*;
import paqueteVentana.*;

//metodo donde se ejecuta el juego 
public class Main {
    public static void main(String[] args) {
        Ventana ventana = new Ventana(800, 800);
        Menu menu = new Menu(100,200,300,200,500,200,200,200);
        menu.pintar(ventana.ventana);
        boolean runing = true;
        Thread hiloPrincipal = new Thread(() -> {
            while (runing) {
                System.out.println("hola");
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