package model;

import java.awt.Color;
import java.io.Serializable;

public class Jugador implements Serializable {
    
    private char letra; //identificador único
    private String nombre;
    private Color color;
    private String avatar;
    private Configuracion coloresJugadores;

    public Jugador(String nombre, char letra, Color color, String avatar, Configuracion coloresJugadores){
        this.nombre = nombre;
        this.letra = letra;
        this.color = color;
        this.avatar = avatar;
        this.coloresJugadores = coloresJugadores;
    }    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Configuracion getColoresJugadores() {
        return coloresJugadores;
    }

    public void setColoresJugadores(Configuracion coloresJugadores) {
        this.coloresJugadores = coloresJugadores;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.letra;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jugador other = (Jugador) obj;
        if (this.letra != other.letra) {
            return false;
        }
        return true;
    }    
    
}
