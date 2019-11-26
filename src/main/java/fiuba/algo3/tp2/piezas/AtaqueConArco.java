package fiuba.algo3.tp2.piezas;

public class AtaqueConArco implements TipoDeAtaque {
    private final int DANIO_JINETE = 15;

    public AtaqueConArco() {
    }

    @Override
    public void atacar(Pieza pieza) {
        pieza.perderVida(this.DANIO_JINETE);
    }
}
