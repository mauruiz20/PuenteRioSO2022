package puente.rio;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio Ruiz
 */
public class Timer extends Thread{
    
    public Puentes puente;

    public Timer(Puentes puente) {
        this.puente = puente;
    }
    
    public void run() {
        while (true) {            
           
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.puente.cambiarBanderas();
        }
    }
}
