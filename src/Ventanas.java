
/**
 * Clase de administración de las ventanas del juego
 * 
 */
public class Ventanas {

    //Se crea una única instancia de todas las ventanas del juego
    //Se crean desde el inicio para optimizar uso de recursos en tiempo de ejecución
    public static Juego juego;
    public static GameOver gameOver = new GameOver();
    public static Main inicio = new Main();
    public static Winner winner = new Winner();
    public static MiniJuego miniJuego = new MiniJuego();
    
    //Reproductor de sonido
    private static Audios play = new Audios();
    
    /**
     * Método que instancia y muestra la ventana de Juego, y reproduce el audio correspondiente
     */
    public static void mostrarJuego()
    {
        play.Parar();
        juego = new Juego();
        juego.setEnabled(true);
        juego.setVisible(true);
        play.Juego();
    }
    
    /**
     * Método que muestra la ventana de GameOver y reproduce el audio correspondiente
     */
    public static void mostrarGameOver()
    {
        play.Parar();
        gameOver.setEnabled(true);
        gameOver.setVisible(true);
        play.GameOver();
    }
    
    /**
     * Método que detiene sonidos si los hay, muestra la ventana de Inicio y reproduce el audio correspondiente
     */
    public static void mostrarInicio()
    {
        if(play.sonido!=null)
            play.Parar();
        inicio.setEnabled(true);
        inicio.setVisible(true);
        play.Principal();
    }
    
    /**
     * Método que muestra la ventana de Winner y reproduce el audio correspondiente
     */
    public static void mostrarWinner()
    {
        play.Parar();
        winner.setEnabled(true);
        winner.setVisible(true);
        play.Winner();
    }
    
    /**
     * Método que muestra la ventana de MiniJuego y reproduce el audio correspondiente
     */
    public static void mostrarMiniJuego()
    {
        play.Parar();
        miniJuego.setEnabled(true);
        miniJuego.setVisible(true);
        miniJuego.LoadingHilo();
        play.Juego();
    }
    

    
    
    
    
}
