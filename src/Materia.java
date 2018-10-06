
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Materia extends Thread {
    
    public String nombre;
    public LinkedList<Tarea> colaTareas;
    
    //Contadores de tareas asignadas y completadas
    public int tareasAsignadas;
    public int tareasCompletadas;
    
    public int calificacion;
    public boolean aprobada;
    
    //Límites superior e inferior para el tiempo mínimo y máximo para crear una tarea aleatoriamente
    private int lowerTimeBound;
    private int upperTimeBound;
    
    private LinkedList<String> listado;
    
    public Materia(String nombre)
    {
        this.nombre = nombre;
        colaTareas = new LinkedList<>();
        
        tareasAsignadas = 0;
        tareasCompletadas = 0;
        
        calificacion = 0;
        lowerTimeBound = 8;
        upperTimeBound = 20;
    }
    
    /**
     * Aumenta el contador de tareas asignadas y agrega una nueva tarea a la cola
     */
    public void agregarTarea()
    {
        tareasAsignadas++;
        colaTareas.add(new Tarea(nombre));
    }
    
    /**
     * Quita una tarea de la cola y la devuelve
     * @return 
     */
    public Tarea removerTarea()
    {
        return colaTareas.poll();
    }
    
    /**
     * Realiza el cálculo de la calificación con base en tareas asignadas y completadas
     */
    public void calcularCalificacion()
    {
        double calif;
        calif = Math.round(((float)tareasCompletadas/(float)tareasAsignadas) * 10);
        this.calificacion = (int) calif;
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
            listado.add(task.descripcion + " (" + task.tiempo + ")");
        }
        String[] lista = new String[listado.size()];
        return listado.toArray(lista);
    }
    
    @Override
    public void run()
    {
        while(!TimeManagement.terminado)
        {
            try {
                //Crea una nueva tarea de forma aleatoria cada cierto tiempo, entre el mínimo y el máximo
                Thread.sleep(ThreadLocalRandom.current().nextInt(lowerTimeBound,upperTimeBound)*1000);
                agregarTarea();
            } catch (InterruptedException ex) {
                Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
