import java.util.Scanner;

//Ahora la matriz de snake comienza desde 0 de arriba hacia abajo y de izquierda a derecha
public class JuegoSNAKE {
    public static int temp;
    public static vectorHistorial historial[] = new vectorHistorial[5];
    private static short pointX, pointY;
    private static short cabeza1X, cabeza1Y;
    private static short aumentoSnake, punteoFruta, cuentaFruta; 
    private static vectorSF[] SnakeX;
    private static vectorSF[] SnakeY;
    private static vectorSF[] Punteo;
    private static vectorSF Bitacora[] = new vectorSF[5];
    private static vectorSF[][] Snake;
    static Scanner pantalla = new Scanner(System.in);
    
    public static void main(String[] args) {
        menuPrincipal();
    }
    
    public static void menuPrincipal(){
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
        //Limpia la pantalla
        CLS.executeCLS();

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
        //Limpia la pantalla
        CLS.executeCLS();
        int c = historial.length;
        System.out.println("====================== Historial ======================");
        System.out.println("||-USUARIO-||-X-||-Y-||-Snake-||-Punteo-||");
        while (c!=0){
            if (historial[historial.length-c]!=null){
                System.out.print(((historial.length-c)+1)+"|-");
                System.out.println(historial[historial.length-c].getUsuarioName()+"-||-"+historial[historial.length-c].getUsuarioX()
                        +"-||-"+historial[historial.length-c].getUsuarioY()+"-||-"+historial[historial.length-c].getUsuarioSnake()+"-||-"
                        +historial[historial.length-c].getUsuarioScore());
                c--;
            } else {
                break;
            }
        }
        menuPrincipal();
    }    

    private static void inicializarPantalla(){
        //Limpia la pantalla
        CLS.executeCLS();
        aumentoSnake = 0;
        short largo;
        largo = (short)(historial[temp].getUsuarioX()*historial[temp].getUsuarioY()*2/3);

        System.out.println(largo);
        setSnakeX(new vectorSF[largo]);
        setSnakeY(new vectorSF[largo]);  

        cabeza1X = (short)(historial[temp].getUsuarioX()/2);
        cabeza1Y = (short)1;

        String d;
        setSnake( new vectorSF[historial[temp].getUsuarioX()][historial[temp].getUsuarioY()]);
        
        vectorSF.inicializarVector(historial[temp].getUsuarioX(),historial[temp].getUsuarioY(),Snake,(short)0);//llena de ceros la matriz
        functionSnake.inicializarSnake(historial[temp].getUsuarioSnake(),SnakeX,SnakeY, cabeza1X, Snake);
        
        functionFruta.aparecerFruta(Snake);//deja la marca en la matriz, lista para imprimir, ingresa los valores para calcular el punteo en la clase funcionFruta
        functionFruta.centro(historial[temp].getUsuarioX(), historial[temp].getUsuarioY());//ingresa los valores para calcular el punteo en la clase funcionFruta
        
        
        vectorSF.inicializarBitacora(Bitacora); //lena de ceros la bitacora, evitando errores al desplazar los registros.
        punteoFruta = functionFruta.calcularFruta();//recupera el valor del punteo
        
        functionFruta.bitacoraFruta(Bitacora,punteoFruta);//llena el espacio con el punteo recién creado
        System.out.println("algo1");
        //cuentaFruta += punteoFruta;//leva la cuenta
        
        vectorSF.imprimirVector(historial[temp].getUsuarioX(),historial[temp].getUsuarioY(),Snake);//imprime la matriz
        //
        d = pantalla.nextLine();
        mover(d);

        cabeza1Y++; //No recuerdo para que sirve esta asignación, pero al parecer funciona O.o
        Pantalla();  
        
    }

    public static void Pantalla(){
        //Limpia la pantalla
        CLS.executeCLS();
        String d;   
        System.out.print(historial[temp].getUsuarioScore());
        for(int i = 0; i < historial[temp].getUsuarioX()/2; i++){
            System.out.print(" ");
        }
        System.out.println(historial[temp].getUsuarioName());
        vectorSF.imprimirVector(historial[temp].getUsuarioX(),historial[temp].getUsuarioY(),Snake);//imprime la matriz
        functionFruta.imprimirBitacora(Bitacora);
        //System.out.println(historial[temp].getUsuarioX()/2);
        d = pantalla.nextLine();
        mover(d);
    }

    private static void mover(String d){
        //Limpia la pantalla
        CLS.executeCLS();
        short cabeza0X, cabeza0Y, tamanoSnake;
        cabeza0X = cabeza1X;
        cabeza0Y = cabeza1Y;
        tamanoSnake = (short) (historial[temp].getUsuarioSnake()+aumentoSnake);
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
            case "E":
                menuPrincipal();
            default:
                Pantalla();
        }       
        cabeza1X = (short)(cabeza1X + pointX);
        cabeza1Y = (short)(cabeza1Y + pointY);
        
        System.out.println("cabeza_1-->"+"("+cabeza1X +", "+ cabeza1Y +")");
        System.out.println("cabeza_0-->"+"("+cabeza0X +", "+ cabeza0Y +")");
        
        functionSnake.moverSnake(cabeza1X,cabeza1Y,tamanoSnake,SnakeX,SnakeY,Snake);
        Pantalla();        
    }
    
    public static void crecerSnake(){
        punteoFruta = functionFruta.calcularFruta();//calcula el nuevo punteo según la coordenadas en las que apareció
        functionFruta.aparecerFruta(Snake);
        
        functionFruta.bitacoraFruta(Bitacora, punteoFruta);//guarda el valor en la Bitacora
        cuentaFruta = (short)(cuentaFruta + punteoFruta);//aumenta el valor del punteo
        historial[temp].setUsuarioScore(cuentaFruta);//Guarda el punteo en HISTORIAL
        aumentoSnake++;
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
