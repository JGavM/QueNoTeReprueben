
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que maneja las acciones del jugador y muestra su estado en tiempo de ejecución
 * dentro de un hilo independiente
 * 
 */
public class Estudiante extends Thread {
    
    //Reproduce sonido de Tarea terminada
    private Audios play;
    
    public boolean isWorking;
    
    //Valores manejados dentro del juego
    public int estres;
    public int vidaSocial;
    
    //Tiene su propio elemento gráfico que despliega tareas, tiempos y materias
    public LinkedList<Tarea> colaTareas;
    
    //Cola de tareas presentada en formato para agregarse al elemento gráfico
    private LinkedList<String> listado;
    
    //Variable que guarda la primera tarea en un momento dado
    private static Tarea tareaActual;
    
    public Estudiante()
    {
        play = new Audios();
        
        estres = 0;
        vidaSocial = 100;
        isWorking = false;
        colaTareas = new LinkedList<>();
    }
    
    /**
     * Método que prepara la lista de actividades de la cola de tareas de la instancia
     * de estudiante en formato de presentación para la interfaz gráfica.
     * 
     * Regresa un arreglo de Strings con cada una de las tareas
     * @return
     */
    public String[] listaActividades()
    {
        listado = new LinkedList<>();
        for(Tarea task : colaTareas)
        {
            listado.add(task.descripcion + " (" + task.tiempo + ")" + " - " + task.materia);
        }
        String[] lista = new String[listado.size()];
        return listado.toArray(lista);
    }
    
    @Override
    public void run()
    {
        //Mientras no haya acabado el tiempo
        while(!TimeManagement.terminado)
        {
            //Mensaje de debug
            System.out.println("Estudiante corriendo");
            if(vidaSocial >= 10 || estres <= 90) //Si el estudiante puede trabajar según las reglaas del juego
            {
                if(!colaTareas.isEmpty()) //Si hay tareas pendientes
                {
                    System.out.println("Estudiante trabajando . . .");
                    isWorking = true;
                    //Copia la primera tarea de la fila en un atributo
                    tareaActual = colaTareas.peek();
                    try {
                        //Espera a que termine el tiempo programado para la tarea
                        Thread.sleep(tareaActual.tiempo * 1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(TimeManagement.terminado)
                    {
                        //Terminar la ejecución del hilo si el tiempo de juego terminó
                        //antes de completar una tarea
                        break;
                    }
                    //Remover la tarea de la cola
                    colaTareas.poll();
                    //Reproducir sonido
                    play.CompletarTarea();
                    isWorking = false;
                    for(int i=0;i<6;i++)
                    {
                        //Buscar la materia que corresponde a la materia y aumentar
                        //el contador de tareas terminadas
                        if(Ventanas.juego.materias[i].nombre.equals(tareaActual.materia))
                        {
                            Ventanas.juego.materias[i].tareasCompletadas++;
                            break;
                        }
                    }
                }
            }
        }
    }
}
