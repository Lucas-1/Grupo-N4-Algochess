package fiuba.algo3.tp2;

public class AdministradorEventosGeneral {

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
