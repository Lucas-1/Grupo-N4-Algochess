package fiuba.algo3.tp2;

public abstract class Entidad {

    protected int puntos_de_vida;
    protected int costo;
    protected int danio;
    protected int color; // 1 jugador blanco ------  2 jugador negro


    public void atacar(Entidad una_entidad) {

        if(color == una_entidad.getColor())
            throw new NoPuedeAtacarEntidadDelMismoEquipo();

        una_entidad.sacarVida(danio);
    }

    public void sacarVida(int danio_recibido) {

        if(puntos_de_vida <= 0)
            throw new EntidadEstaMuertaException();

        puntos_de_vida -= danio_recibido;
    }

    public void recibirVida(int vida_recibida) {

        if(puntos_de_vida <= 0)
            throw new EntidadEstaMuertaException();

        puntos_de_vida += vida_recibida;
    }


    // getters
    public int getColor() { return color; }

    public int getCosto() { return costo; }

    public int getPuntosDeVida() { return puntos_de_vida;}

}
