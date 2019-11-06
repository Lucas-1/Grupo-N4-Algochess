package fiuba.algo3.tp2;

public abstract class Entidad {

    protected int puntos_de_vida;
    protected int costo;
    protected int danio;
    protected int color; // 1 jugador blanco ----  2 jugador negro.


    // getters
    public int getColor() { return color; }

    public int getCosto() {
        return costo;
    }
}
