import java.util.Scanner;
public class RobotPlayer extends Robot {

	
	RobotPlayer(int posX,int posY){
		posx=posX;
		posy=posY;
		behaviour = new NormalBehaviour();
		ataque=50;
	} 
	public int getValor() {
		return 3;
	}
	public void Eleccion() {
		 String eleccion;
	     Scanner teclado = new Scanner(System.in);
	     System.out.print("Introduzca su eleccion: ");
	     eleccion = teclado.nextLine();
	     if("a".equals(eleccion)) {
	    	 behaviour = new AgressiveBehaviour(); 
	     }else if("d".equals(eleccion)) {
	    	 behaviour = new DefensiveBehaviour(); 
	     }
	     else {
	    	 behaviour = new NormalBehaviour();
	     }   
	}
	
}
