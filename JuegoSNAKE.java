import java.util.Scanner;
//import java.io.*;
//import java.awt.image.BufferStrategy;
//import java.util.InputMismatchException;
//Ahora la matriz de snake comienza desde 0 de arriba hacia abajo y de izquierda a derecha
public class JuegoSNAKE {
    public static int temp;
    public static vectorHistorial historial[] = new vectorHistorial[5];
    private static short pointX, pointY;
    protected static vectorSF[][] Snake;
    static Scanner pantalla = new Scanner(System.in);
    
    public static void main(String[] args) {
        menuPrincipal();
    }
    
    private static void menuPrincipal(){
        Scanner menuScan = new Scanner(System.in);
        String menuStr01;

        System.out.println("[S] - INICIO");
        System.out.println("[D] - DATOS");
        System.out.println("[H] - HISTORIAL");
        System.out.println("[E] - SALIR");
        menuStr01 = menuScan.nextLine();
            
        switch(menuStr01){
            case "S":
                menuInicio();
                break;
            case "D":
                menuDatos();
                break;
            case "H":
                menuHistorial();
                break;
            case "E":
                System.exit(0);
                break;
            default:
                menuPrincipal();
                break;
        }
           
    }
    
    private static void menuInicio(){
        String inicioStr01;
        short inicioSht01, inicioSht02, inicioSht03;
        int i = historial.length;
        Scanner inicioScan = new Scanner(System.in);
        
        System.out.println("========== Inicio ==========");
        System.out.println("Ingrese su nombre");
        inicioStr01 = inicioScan.nextLine();   
        System.out.println("Ingrese tamaño X del tablero");
        inicioSht01 = inicioScan.nextShort();
        System.out.println("Ingrese tamaño Y del tablero");
        inicioSht02 = inicioScan.nextShort();
        System.out.println("Ingrese tamaño inicial de Snake");
        inicioSht03 = inicioScan.nextShort();
        
        while (i!=0){
            temp = Math.abs(i-historial.length);
            if (historial[temp] == null){
                historial[temp] = new vectorHistorial(inicioSht01,inicioSht02,inicioSht03,inicioStr01);
                break;
            } else {
                i--;
            }
        }

        inicializarPantalla();
    }
        
    private static void menuDatos(){
        System.out.println("====================== Datos ======================");
        System.out.println("||UNIVERSIDAD DE SAN CARLOS DE GUATEMALA         ||");
        System.out.println("||FACULTAD DE INGENIERÍA                         ||");
        System.out.println("||ESCUELA DE CIENCIAS Y SISTEMAS                 ||");
        System.out.println("||INTRODUCCIÓN A LA PROGRAMACIÓN Y COMPUTACIÓN 1 ||");
        System.out.println("||-----------------------------------------------||");
        System.out.println("||201602782 - SERGIO FERNANDO OTZOY GONZALEZ - E ||");
        System.out.println("===================================================");
        menuPrincipal();
    }
    
    private static void menuHistorial(){
        int c = historial.length;
        System.out.println("====================== Historial ======================");
        System.out.println("||-USUARIO-||-X-||-Y-||-Snake-||-Punteo-||");
        while (c!=0){
            if (historial[historial.length-c]!=null){
                System.out.print(((historial.length-c)+1)+"|-");
                System.out.println(historial[historial.length-c].getUsuarioName()+"-||-"+historial[historial.length-c].getUsuarioX()+"-||-"+historial[historial.length-c].getUsuarioY()+"-||-"+historial[historial.length-c].getUsuarioSnake()+"-||");
                c--;
            } else {
                break;
            }
        }
        menuPrincipal();
    }    

    private static void inicializarPantalla(){
        System.out.println("\033[32mSucessfull proced: inicializarPantalla");
        pointX = (short)(historial[temp].getUsuarioX()/2);
        pointY = (short)(1); 
        //String d;
        setSnake( new vectorSF[historial[temp].getUsuarioX()][historial[temp].getUsuarioY()]);
        //vectorSF Snake[][] = new vector
        //Snake[historial[temp].getUsuarioX()][historial[temp].getUsuarioY()] = new vectorSF[5][8];
              
        vectorSF.inicializarVector(historial[temp].getUsuarioX(),historial[temp].getUsuarioY(),Snake,(short)0);//llena de ceros la matriz
        System.out.println("\033[32mSucessfull return to: inicializarPantalla");
        functionSnake.inicializarSnake(historial[temp].getUsuarioSnake(), pointX, historial[temp].getUsuarioY(), Snake);
        System.out.println("\033[32mSucessfull return to: inicializarPantalla");
        vectorSF.imprimirVector(historial[temp].getUsuarioX(),historial[temp].getUsuarioY(),Snake);//imprime la matriz
        System.out.println("\033[32mSucessfull return to: inicializarPantalla");
        
        //va esperar la entrada del usuario
        //va a ejecutar algún metodo para mover a la serpiente
        System.out.println("La cabeza se encuentra en: ( "+pointX +" , "+ pointY+ " )");
        Pantalla();    
        
    }

    private static void Pantalla(){
        System.out.println("\033[32mSucessfull proced: Pantalla");
        String d;
        
        vectorSF.imprimirVector(historial[temp].getUsuarioX(),historial[temp].getUsuarioY(),Snake);//imprime la matriz
        System.out.println("\033[32mSucessfull return to: Pantalla");
    }

    public static void mover(String d){
        switch (d){
            case "W"://arriba
                pointX = 0;
                pointY = -1;
                break;
            case "A"://izquierda
                pointX = -1;
                pointY = 0;
                break;
            case "S"://abajo
                pointX = 0;
                pointY = 1;
                break;
            case "D"://derecha
                pointX = 1;
                pointY = 0;
                break;
        }
    }
    
    public static vectorSF[][] getSnake() {
        return Snake;
    }

    public static void setSnake(vectorSF[][] Snake) {
        JuegoSNAKE.Snake = Snake;
    }
    
}
