public class functionFruta {
    private static float centrox = 0;
    private static float centroy = 0;
    private static short fruitx = 0;
    private static short fruity = 0;
    private static vectorSF Bitacorax[] = new vectorSF[5];
    private static vectorSF Bitacoray[] = new vectorSF[5];
    
    
    
    
    public static void aparecerFruta(vectorSF vector[][]){
        short frutax, frutay;
        frutax = (short)Math.floor(Math.random()*(vector.length));
        frutay = (short)Math.floor(Math.random()*(vector[0].length));
        if(vector[frutax][frutay].getSnake()==0){         
            vector[frutax][frutay].setSnake((short) 2);
        }else{
            aparecerFruta(vector);
        }
        fruitx = frutax;
        fruity = frutay;
    }
        
    public static void centro(short x, short y){
        if (x%2 == 0){
            centrox = (float)(x/2 + 0.5);
        }else{
            centrox = (float)Math.floor(x/2);
        }
        if (y%2 == 0){
            centroy = (float)(y/2 + 0.5);
        }else{
            centroy = (float)Math.floor(x/2);
        }
        vectorSF.inicializarBitacora(Bitacorax);
        vectorSF.inicializarBitacora(Bitacoray);
    }

    public static short calcularFruta(){
        short punteo;
        punteo = (short)((Math.abs(fruitx-centrox))+(Math.abs(fruity-centroy)));
        return punteo;
    }   
    
    public static void bitacoraFruta(vectorSF vector[], short punteo0){
        vector[4].setSnake((short)0);
        Bitacorax[4].setSnake((short)0);
        Bitacoray[4].setSnake((short)0);
        for (int n = vector.length-1; n > 0 ; n-- ){
            vector[n].setSnake(vector[n-1].getSnake());
            Bitacorax[n].setSnake(Bitacorax[n-1].getSnake());
            Bitacoray[n].setSnake(Bitacoray[n-1].getSnake());
        }
        vector[0].setSnake(punteo0);
        Bitacorax[0].setSnake(fruitx);
        Bitacoray[0].setSnake(fruity);
    }
    
    public static void imprimirBitacora(vectorSF vector[]){
        int c = vector.length;
        while (c!=0){
            if (vector[vector.length-c]!=null){
                System.out.print("Fruta " + (vector.length-c+1));
                System.out.println(" || "+"("+Bitacorax[vector.length-c]+", "+Bitacoray[vector.length-c]
                        +")"+" || "+vector[vector.length-c].getSnake());
                c--;
            } else {
                break;
            }
        }
    }
}
