package fiuba.algo3.tp2;

public class AdministradorEventosGeneral {
    /** esta clase se encarga de mandar fase inicial, y hacer pasar los turnos hasta que alguien pierda*/
    private AdministradorEventosPorTurno administradorEventosPorTurno;

    public AdministradorEventosGeneral(){
        administradorEventosPorTurno = new AdministradorEventosPorTurno();
    }

    public void iniciarJuego(){
        administradorEventosPorTurno = new AdministradorEventosPorTurno();
        administradorEventosPorTurno.faseInicial();
        while(administradorEventosPorTurno.juegoContinua()){
            administradorEventosPorTurno.nuevoTurno();
        }
    }
}
