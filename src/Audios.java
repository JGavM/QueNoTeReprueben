import java.applet.AudioClip;

/**
 * Clase que maneja todos los audios dentro del juego, por medio de AudioClips
 * para sonidos de corta y larga duración
 */
public class Audios {
    AudioClip sonido,independientes;
    
    /**
     * Ventana principal
     */
    public void Principal(){
    sonido=java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Main.wav"));
    sonido.loop();
    }
    
    /**
     * Sonido para completar tarea
     */
    public void CompletarTarea(){
    independientes=java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Complete.wav"));
    independientes.play();
    }
    
    /**
     * Sonido para ventana GameOver
     */
    public void GameOver(){
    sonido=java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/GameOver.wav"));
    sonido.loop();
    }
    
    /**
     * Sonido para ventana Winner
     */
    public void Winner(){
    sonido=java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Winner.wav"));
    sonido.play();
    }
    
    /**
     * Sonido para ventana Juego
     */
    public void Juego(){
    sonido=java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Game.wav"));
    sonido.loop();
    }
    
    /**
     * Detiene el AudioClip sonido de la instancia
     */
    public void Parar(){
    sonido.stop();
    }
    
    
    
}
