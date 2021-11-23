package model;

public class Cuadro extends Figura {

    private Linea lUp;
    private Linea lDown;
    private Linea lLeft;
    private Linea lRight;

    public Cuadro(Jugador jugador, Linea lUp, Linea lDown, Linea lLeft, Linea lRight) {
        super(jugador);
        
        this.lUp = lUp;
        this.lDown = lDown;
        this.lLeft = lLeft;
        this.lRight = lRight;        
    }
    public Cuadro(Jugador jugador, Linea lUp, Linea lDown, Linea lLeft, Linea lRight, int fila, int col) {
        this(jugador, lUp, lDown, lLeft, lRight);
        super.fila = fila;
        super.col = col;
    }

    public Linea getlUp() {
        return lUp;
    }

    public void setlUp(Linea lUp) {
        this.lUp = lUp;
    }

    public Linea getlDown() {
        return lDown;
    }

    public void setlDown(Linea lDown) {
        this.lDown = lDown;
    }

    public Linea getlLeft() {
        return lLeft;
    }

    public void setlLeft(Linea lLeft) {
        this.lLeft = lLeft;
    }

    public Linea getlRight() {
        return lRight;
    }

    public void setlRight(Linea lRight) {
        this.lRight = lRight;
    }
    
    
    
   

}
