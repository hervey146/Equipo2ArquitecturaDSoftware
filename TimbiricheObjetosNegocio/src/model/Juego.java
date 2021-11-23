package model;

/**
 * Esta clase se crea cuando todos deciden iniciar el juego.
 *
 * @author tonyo
 */
public class Juego {

    private Linea[][] lineasH;
    private Linea[][] lineasV;
    private Cuadro[][] cuadros;
    private int size;

    public Juego(int size) {
        lineasH = new Linea[size + 1][size + 1];
        lineasV = new Linea[size + 1][size + 1];
        cuadros = new Cuadro[size][size];
        this.size = size;
    }

    public Cuadro[][] getCuadros() {
        return cuadros;
    }

    public boolean pintaLinea(int fila, int col, Jugador jugador, int orientacion) {

        if (orientacion == Constantes.HORIZONTAL) {
            lineasH[fila][col] = new Linea(jugador, fila, col, orientacion);
            System.out.println("Linea h " + fila + ", " + col + " pintada");
            return pintaCuadro(fila, col, jugador, orientacion);
        } else if (orientacion == Constantes.VERTICAL) {
            System.out.println("Linea v " + fila + ", " + col + " pintada");
            lineasV[fila][col] = new Linea(jugador, fila, col, orientacion);
            return pintaCuadro(fila, col, jugador, orientacion);
        }
        return false;
    }

    public boolean pintaCuadro(int fila, int col, Jugador jugador, int ori) {
        boolean pinto = false;
        if (ori == Constantes.HORIZONTAL) {
            // checa arriba
            if (fila > 0 // si no está en el limite
                    && lineasV[fila - 1][col] != null
                    && lineasV[fila - 1][col + 1] != null
                    && lineasH[fila - 1][col] != null) {
                // crea el cuadro
                cuadros[fila - 1][col] = new Cuadro(jugador, lineasH[fila - 1][col], lineasH[fila][col],
                        lineasV[fila - 1][col], lineasV[fila - 1][col + 1], fila - 1, col);
                // arriba
                lineasH[fila - 1][col].setCuadro2(cuadros[fila - 1][col]);
                // abajo (actual)
                lineasH[fila][col].setCuadro1(cuadros[fila - 1][col]);
                // izquierda
                lineasV[fila - 1][col].setCuadro2(cuadros[fila - 1][col]);
                // derecha
                lineasV[fila - 1][col + 1].setCuadro1(cuadros[fila - 1][col]);
                pinto = true;
            }
            // checa abajo
            if (fila < size
                    && lineasV[fila][col] != null
                    && lineasV[fila][col + 1] != null
                    && lineasH[fila + 1][col] != null) {
                // crea el cuadro

                cuadros[fila][col] = new Cuadro(jugador, lineasH[fila][col], lineasH[fila][col + 1],
                        lineasV[fila][col], lineasV[fila][col + 1], fila, col);
                // arriba (actual)
                lineasH[fila][col].setCuadro2(cuadros[fila][col]);
                // abajo
                lineasH[fila + 1][col].setCuadro1(cuadros[fila][col]);
                // izquierda
                lineasV[fila][col].setCuadro2(cuadros[fila][col]);
                // derecha
                lineasV[fila][col+1].setCuadro1(cuadros[fila][col]);
                pinto = true;
            }

        } else if (ori == Constantes.VERTICAL) {
            // checa izquierda
            if (col > 0 // si no está en el limite
                    && lineasH[fila][col - 1] != null
                    && lineasH[fila + 1][col - 1] != null
                    && lineasV[fila][col - 1] != null) {
                // crea el cuadro
                cuadros[fila][col - 1] = new Cuadro(jugador, lineasH[fila][col - 1], lineasH[fila + 1][col - 1],
                        lineasV[fila][col - 1], lineasV[fila][col], fila - 1, col);
                // arriba
                System.out.println("fila: " + fila);
                System.out.println("columna: " + col);
                lineasH[fila][col - 1].setCuadro2(cuadros[fila][col -1]);
                // abajo
                lineasH[fila + 1][col - 1].setCuadro1(cuadros[fila][col -1]);
                // izquierda
                lineasV[fila][col - 1].setCuadro2(cuadros[fila][col -1]);
                // derecha (acutal)
                lineasV[fila][col].setCuadro1(cuadros[fila][col -1]);

                pinto = true;
            }
            // checa derecha
            if (col < size
                    && lineasH[fila][col] != null
                    && lineasH[fila + 1][col] != null
                    && lineasV[fila][col + 1] != null) {

                // crea el cuadro
                cuadros[fila][col] = new Cuadro(jugador, lineasH[fila][col], lineasH[fila + 1][col],
                        lineasV[fila][col], lineasV[fila][col + 1], fila, col);
                // arriba
                lineasH[fila][col].setCuadro2(cuadros[fila][col]);
                // abajo
                lineasH[fila + 1][col].setCuadro1(cuadros[fila][col]);
                // izquierda (actual)
                lineasV[fila][col].setCuadro2(cuadros[fila][col]);
                // derecha
                lineasV[fila][col + 1].setCuadro1(cuadros[fila][col]);
                pinto = true;
            }
        }

        return pinto;
    }

}
