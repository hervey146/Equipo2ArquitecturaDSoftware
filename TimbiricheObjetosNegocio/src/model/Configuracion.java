package model;

import java.awt.Color;
import java.io.Serializable;

public class Configuracion implements Serializable {
    private Color[] coloresJugadores;
    
    public Configuracion(){
        coloresJugadores = new Color[3];
    }
    
    public void randomColor(int cantidadJugadores){
        for (int i = 0; i < cantidadJugadores-1; i++) {
            coloresJugadores[i] = new Color(
                    (float)Math.random(), 
                    (float)Math.random(), 
                    (float)Math.random()
            );
        }
    }

    public void setColor(int index, Color color){
        coloresJugadores[index] = color;
    }
    
    public Color[] getColores(){
        return coloresJugadores;
    }
    
}
