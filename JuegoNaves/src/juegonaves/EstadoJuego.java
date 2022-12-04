package juegonaves;


import java.awt.Graphics;

public class EstadoJuego {
    private Jugador player;
    public EstadoJuego(){
    player = new Jugador(new Vector2D(100,500),Assets.player);
    }
    
    
    public void update(){
    player.update();
    }
    public void draw(Graphics g){
        player.draw(g);
    }
}
