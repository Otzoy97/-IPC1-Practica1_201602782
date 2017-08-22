public class functionSnake {
    
    
  public void moverSnake(short movx, short movy, short tamano, short cabezax, short cabezay, short y, vectorSF vector[][]){
      //tamano = (short)(tamano - 1);  
      vector[cabezax][cabezay].setSnake((short)1);
      //dada ya una cabeza «movida»
        for (int i = 0 ; i < tamano ; i++){
            for (int j = 0 ; j < y ; j++){
                if(vector[j][i].getSnake()==1){
                    if(i==(cabezax+movx)){
                        vector[j][i].setSnake((short)0); 
                    } else {
                        if (){
                            
                        }
                        
                
                    
                        
                        
                
                        
                    }
                }
            }
        }
        //vector[][].setSnake((short)0);
        
        
    }
    
    public short[][] cabezaSnake(short x, short y){
        return null;
        
    }
    
    public static void inicializarSnake(short tamano, short inicialx, short y, vectorSF vector[][]){
        //short ENX/*, enY*/; 
        //ENX = (short)(x/2);
        //enY = (short)(y/2);
        //System.out.println("éxitSo");
        for (int h = 0; h < tamano; h++){
            //System.out.println(h);
            for (int i = 0 ; i < y  ; i++ ){
                //System.out.println(i);
                //for (int j = 0 ; j < x ; j++){
                    if (i == inicialx/*vector[j][i]==vector[ENX][1+i]*/){
                        vector[i][h+1].setSnake((short)1);
                        //vector[j][i+1] = new vectorSF((short)1);
                    }
                //}
            }
        }
        //vector[0][0].setSnake((short) 2); ejecutar un proceso para aleatorizar la posicion
        //de la fruta
        System.out.println("\033[32mSucessfull process: inicializarSnake");
    }
 /*   public void imprimirSnake(){
        for (int i = 0 ; i < y  ; i++ ){
            for (int j = 0 ; j < x; j++){
                vector[j][i].setSnake((short)1);
            }
        }
    }
   // public void extremos(short x, short y, vectorSF[][] extremos){
    //    extremos[x][y].setSnake((short)1);
   // }*/
}
