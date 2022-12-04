package juegonaves;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class JuegoNaves extends JFrame implements Runnable{
    
    public static final int WIDTH = 800, HEIGHT = 600;
    private Canvas canvas;
    private Thread thread;
    private boolean correr=false;
    private BufferStrategy bs;
    private Graphics g;
    private final int FPS=60;
    private double TiempoObjetivo = 1000000000/FPS;
    private double delta=0;
    private int MediaFPS = FPS;
    private EstadoJuego EstadoJuego;
    private KeyBoard KeyBoard;
    public JuegoNaves(){
    setTitle("Juego Espacial");
    setSize(WIDTH,HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLocationRelativeTo(null);
    setVisible(true);
    canvas= new Canvas();
    canvas.setPreferredSize(new Dimension(WIDTH,HEIGHT));
    canvas.setMaximumSize(new Dimension(WIDTH,HEIGHT));
    canvas.setMinimumSize(new Dimension(WIDTH,HEIGHT));
    canvas.setFocusable(true);
    add(canvas);
    KeyBoard = new KeyBoard();
    canvas.addKeyListener(KeyBoard);
    }
    
    public static void main(String[] args) {
        new JuegoNaves().start();
    }
    private void actualizacion(){
        KeyBoard.update();
        EstadoJuego.update();
    }
    private void dibujar(){
    bs= canvas.getBufferStrategy();
    
    if(bs==null){
    canvas.createBufferStrategy(3);
    return;
    }
    
    g= bs.getDrawGraphics();
    //Comienza
    g.setColor(Color.BLACK);
    g.fillRect(0,0,WIDTH,HEIGHT);
    EstadoJuego.draw(g);
    g.drawString(""+MediaFPS,100,100);
    //Termina
        g.dispose();
    bs.show();
    }
    
    private void init(){
        Assets.init();
        EstadoJuego = new EstadoJuego();
    }
    
    @Override
    public void run() {
        long now=0;
        long lastTime = System.nanoTime();
        int fotogramas=0;
        long time=0;
        init();
        while(correr){
            now= System.nanoTime();
            delta += (now-lastTime)/TiempoObjetivo;
            time += (now-lastTime);
            lastTime =now;
            
            if(delta<=1){
            actualizacion();
            dibujar();
            delta--;
            fotogramas++;
            
            }
            if(time>=1000000000){
                MediaFPS = fotogramas;
                fotogramas=0;
                time =0;
            }
        }
        stop();
    }
    private void start(){
    thread= new Thread(this);
    thread.start();
    correr=true;
    } 
private void stop(){
        try {
            thread.join();
            correr=false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
}
}
