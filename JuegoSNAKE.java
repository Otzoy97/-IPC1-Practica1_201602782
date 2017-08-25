import java.util.Scanner;
//Ahora la matriz de snake comienza desde 0 de arriba hacia abajo y de izquierda a derecha
public class JuegoSNAKE {
    private static int temp;
    private static vectorHistorial historial[] = new vectorHistorial[5];
    private static short pointX, pointY;
    private static short cabeza1X, cabeza1Y;
    private static short aumentoSnake, punteoFruta, cuentaFruta; 
    private static vectorSF[] SnakeX;
    private static vectorSF[] SnakeY;
    private static vectorSF[][] Snake;
    static Scanner pantalla = new Scanner(System.in);
    
    public static void main(String[] args) {
        CLS.executeCLS();
        menuPrincipal();
    }
    
    private static void menuPrincipal(){
        String menuStr01;
        System.out.println("-------------------------------\n");
        System.out.println("         MENU PRINCIPAL        \n");
        System.out.println("-------------------------------");
        System.out.println("Presiona la letra asociada a la\nopción a la cual deseas acceder\ny presiona ENTER");
        System.out.println("-------------------------------");
        System.out.println("      [S] - INICIO");
        System.out.println("      [D] - DATOS");
        System.out.println("      [H] - HISTORIAL");
        System.out.println("      [I] - INSTRUCCIONES");
        System.out.println("      [E] - SALIR");
        System.out.println("-------------------------------");
        
        menuStr01 = pantalla.nextLine();
        seleccionMenu(menuStr01);      
    }
    
    private static void menuInstru(){
        System.out.println("¡Has que SNAKE crezca comiendo todas\nlas frutas que pueda!\n");
        System.out.println("---------------- CONTROLES ----------------");
        System.out.println("  Mueve a SNAKE utilizando estas teclas\n");
        System.out.println("         ARRIBA  "+(char)(26)+" [ W ]");
        System.out.println(" IZQUIERDA  "+(char)(26)+" [ A ][ S ][ D ]  "+(char)(27)+" DERECHA");
        System.out.println("                     "+(char)(24));
        System.out.println("                   ABAJO\n");
        System.out.println("------------------ ATAJOS -----------------");
        System.out.println("Cuando te encuentres dentro del juego\npuedes regresar al MENU PRINCIPAL con [E]\n");
        System.out.println("---------------- JUGABILIDAD ---------------");
        System.out.println("Presiona ENTER luego de presionar la letra\nasociada a la acción que desees ejecutar\n\n");
        menuPrincipal();
    }
    
    private static void menuInicio(){
        //Limpia la pantalla
        CLS.executeCLS();

        String inicioStr01;
        short inicioSht01, inicioSht02, inicioSht03;
        int i = historial.length;
        Scanner inicioScan = new Scanner(System.in);
        
        System.out.println("────────────── Inicio ──────────────");
        System.out.println("Ingresa tu nombre");
        inicioStr01 = inicioScan.nextLine();   
        System.out.println("────────────────X────────────────");
        System.out.println("Ingresa el ancho del tablero (10 - 45)");
        inicioSht01 = inicioScan.nextShort();
        System.out.println("────────────────Y────────────────");
        System.out.println("Ingresa el alto del tablero (10 - 45)");
        inicioSht02 = inicioScan.nextShort();
        System.out.println("────────────────S────────────────");
        System.out.println("Ingresa el tamaño inicial de SNAKE (3 - 9)");
        inicioSht03 = inicioScan.nextShort();
        
        cuentaFruta = (short)0;
        
        while (i!=0){
            temp = Math.abs(i-historial.length);
            if (historial[temp] == null){
                historial[temp] = new vectorHistorial(inicioSht01,inicioSht02,inicioSht03,inicioStr01,cuentaFruta);
                break;
            } else {
                i--;
            }
        }

        inicializarPantalla();
    }
        
    private static void menuDatos(){
        //Limpia la pantalla
        CLS.executeCLS();
        System.out.println("------------------------ DATOS ------------------------");
        System.out.println("         UNIVERSIDAD DE SAN CARLOS DE GUATEMALA        ");
        System.out.println("                 FACULTAD DE INGENIERÍA                ");
        System.out.println("             ESCUELA DE CIENCIAS Y SISTEMAS            ");
        System.out.println("     INTRODUCCIÓN A LA PROGRAMACIÓN Y COMPUTACIÓN 1    ");
        System.out.println("-------------------------------------------------------");
        System.out.println("     201602782 - SERGIO FERNANDO OTZOY GONZALEZ - E    ");
        System.out.println("-------------------------------------------------------\n\n");
        menuPrincipal();         
    }
    
    private static void menuHistorial(){
        CLS.executeCLS();
        int c = historial.length;
        System.out.println("---------------- HISTORIAL ----------------");
        System.out.println("|#| USUARIO || X || Y || SNAKE || PUNTEO ||");
        while (c!=0){
            if (historial[historial.length-c]!=null){
                System.out.print("|"+((historial.length-c)+1)+"| ");
                System.out.println(historial[historial.length-c].getUsuarioName()+" || "+historial[historial.length-c].getUsuarioX()
                        +" || "+historial[historial.length-c].getUsuarioY()+" || "+historial[historial.length-c].getUsuarioSnake()+" || "
                        +historial[historial.length-c].getUsuarioScore()+" ||");
                c--;
            } else {
                break;
            }
        }
        System.out.println("\n");
        menuPrincipal();
    }    

    private static void inicializarPantalla(){
        //Limpia la pantalla
        
        CLS.executeCLS();
        short largo;
        String d;
        aumentoSnake = 0;        
        largo = (short)(historial[temp].getUsuarioX()*historial[temp].getUsuarioY()*2/3); //importante para entender el try-catch de moverSnake()
        
        setSnake(new vectorSF[historial[temp].getUsuarioX()][historial[temp].getUsuarioY()]);
        setSnakeX(new vectorSF[largo]);//prepara la matriz en dónde alojaran los puntos en x del SNAKE
        setSnakeY(new vectorSF[largo]);//prepara la matriz en dónde alojaran los puntos en y del SNAKE  
        cabeza1X = (short)(historial[temp].getUsuarioX()/2);//prepara el punto inicial de la cabeza del SNAKE (x)
        cabeza1Y = 1;//prepara el punto inicial de la cabeza del SNAKE (x)
        //System.out.println(largo);<--Útil para depurar
        
        vectorSF.inicializarVector(historial[temp].getUsuarioX(),historial[temp].getUsuarioY(),Snake);//llena de ceros la matriz
        functionSnake.inicializarSnake(historial[temp].getUsuarioSnake(),SnakeX,SnakeY, cabeza1X, Snake);//marca la matriz con «1» en donde se encuentra la serpiente
        
        functionFruta.aparecerFruta(Snake);//deja la marca en la matriz, lista para imprimir, ingresa los valores para calcular el punteo en la clase funcionFruta
        functionFruta.centro(historial[temp].getUsuarioX(), historial[temp].getUsuarioY());//ingresa los valores para calcular el punteo en la clase funcionFruta
        
        punteoFruta = (short) functionFruta.calcularFruta();//recupera el valor del punteo
        functionFruta.bitacoraFruta(punteoFruta);//llena la Bitacora en el indice 0 con el punteo recién creado
        
        System.out.println(historial[temp].getUsuarioScore()+" || "+historial[temp].getUsuarioName());// Imprime el punteo actual junto con el nombre del usuario
        vectorSF.imprimirVector(historial[temp].getUsuarioX(),historial[temp].getUsuarioY(),Snake);//imprime la matriz
        functionFruta.imprimirBitacora();//...imprime la Bitacora ¬_¬
        
        d = pantalla.nextLine();
        mover(d);
    }

    private static void Pantalla(){
        String d;   
        System.out.println(historial[temp].getUsuarioScore()+" || "+historial[temp].getUsuarioName());// Imprime el punteo actual junto con el nombre del usuario
        vectorSF.imprimirVector(historial[temp].getUsuarioX(),historial[temp].getUsuarioY(),Snake);//imprime la matriz ya actualizada
        functionFruta.imprimirBitacora();//...imprime la Bitacora ¬_¬
        d = pantalla.nextLine();
        mover(d);
    }

    private static void mover(String d){
        short tamanoSnake;//,cabeza0X, cabeza0Y; 
        //cabeza0X = cabeza1X;//<--Se utilizó durante la depuración de las coordenadas de la cabeza
        //cabeza0Y = cabeza1Y;//<--Se utilizó durante la depuración de las coordenadas de la cabeza
        tamanoSnake = (short) (historial[temp].getUsuarioSnake()+aumentoSnake);
        switch (d){
            case "W"://arriba
            case "w":
                pointX = 0;
                pointY = -1;
                break;
            case "A":
            case "a"://izquierda
                pointX = -1;
                pointY = 0;
                break;
            case "S"://abajo
            case "s":
                pointX = 0;
                pointY = 1;
                break;
            case "D"://derecha
            case "d":
                pointX = 1;
                pointY = 0;
                break;
            case "E":
            case "e":
                regresarSnake((short)2);
                break;
            default:
                CLS.executeCLS();
                Pantalla();
                break;
        }       
        cabeza1X = (short)(cabeza1X + pointX);
        cabeza1Y = (short)(cabeza1Y + pointY);
        //System.out.println("cabeza_1-->"+"("+cabeza1X +", "+ cabeza1Y +")");//<--Se utilizó para depurar 
        //System.out.println("cabeza_0-->"+"("+cabeza0X +", "+ cabeza0Y +")");//<--Se utilizó para depurar
        CLS.executeCLS();//Limpia pantalla
        functionSnake.moverSnake(cabeza1X,cabeza1Y,tamanoSnake,SnakeX,SnakeY,Snake);
        Pantalla();        
    }
            
    private static void seleccionMenu(String opcion){
        switch(opcion){
            case "S":
            case "s":            
                CLS.executeCLS();
                menuInicio();
                break;
            case "D":
            case "d":
                CLS.executeCLS();
                menuDatos();
                break;
            case "H":
            case "h":
                CLS.executeCLS();
                menuHistorial();
                break;
            case "E":
            case "e":
                CLS.executeCLS();
                System.out.println("¡¡¡¡Gracias por Jugar!!!!");
                System.exit(0);
                break;
            case "I":
            case "i":
                CLS.executeCLS();
                menuInstru();
                break;
            default:
                CLS.executeCLS();
                System.out.println("«Debes ingresar cualquiera de las letras que");
                System.out.println("se encuentran encerradas entre corchetes»");
                menuPrincipal();
                break;
        }        
    }
    
    public static void crecerSnake(){
        short cuentaFruta0;
        cuentaFruta0 = punteoFruta;//guarda el valor anterior (el que ya se comío Snake)
        functionFruta.aparecerFruta(Snake);//deja la marca de la fruta en la matriz
        punteoFruta = (short) functionFruta.calcularFruta();//calcula el nuevo punteo según la coordenadas en las que apareció
        cuentaFruta = (short)(cuentaFruta + cuentaFruta0);//aumenta el valor del punteo con el valor que se comió
        historial[temp].setUsuarioScore(cuentaFruta);//Guarda el punteo en HISTORIAL
        aumentoSnake++;//aumenta el tamaño de Snake
        functionFruta.bitacoraFruta(punteoFruta);
    }
    
    public static void regresarSnake(short opcion){
        switch (opcion){
            case 0:
                CLS.executeCLS();
                System.out.println("¡Oh! parece que tu SNAKE quiso salir del marco\n");
                System.out.println("|#| USUARIO || PUNTEO ||");
                System.out.println("|"+(temp+1)+"| "+historial[temp].getUsuarioName()+" || "
                        +historial[temp].getUsuarioScore()+" ||");
                System.out.println("\n\nRegresarás automáticamente al MENU PRINCIPAL");
                CLS.executeSLEEP();
                CLS.executeCLS();
                menuPrincipal();
                break;
            case 1:
                CLS.executeCLS();
                System.out.println("¡Ups! parece que tu SNAKE se ha mordido ha si misma\n");
                System.out.println("|#| USUARIO || PUNTEO ||");
                System.out.println("|"+(temp+1)+"| "+historial[temp].getUsuarioName()+" || "
                        +historial[temp].getUsuarioScore()+" ||");
                System.out.println("\n\nRegresarás automáticamente al MENU PRINCIPAL");
                CLS.executeSLEEP();
                CLS.executeCLS();
                menuPrincipal();
                break;
            case 2:
                CLS.executeCLS();
                System.out.println("Regresarás al MENU PRINCIPAL en unos instantes\n\nMientras tanto observa tu punteo\n");
                System.out.println("|#| USUARIO || PUNTEO ||");
                System.out.println("|"+(temp+1)+"| "+historial[temp].getUsuarioName()+" || "
                        +historial[temp].getUsuarioScore()+" ||");
                CLS.executeSLEEP();
                CLS.executeCLS();
                menuPrincipal();
                break;   
            case 3:
                CLS.executeCLS();
                System.out.println("¡Felicitaciones!, tu SNAKE ha crecido tanto como puede\n");
                System.out.println("¡Disfruta de tu record!\n");
                System.out.println("|#| USUARIO || PUNTEO ||");
                System.out.println("|"+(temp+1)+"| "+historial[temp].getUsuarioName()+" || "
                        +historial[temp].getUsuarioScore()+" ||");
                System.out.println("\n\nRegresarás automáticamente al MENU PRINCIPAL");
                CLS.executeSLEEP();
                CLS.executeCLS();
                menuPrincipal();
                break;
        }
    }
    
    public static vectorSF[][] getSnake() {
        return Snake;
    }
    public static void setSnake(vectorSF[][] Snake) {
        JuegoSNAKE.Snake = Snake;
    }
    public static vectorSF[] getSnakeX() {
        return SnakeX;
    }
    public static void setSnakeX(vectorSF[] SnakeX) {
        JuegoSNAKE.SnakeX = SnakeX;
    }
    public static vectorSF[] getSnakeY() {
        return SnakeY;
    }
    public static void setSnakeY(vectorSF[] SnakeY) {
        JuegoSNAKE.SnakeY = SnakeY;
    }
}
