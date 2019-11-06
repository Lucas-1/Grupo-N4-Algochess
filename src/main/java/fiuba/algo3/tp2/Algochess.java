package fiuba.algo3.tp2;

public class Algochess {

    private Jugador jugador_blanco;
    private Jugador jugador_negro;
    private Tablero tablero;

    public Algochess() {

        jugador_blanco = new Jugador(1);
        jugador_negro = new Jugador(2);
        tablero = new Tablero();
    }

}
