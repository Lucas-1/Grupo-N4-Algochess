package fiuba.algo3.tp2;


import java.util.ArrayList;


public class AdministradorDeEntidades {

    private int puntos_disponibles;
    private ArrayList<Entidad> entidades;

    public AdministradorDeEntidades() {

        puntos_disponibles = 20;
        entidades = new ArrayList<Entidad>();
    }

    public boolean sigueEnJuego() {

        return !(entidades.isEmpty()); /* Jugador se queda sin entidades, pierde. */
    }

    public boolean tieneSuficientesPuntos(int costo) {

        if(puntos_disponibles < costo)
            throw new JugadorNoLeAlcanzaParaEntidadException();

        return true;
    }

    public void borrarEntidad(Entidad entidad) {

        entidades.remove(entidad);
    }

    public void agregarEntidad(Entidad entidad, int posicionFila, int posicionColumna ,Tablero tablero, Color color) {

        if(this.tieneSuficientesPuntos(entidad.getCosto())) {
            tablero.agregarUnidad(entidad,posicionFila,posicionColumna,color);

            entidad.setPosicion(posicionFila,posicionColumna);
            entidades.add(entidad);
            puntos_disponibles -= entidad.getCosto();
        }
    }

    public int getPuntosDisponibles() {

        return  puntos_disponibles;
    }
}
