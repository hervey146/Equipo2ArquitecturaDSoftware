package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Marcador {
    private Map<Jugador, Integer> jugadores; //contiene los jugadores y sus respectivos puntos
    
    public Marcador(){
        jugadores = new LinkedHashMap<>();
    }
    
    public Marcador(List<Jugador> listaJugadores){
        this();
        listaJugadores.forEach((jugador)->{
            addJugador(jugador);
        });
    }

    public Map<Jugador, Integer> getJugadores() {
        return jugadores;
    }
    
    public void setJugadores(Map<Jugador, Integer> jugadores){
        this.jugadores = jugadores;
    }
    
    public Jugador getJugador(int idx){
        return new ArrayList<>(jugadores.keySet()).get(idx);
    }

    public void addJugador(Jugador jugador) {
        jugadores.put(jugador, 0); // se añade un jugador estableciendo su puntaje en 0
    }
    
    public void otorgarPunto(Jugador jugador){
        jugadores.put(jugador, jugadores.get(jugador)+1);
    }
    
    public void eliminaJugador(Jugador jugador){
        jugadores.remove(jugador);
    }
    
    
    
    
    
}
