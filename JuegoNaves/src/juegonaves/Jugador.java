package juegonaves;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Jugador  extends ObjetoJuego{
    
    public Jugador(Vector2D posicion, BufferedImage textura) {
        super(posicion, textura);
    }

    @Override
    public void update() {
    }
    @Override
    public void draw(Graphics g) {
        g.drawImage(textura,(int)posicion.getX(),(int)posicion.getY(),null);
    }

    
}
