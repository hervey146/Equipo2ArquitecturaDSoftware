package model;

public class Linea extends Figura{

    private Cuadro cuadro1;
    private Cuadro cuadro2;
    private int orientacion;
    
    public Linea (Jugador jugador){
        super(jugador);
    }
    public Linea (Jugador jugador, int fila, int col, int orientacion){
        super(jugador, fila, col);
        this.orientacion = orientacion;
    }

    public Cuadro getCuadro1() {
        return cuadro1;
    }

    public void setCuadro1(Cuadro cuadro1) {
        this.cuadro1 = cuadro1;
    }

    public Cuadro getCuadro2() {
        return cuadro2;
    }

    public void setCuadro2(Cuadro cuadro2) {
        this.cuadro2 = cuadro2;
    }

    public int getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(int orientacion) {
        this.orientacion = orientacion;
    }
    
    

    
   
}
