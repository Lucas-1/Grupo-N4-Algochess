package fiuba.algo3.tp2;

public class Algochess {
    private AdministradorEventosGeneral administradorEventosGeneral;

    public Algochess() {

        administradorEventosGeneral = new AdministradorEventosGeneral();
        administradorEventosGeneral.iniciarJuego();



        /*Color blanco = new Blanco();
        Color negro = new Negro();

        jugadorBlanco = new Jugador(blanco);
        jugadorNegro = new Jugador(negro);
        tablero = new Tablero();*/
    }
/*
    public void inicializarEntidades() {

        jugadorBlanco.inicializarEntidades(tablero);
        jugadorNegro.inicializarEntidades(tablero);
    }

    public void Jugar() {

        while(true) {

            jugadorBlanco.moverUnaEntidad(tablero);
            jugadorBlanco.atacar(tablero);

            if(!jugadorNegro.sigueEnJuego()) {
               System.out.println("Gano el blanco");
               break;
            }

            jugadorNegro.moverUnaEntidad(tablero);
            jugadorNegro.atacar(tablero);

            if(!jugadorBlanco.sigueEnJuego()) {
                System.out.println("Gano el negro");
                break;
            }
        }
    }
*/
}
