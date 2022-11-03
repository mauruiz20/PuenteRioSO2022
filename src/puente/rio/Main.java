package puente.rio;

/**
 *
 * @author Mauricio Ruiz
 * @author Benjamin Cascales
 * @author Fernando Tuquina
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Puentes p = new Puentes();
        
        for (int i = 1; i <= 10; i++) {
            Autos au = new Autos(p, i);
            
            au.start();
        }
        
    }
    
    
}
