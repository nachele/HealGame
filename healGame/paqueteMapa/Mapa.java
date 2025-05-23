package paqueteMapa;
import paqueteEntity.*;
import java.util.ArrayList;

public class Mapa {
    public String mapaTexto[] =    {"hhhhhhhhhhhhhhhhhhassssssahhhhhhhhhhhhhhhhhhhhhhhhhhhhhh/n"+ 
                                    "hhhhhhhhhhhhhhhhhhassssssahhhhhhhhhhhhhhhhhhhhhhhhhhhhhh/n"+
                                    "hhhhhhhhhhhhhhhhhhassssssahhhhhhhhhhhhhhhhhhhhhhhhhhhhhh/n"+
                                    "hhhhhhhhhhhhhhhhhhassssssahhhhhhhhhhhhhhhhhhhhhhhhhhhhhh/n"+
                                    "hhhhhhhhhhhhhhhhhhassssssahhhhhhhhhhhhhhhhhhhhhhhhhhhhhh/n"+
                                    "hhhhhhhhhhhhhhhhhhassssssahhhhhhhhhhhhhhhhhhhhhhhhhhhhhh/n"+
                                    "hhhhhhhhhhhhhhhhhhassssssahhhhhhhhhhhhhhhhhhhhhhhhhhhhhh/n"+
                                    "hhhhhhhhhhhhhhhhhhassssssahhhhhhhhhhhhhhhhhhhhhhhhhhhhhh/n"+
                                    "hhhhhhhhhhhhhhhhhhassssssahhhhhhhhhhhhhhhhhhhhhhhhhhhhhh/n"+
                                    "hhhhhhhhhhhhhhhhhhassssssahhhhhhhhhhhhhhhhhhhhhhhhhhhhhh/n"+
                                    "hhhhhhhhhhhhhhhhhhassssssahhhhhhhhhhhhhhhhhhhhhhhhhhhhhh/n"+
                                    "hhhhhhhhhhhhhhhhhhassssssahhhhhhhhhhhhhhhhhhhhhhhhhhhhhh/n"+
                                    "hhhhhhhhhhhhhhhhhhassssssahhhhhhhhhhhhhhhhhhhhhhhhhhhhhh/n"+
                                    "hhhhhhhhhhhhhhhhhhassssssahhhhhhhhhhhhhhhhhhhhhhhhhhhhhh/n"+
                                    "hhhhhhhhhhhhhhhhhhassssssahhhhhhhhhhhhhhhhhhhhhhhhhhhhhh/n"+
                                    "hhhhhhhhhhhhhhhhhhassssssahhhhhhhhhhhhhhhhhhhhhhhhhhhhhh/n"+
                                    "hhhhhhhhhhhhhhhhhhassssssahhhhhhhhhhhhhhhhhhhhhhhhhhhhhh/n"+
                                    "hhhhhhhhhhhhhhhhhhassssssahhhhhhhhhhhhhhhhhhhhhhhhhhhhhh/n"+
                                    "hhhhhhhhhhhhhhhhhhassssssahhhhhhhhhhhhhhhhhhhhhhhhhhhhhh/n","" };
    
    
    int nfilas = 0;
    int ncolumnas = 0;
    int ncolumnasIni  = 0;
    boolean ncolumnasInit = false;
    ArrayList<Entity> entidades = new ArrayList<>();
    public Mapa(){
        this.IndexInit();
        this.EntityArrayMap();
    }
    int variable = 0;
    public void IndexInit(){
        for(int r = 0; r < this.mapaTexto.length; r++){
            if(r == 0){
                for(int i = 0; i < this.mapaTexto[r].length(); i++){
                    if(this.mapaTexto[r].charAt(i) == '/'){
                        this.nfilas++;
                        if(this.ncolumnasInit == false){
                            this.ncolumnasIni = this.ncolumnas;
                            this.ncolumnasInit = true;
                        }
                        this.ncolumnas = 0;
                        
                    }else{
                        
                        Entity entidad = new Entity("C:/Users/ignacio/Downloads/HealGame-main/HealGame-main/HealGame-main/healGame/img/" + this.mapaTexto[r].charAt(i) + ".png" , this.ncolumnas * 100, this.nfilas*100,100,100,1);
                        this.ncolumnas++;
                    }

                }
            }
        }
    }
    public void EntityArrayMap(){
        for(int i= 0; i < this.nfilas; i++){
            for(int x = 0; x < this.ncolumnasIni ; x++){
//
            }
        }
    }

            

}
