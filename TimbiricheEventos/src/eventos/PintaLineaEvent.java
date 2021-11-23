package eventos;

import model.Jugador;
import model.Linea;

public class PintaLineaEvent extends Evento {

    // dentro se incluye al Jugador 
    private Linea linea; // no puede ser BtnLinea, tiene que ser la entidad de negocio
    private boolean cuadroPintado;
    
    public PintaLineaEvent(Linea linea, boolean cuadroPintado) {
        this.linea = linea;
        this.cuadroPintado = cuadroPintado;
    }

    public Linea getLinea() {
        return linea;
    }

    public Jugador getJugador() {
        return linea.getJugador();
    }

    public boolean pintoCuadro(){
        return cuadroPintado;
    }
    
    @Override
    public String toString() {
        return "Este es un evento para el pintado de una linea";
    }

}
