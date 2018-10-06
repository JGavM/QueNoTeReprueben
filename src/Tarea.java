

import java.util.concurrent.ThreadLocalRandom;

public class Tarea {
    
    public String materia;
    public String descripcion;
    public int tiempo;
    
    //Límite máximo y mínimo para el índice que se tomará del catálogo de descripciones
    private int minBound;
    private int maxBound;
    
    //Catálogo de descripciones de tarea
    //Llenado del catálogo con todas las descripciones de las tareas
    private String[] catalogo= new String[] 
        {
            "Ensayo", //0
            "Ejercicios de libro",
            "Cantar para la clase", //2
            "Presentación oral",
            "Examen", // 4
            "Ejercicios de La Grabadora",
            "Hablar el inglés de Peña Nieto", //6
            "Sobrevivir en Australia",
            "Netflix and chill", //8
            "Ir al baño",
            "Ejercicios", //10
            "Proyecto",
            "Examen", //12
            "Calcular tiempo perdido",
            "Dividir la cuenta",    //14
            "Sacar cambio de las tortillas",
            "Integrar el pan",  //16
            "¿Pitágoras?",
            "Destruir una calculadora", //18
            "Sufrir en silencio",
            "Crear antimateria",    //20
            "Examen",
            "Desafiar la gravedad", //22
            "Descubrir una especie",
            "Descubrir un elemento",    //24
            "Disfrutar Breaking Bad",
            "Combustión espontánea",    //26
            "Comprar levadura",
            "Alabar a los carbohidratos",   //28
            "Dividir un átomo",
            "Dibujar a tu mascota",     //30
            "Crear un cómic",
            "Aprender teoría del color",    //32
            "Dibujar un autorretrato",
            "Comprar lápices",  //34
            "Aprender origami",
            "Apreciar el jazz improvisado", //36
            "La Hora Posmoderna",
            "Rapear con Mozart",    //38
            "Robar la Mona Lisa",
            "Pararse de manos", //40
            "Comer 10 tacos al pastor",
            "Hacer tabla rítmica",  //42
            "ABDOMINALES",  
            "Atrapar un Pokémon",   //44
            "Dar la vuelta al mundo",
            "Jugar STOP",   //46
            "Trepar un árbol",
            "Levantamiento de cerveza", //48
            "Beer pong...?",
            "Biografía de Anónimo", //50
            "Regresar en el tiempo",
            "Impedir la esclavitud", //52
            "Pedir autógrafo de John Lennon",
            "Fotografiar un mamut", //54
            "Matar a Hitler",
            "Entrevistar a Herodoto",   //56
            "Enamorar a un Habsburgo",
            "¡SOCIALISMO!", //58
            "Examen"
        };
    
    public Tarea(String materia)
    {

        this.materia = materia;
        //El tiempo para completar una tarea se elije de maera aleatoria
        tiempo = ThreadLocalRandom.current().nextInt(1, 6);
        //Se agrega la descripción de la tarea una vez se ha creado
        agregarDescripcion();
    }
    
    /**
     * Método usado de manera interna para elegir una descripción aleatoria para la descripción de una nueva actividad
     */
    private void agregarDescripcion()
    {
        //Según el nombre de la materia de la tarea, se elige cierto rango de descripciones del catálogo como posibles opciones
        switch(materia)
        {
            case "Inglés":
                minBound = 0;
                maxBound = 9;
                break;
            case "Matemáticas":
                minBound = 10;
                maxBound = 19;
                break;
            case "Química":
                minBound = 20;
                maxBound = 29;
                break;
            case "Artes":
                minBound = 30;
                maxBound = 39;
                break;
            case "Deportes":
                minBound = 40;
                maxBound = 49;
                break;
            case "Historia":
                minBound = 50;
                maxBound = 59;
                break;
        }
        //Se elige una descripción aleatoria del catálogo entre los índices indicados por la materia de la tarea
        this.descripcion = catalogo[ThreadLocalRandom.current().nextInt(minBound, maxBound+1)];
    }
}
