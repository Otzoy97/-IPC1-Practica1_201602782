public class vectorHistorial {
    private short usuarioX;
    private short usuarioY;
    private short usuarioSnake;
    private String usuarioName;
    
    public vectorHistorial(){
        this.usuarioX=0;
        this.usuarioY=0;
        this.usuarioSnake=0;
        this.usuarioName="";
    }
    
    public vectorHistorial(short usuarioX, short usuarioY, short usuarioSnake, String usuarioName) {
        this.usuarioX = rangeUsuario(usuarioX,10,45);
        this.usuarioY = rangeUsuario(usuarioY,10,45);
        this.usuarioSnake = rangeUsuario(usuarioSnake,3,9);
        this.usuarioName = usuarioName;
    }
 
    public void setUsuarioX(short x){
        this.usuarioX = x;
    } 
    
    public short getUsuarioX(){
        return usuarioX;
    }
    
    public void setUsuarioY(short y){
        this.usuarioY = y;
    } 
    
    public short getUsuarioY(){
        return usuarioY;
    }
    
    public void setUsuarioSnake(short Snake){
        this.usuarioSnake = Snake;
    }
    
    public short getUsuarioSnake(){
        return usuarioSnake;
    }
    
    public void setUsuarioName(String Name){
        this.usuarioName = Name;
    }
    
    public String getUsuarioName(){
        return usuarioName;
    }
    
    public short rangeUsuario(short object, int min, int max){
        if (object < (short)min || object > (short) max) {
            object = (short)min;
            return object;
        } else {
            return object;
        }
    }
}