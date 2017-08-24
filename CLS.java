import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CLS {
    private static void CLS() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
    
    private static void sleep() throws InterruptedException {
        Thread.sleep(9500);
    }
    
    public static void executeSLEEP(){
        try {
            CLS.sleep();
        } catch (InterruptedException ex) {
            Logger.getLogger(JuegoSNAKE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void executeCLS(){
        try {
            CLS.CLS();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(JuegoSNAKE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}