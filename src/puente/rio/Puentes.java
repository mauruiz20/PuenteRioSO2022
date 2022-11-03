package puente.rio;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio Ruiz
 * @author Benjamin Cascales
 * @author Fernando Tuquina
 */
public class Puentes {
    
    private int cnPasando;
    private int csPasando;
    private boolean banderaNorte;
    private boolean banderaSur;
    
    
    public Puentes() {
        this.cnPasando = 0;
        this.csPasando = 0;
        this.banderaNorte = true;
        this.banderaSur = false;
    }
    
    public synchronized void entrarNorte() {
        
        if (csPasando != 0) {
            try {
                wait();
                entrarNorte();
            } catch (InterruptedException ex) {
                Logger.getLogger(Puentes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        cnPasando++;
    }
    
    public synchronized void entrarSur() {
        
        if (cnPasando != 0) {
            try {
                wait();
                entrarSur();
            } catch (InterruptedException ex) {
                Logger.getLogger(Puentes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        csPasando++;
    }
    
    public synchronized void salirNorte() {
        
        cnPasando--;
        
        if (cnPasando == 0) {
            notifyAll();
        }
    }
    
    public synchronized void salirSur() {
        
        csPasando--;
        
        if (csPasando == 0) {
            notifyAll();
        }
    }
    
    public synchronized void cambiarBanderas() {
        if (banderaSur) {
            banderaSur = false;
            banderaNorte = true;
        } else {
            banderaSur = true;
            banderaNorte = false;
        }
        csPasando = 0;
        cnPasando = 0;
        notifyAll();
    }
    /*
    public int ocupado; // ocupado = 0: no - ocupado = 1: si 
    private int sentido; // sentido = -1: sur - sentido = 1: norte

    public Puentes() { 
        this.ocupado = 0;
    }
    
    public synchronized void obtenerPuente(int sentido) {
        
        if (this.ocupado == 0) {            
            this.sentido = sentido;
        }

        if (sentido != this.sentido) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Puentes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        this.ocupado++;        
    }
    
    public synchronized void liberarPuente() {
        
        this.ocupado--;
        if (this.ocupado == 0) {
            this.sentido *= -1; 
            notify();
        }
    }*/

    
}
