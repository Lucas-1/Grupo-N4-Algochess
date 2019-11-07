package fiuba.algo3.tp2;

public class Algochess {

    private Jugador jugador_blanco;
    private Jugador jugador_negro;
    private Tablero tablero;
    private int estado; // 0 = en juego // 1 = gana el blanco // 2 = gana el negro

    public Algochess() {

        jugador_blanco = new Jugador(1);
        jugador_negro = new Jugador(2);
        tablero = new Tablero();
        estado = 0;
    }
}
