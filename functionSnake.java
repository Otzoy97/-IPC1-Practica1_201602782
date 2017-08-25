public class functionSnake {   
    public static void moverSnake(short cabezax, short cabezay, short tamano, vectorSF vectorx[], vectorSF vectory[], vectorSF vector[][]){
        try{   //el tamaño del indice que se quiera modificar no existe, esta fuera de rango       
            vector[vectorx[tamano-1].getSnake()][vectory[tamano-1].getSnake()].setSnake((short)0);//vuelve el último valor de la cola 0
            //System.out.println(tamano+"-->"+"("+vectorx[tamano-1].getSnake()+", "+vectory[tamano-1].getSnake()+")");
            for (int n = tamano-1; n > 0 ; n-- ){
                vectorx[n].setSnake(vectorx[n-1].getSnake());
                vectory[n].setSnake(vectory[n-1].getSnake());
                vector[vectorx[n].getSnake()][vectory[n].getSnake()].setSnake((short)1);//
                //System.out.println(n+"-->"+"("+vectorx[n].getSnake()+", "+vectory[n].getSnake()+")");
            }
            colisionSnake(cabezax,cabezay,tamano,vectorx,vectory,vector);
            vectorx[0].setSnake(cabezax);
            vectory[0].setSnake(cabezay); 
            vector[cabezax][cabezay].setSnake((short)1);
        }catch (Exception ee){
            JuegoSNAKE.regresarSnake((short)3);
        }
    }
    
    public static void inicializarSnake(short tamano, vectorSF vectorx[], vectorSF vectory[], short inicialx, vectorSF vector[][]){
        for (int i = 0 ; i < tamano ; i++){
            vectorx[i] = new vectorSF(inicialx);
            vectory[i] = new vectorSF((short)(i+1));
            vector[vectorx[i].getSnake()][vectory[i].getSnake()].setSnake((short)1);
            //System.out.println(i+"-->"+"("+vectorx[i].getSnake()+", "+vectory[i].getSnake()+")");
        }
    }
    
    private static void colisionSnake(short cabezax, short cabezay, short tamano, vectorSF vectorx[], vectorSF vectory[], vectorSF vector[][]){
        //se sale del marco
        if (cabezax > vector.length-1 || cabezay > vector[0].length-1 || 
                cabezax < 0 || cabezay < 0){
                JuegoSNAKE.regresarSnake((short)0);
        }
        //se toca así misma
        for (int n = 3; n < tamano ; n++ ){
            if (cabezax == vectorx[n].getSnake() && cabezay == vectory[n].getSnake()){
                JuegoSNAKE.regresarSnake((short)1);
            }
        }
        //una excepción al momento en el que se dirije adentro de ella misma
        if (cabezax == vectorx[2].getSnake() && cabezay == vectory[2].getSnake()){
            System.out.println("¡Ten cuidado en tu próximo movimiento!");
        }
        //alcanza una frutita
        if (vector[cabezax][cabezay].getSnake() > 1){
            vectorx[tamano] = new vectorSF(vectorx[tamano-1].getSnake());
            vectory[tamano] = new vectorSF(vectory[tamano-1].getSnake());
            JuegoSNAKE.crecerSnake();
        }   
    }
}


