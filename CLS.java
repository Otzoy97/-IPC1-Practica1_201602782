import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CLS {
    public static void CLS() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
    public static void executeCLS(){
        try {
            CLS.CLS();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(JuegoSNAKE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}