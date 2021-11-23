package model;

import java.io.Serializable;

public abstract class Figura implements Serializable {
    
    protected Jugador jugador;
    protected int fila;
    protected int col;
    
    
    protected Figura(Jugador jugador){
        this.jugador = jugador;
    }
    
    protected Figura(Jugador jugador, int fila, int col){
        this(jugador);
        this.fila = fila;
        this.col = col;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
    
    
    
}
