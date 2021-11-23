package eventos;

import model.Jugador;

public class AbandonoEvent extends Evento {
    private Jugador jugador;
    private int turno;
    
    public AbandonoEvent(Jugador jugador, int turno){
        this.jugador = jugador;
        this.turno = turno;
    }
    
    public Jugador getJugador(){
        return jugador;
    }
    
    public int getTurno(){
        return turno;
    }
    
    
    @Override
    public String toString() {
        return "Abandono del jugador " + jugador.getNombre();
    }
    
}
