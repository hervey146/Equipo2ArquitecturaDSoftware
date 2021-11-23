package eventos;

import java.util.List;
import model.Jugador;

public class InicioPartidaEvent extends Evento {
    private List<Jugador> jugadores;
    
    public InicioPartidaEvent(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    
    @Override
    public String toString() {
        return "Este es un evento para el inicio de la partida";
    }
}
