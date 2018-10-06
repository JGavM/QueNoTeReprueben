
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * Clase que administra el movimiento de etiquetas para simular animación
 * y movimiento
 */
public class Movimiento extends JComponent {
    static JLabel monini;
     static int numero = 1;
     
     //Se agrega el movimiento a una etiqueta
     Movimiento(JLabel monini){
      this.monini = monini;
      monini.setBounds(250,215,monini.getWidth() , monini.getHeight());
      monini.setLayout(null);
      
     }
     
     //Cada vez que se vuelva a pintar la imagen, se toma una imagen que correponde con el número de fotograma
     //siguiente
      public void paint(Graphics g){
          ImageIcon imagen =new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/Monini"+numero+".PNG")).getImage());  
          g.drawImage(imagen.getImage(), 250, 215, 101, 107, null);
      }
      
      //El movimiento sucede en un hilo independiente
      static Thread hilo = new Thread(){
       @Override
        public void run()
        {
            try
            {
                while(true)
                {
                    //Cada cierto tiempo, cambia a la imagen del siguiente fotograma y vuelve a pintar el objeto
                  numero++;
                  if(numero==4){
                    numero=1;
                  }
                  monini.repaint();                   
                  hilo.sleep(100);
                }
                
            } catch (java.lang.InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
      };
      
      /**
       * Método que inicia el hilo del movimiento
       */
      public static void moverMonini(){
     if(!hilo.isAlive())
    {
      hilo.start();
    }
    }
}
