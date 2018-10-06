
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimeManagement extends Thread
{
    //Está terminado el juego?
        public static boolean terminado;
    
        //Tiempo de juego actual y máximo
	public int horas;
	public int tiempoMaximo;

	public TimeManagement()
	{
		horas = 0;
		tiempoMaximo = 480;
                terminado = false;
	}

	@Override
	public void run()
	{
            do
            {
                //Cada segundo se actualiza la interfaz gráfica de usuario
                Ventanas.juego.actualizarGUI();
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException ex) {
                    Logger.getLogger(TimeManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
                //...y se agrega una hora
                horas++;
            }while(horas<=tiempoMaximo);
            //Una vez se termina el tiempo, se indica la bandera de que el juego ha terminado y se resuelve el resultado
            terminado = true;
            Ventanas.juego.resolverResultado();
	}
}