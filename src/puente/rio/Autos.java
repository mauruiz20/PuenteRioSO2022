package puente.rio;

/**
 *
 * @author Mauricio Ruiz
 * @author Benjamin Cascales
 * @author Fernando Tuquina
 */
public class Autos extends Thread {
    
    private Puentes puente;
    private int auto;
    private String sentido;
    private String color;
    public static String[] colores = {"\u001B[31m", "\u001B[32m", "\u001B[33m", "\u001B[34m", "\u001B[35m", "\u001B[36m", 
                                        "\u001B[37m", "\u001B[93m","\u001B[0m"};

    public Autos(Puentes puente, int auto) {
        this.puente = puente;
        this.auto = auto;
        //this.color = colores[auto % 9];
        if((int) (Math.random() * 2) == 0) {
            this.sentido = "Sur";
            this.color = colores[1];
        } else {
            this.sentido = "Norte";
            this.color = colores[2];
        }
    }
    public void run() {
        
        if (this.sentido == "Norte") {
            
            this.puente.entrarNorte();
            System.out.println(this.color + "Auto " + this.auto + " entró al puente en el sentido " + this.sentido); 
            
            try {
                sleep((long) (Math.random() * 5000)); // Demora entre 0 y 5 segundos
            } catch (InterruptedException ex) {
            }
            
            System.out.println(this.color + "Auto " + this.auto + " salió del puente en el sentido " + this.sentido);
            this.puente.salirNorte();
        } else {
            this.puente.entrarSur();
            System.out.println(this.color + "Auto " + this.auto + " entró al puente en el sentido " + this.sentido); 
            
            try {
                sleep((long) (Math.random() * 5000)); // Demora entre 0 y 5 segundos
            } catch (InterruptedException ex) {
            }
            
            System.out.println(this.color + "Auto " + this.auto + " salió del puente en el sentido " + this.sentido);
            this.puente.salirSur();
        }
    }
    /*
    public void run() {
        
        while (true) {
            
            this.puente.obtenerPuente(this.sentido); 
            System.out.print(puente.ocupado + " " + this.color + "Auto " + this.auto + " entró al puente en el sentido ");            
            
            if (this.sentido == 1) {
                System.out.println("Norte");
            } else {
                System.out.println("Sur");
            }
            
            
            try {
                sleep((long) (Math.random() * 5000)); // Demora entre 0 y 5 segundos
            } catch (InterruptedException ex) {
            }
            
            this.puente.liberarPuente();
            System.out.print(puente.ocupado + " " + this.color + "Auto " + this.auto + " salió del puente en el sentido ");
            
            
            if (this.sentido == 1) {
                System.out.println("Norte");
            } else {
                System.out.println("Sur");
            }
            
            try {
                sleep((long) (Math.random() * 5000)); // Demora entre 0 y 5 segundos
            } catch (InterruptedException ex) {
            }
        }
    }
    */
}
