package juegonaves;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class ObjetoJuego {
    protected BufferedImage textura;
    protected Vector2D posicion;

    public ObjetoJuego(Vector2D posicion,BufferedImage textura) {
        this.posicion = posicion;
        this.textura = textura;
    }
    public abstract void update();
    public abstract void draw(Graphics g);

    public Vector2D getPosicion() {
        return posicion;
    }

    public void setPosicion(Vector2D posicion) {
        this.posicion = posicion;
    }
}
