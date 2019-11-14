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


        tablero.agregarUnidad(entidad,posicionFila,posicionColumna,color);

        entidad.setPosicion(posicionFila,posicionColumna);
        entidades.add(entidad);


    }

    public int getPuntosDisponibles() {

        return  puntos_disponibles;
    }

    //

    public void agregarCatapulta(Tablero tablero, Color color, int posFila, int posColumna) {

        Catapulta catapulta = new Catapulta(color);

        if(tieneSuficientesPuntos(5))
            this.agregarEntidad(catapulta,posFila,posColumna,tablero,color);

        puntos_disponibles -= 5;
    }

    public void agregarJinete(Tablero tablero, Color color, int posFila, int posColumna) {

        Jinete jinete = new Jinete(color);

        if(tieneSuficientesPuntos(3))
            this.agregarEntidad(jinete,posFila,posColumna,tablero,color);

        puntos_disponibles -= 3;
    }

    public void agregarCurandero(Tablero tablero, Color color, int posFila, int posColumna) {

        Curandero curandero = new Curandero(color);

        if(tieneSuficientesPuntos(2))
            this.agregarEntidad(curandero,posFila,posColumna,tablero,color);

        puntos_disponibles -= 2;
    }

    public void agregarSoldadoInfanteria(Tablero tablero, Color color, int posFila, int posColumna) {

        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(color);

        if(tieneSuficientesPuntos(1))
            this.agregarEntidad(soldado,posFila,posColumna,tablero,color);

        puntos_disponibles -= 1;
    }
}
