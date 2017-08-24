public class vectorSF {
    private short snake;

    public static void inicializarVector(short x, short y, vectorSF vector[][], short relleno){
        for (int i = 0; i < y; i++){
            for (int j = 0; j < x; j++){
                vector[Math.abs(j)][Math.abs(i)] = new vectorSF(relleno);
            }
        }
    }
    
    public static void inicializarBitacora(vectorSF vector[]){
        for (int i = 0; i < 5; i++){
            vector[i] = new vectorSF((short) 0);
        }
    }
    
    public static void imprimirVector(short x, short y, vectorSF vector[][]){
        for (int h = 0; h < x+2 ;h++ ){
            System.out.print("&");
        }
        System.out.println("");
        for (int i = 0; i < vector[0].length; i++){
            System.out.print("&");
            for (int j = 0; j < vector.length; j++) {
                if (vector[Math.abs(j)][Math.abs(i)].getSnake() == 0){
                    System.out.print(" ");
                }else{
                    if (vector[Math.abs(j)][Math.abs(i)].getSnake() == 1){
                    System.out.print("@");
                    }else{
                        if (vector[Math.abs(j)][Math.abs(i)].getSnake() > 1){
                        System.out.print((char)254);
                        }
                    }
                }
            }
            System.out.println("&");
        }
        
        for (int k = 0; k < x+2 ;k++ ){
            System.out.print("&");
        }
        System.out.println("");
    }

    public vectorSF() {
        this.snake = 0;
    }
    public vectorSF(short snake) {
        this.snake = snake;
    }   
    public short getSnake() {
        return snake;
    }
    public void setSnake(short snake) {
        this.snake = snake;
    }
}
