public class functionSnake {   
    public static void moverSnake(short cabezax, short cabezay, short tamano, vectorSF vectorx[], vectorSF vectory[], vectorSF vector[][]){
        vector[vectorx[tamano-1].getSnake()][vectory[tamano-1].getSnake()].setSnake((short)0);//vuelve el último valor de la cola 0
        System.out.println(tamano+"-->"+"("+vectorx[tamano-1].getSnake()+", "+vectory[tamano-1].getSnake()+")");
        //colisionSnake(cabezax,cabezay,tamano,vectorx,vectory,vector);
        for (int n = tamano-1; n > 0 ; n-- ){
            vectorx[n].setSnake(vectorx[n-1].getSnake());
            vectory[n].setSnake(vectory[n-1].getSnake());
            vector[vectorx[n].getSnake()][vectory[n].getSnake()].setSnake((short)1);//
            System.out.println(n+"-->"+"("+vectorx[n].getSnake()+", "+vectory[n].getSnake()+")");
        }
        colisionSnake(cabezax,cabezay,tamano,vectorx,vectory,vector);
        vectorx[0].setSnake(cabezax);
        vectory[0].setSnake(cabezay); 
        vector[cabezax][cabezay].setSnake((short)1);
    }
    
    public static void inicializarSnake(short tamano, vectorSF vectorx[], vectorSF vectory[], short inicialx, vectorSF vector[][]){
        System.out.println("\033[32mSucessfull enter: inicializarSnake");
        for (int i = 0 ; i < tamano ; i++){
            vectorx[i] = new vectorSF(inicialx);//.setSnake(inicialx);
            vectory[i] = new vectorSF((short)(i+1));
            vector[vectorx[i].getSnake()][vectory[i].getSnake()].setSnake((short)1);
            System.out.println(i+"-->"+"("+vectorx[i].getSnake()+", "+vectory[i].getSnake()+")");
        }
        System.out.println("\033[32mSucessfull process: inicializarSnake");
    }
    
    private static void colisionSnake(short cabezax, short cabezay, short tamano, vectorSF vectorx[], vectorSF vectory[], vectorSF vector[][]){
        //se sale del marco
        if (cabezax > vector.length-1 || cabezay > vector[0].length-1 || 
                cabezax < 0 || cabezay < 0){
            JuegoSNAKE.menuPrincipal();
        }
        //se toca así misma
        for (int n = 3; n < tamano ; n++ ){
            if (cabezax == vectorx[n].getSnake() && cabezay == vectory[n].getSnake()){
                JuegoSNAKE.menuPrincipal();
            }
        }
        if (cabezax == vectorx[2].getSnake() && cabezay == vectory[2].getSnake()){
            System.out.println("¡Cuidado con tu próximo movimiento!");
        }
        if (vector[cabezax][cabezay].getSnake() > 1){
            vectorx[tamano] = new vectorSF(vectorx[tamano-1].getSnake());//setSnake(vectorx[tamano-1].getSnake());
            vectory[tamano] = new vectorSF(vectory[tamano-1].getSnake());//setSnake(vectory[tamano-1].getSnake());
            JuegoSNAKE.crecerSnake();
        }
        
    }
}


