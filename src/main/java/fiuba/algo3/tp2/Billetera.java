package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.JugadorQuiereUtilizarMasDineroDelDisponibleException;

public class Billetera {

    private int dineroDisponible;

    public Billetera(int dineroInicial){

        dineroDisponible = dineroInicial;
    }

    public void retirarDinero(int cantidad) {

        if(saldoSuficienteParaRetirar(cantidad))
            dineroDisponible -= cantidad;
    }

    private boolean saldoSuficienteParaRetirar(int cantidad) {

        if(dineroDisponible < cantidad)
            throw new JugadorQuiereUtilizarMasDineroDelDisponibleException();

        return true;
    }

    public int dineroRestante() {

        return dineroDisponible;
    }
}
