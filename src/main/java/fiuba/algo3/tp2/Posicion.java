package fiuba.algo3.tp2;

public class Posicion {

    private int direccionX;
    private int direccionY;

    public Posicion (int dirX, int dirY){
        direccionX = dirX;
        direccionY = dirY;
    }

    public int getDireccionX() {
        return direccionX;
    }

    public void setDireccionX(int direccionX) {
        this.direccionX = direccionX;
    }

    public int getDireccionY() {
        return direccionY;
    }

    public void setDireccionY(int direccionY) {
        this.direccionY = direccionY;
    }
}
