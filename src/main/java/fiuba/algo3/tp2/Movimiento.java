package fiuba.algo3.tp2;

public class Movimiento {

    private Direccion dir;

    public Movimiento(){

    }

    public void establecerDireccion(Direccion direc){
        this.dir = direc;
    }

    public Posicion calcularPosicionSiguiente(Posicion pos){
        return dir.desplazarPosicion(pos);
    }
}
