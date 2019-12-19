import java.util.Scanner;

public class Tablero {

	 private Elemento tablero[][];
	 private RobotEnemy enemigos[];
	 private RobotPlayer player;
	
	    Tablero( int alto,int ancho,int n_enemigos){
		tablero= new Elemento[alto][ancho];
		enemigos = new RobotEnemy[n_enemigos];
		CargarTablero(alto,ancho,n_enemigos);
		
	}
	private void CargarTablero(int alto,int ancho,int n_enemigos) {
		int cont_ene=0;
		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho ; j++) {
				int numeroaleatorio = (int)(Math.random()*2);
				Elemento obt;
				if((numeroaleatorio == 2) && (i !=0)) {
				    obt=new Obstaculo();
				    tablero[i][j]=obt;
				}
				else if((numeroaleatorio == 1) && (i !=0)) {
					if(cont_ene < n_enemigos) {
						RobotEnemy rob=new RobotEnemy(i,j);
						enemigos[cont_ene]=rob;
					    tablero[i][j]=rob;
					    cont_ene++;
					}
					else {
						obt=new Elemento();
					    tablero[i][j]=obt;
					}
				}
				else {
					 obt=new Elemento();
					    tablero[i][j]=obt;
				}	
			}
		}
		
	}
	public void ColocarPlayer(RobotPlayer obt) {
		player=obt;
	
	    tablero[player.getPosicionX()][player.getPosicionY()]=obt;
	}
	
	public void VaciarCasilla(int posx,int posy) {
		Elemento obt=new Elemento();
	    
		tablero[posx][posy]=obt;
	}
	public void AnalizarTablero() {
		for (int i = 0; i < enemigos.length; i++) {
			if(enemigos[i].getPosicionX() == player.getPosicionX()) {
				if(enemigos[i].getPosicionY() == player.getPosicionY()) {
					
					Batalla(enemigos[i],player);
				}
			}
			
		}
	}
	
	public void Batalla(Robot enemigo,RobotPlayer player) {
		while ( !player.Muerto() && !enemigo.Muerto() ) {
			System.out.println("Batalla");
			enemigo.Agresivo();
			player.Eleccion();
			System.out.print("Enemigo: ");
			enemigo.Accion(player);
			System.out.print("Jugador: ");
			player.Accion(enemigo);
			System.out.print("Vida Enemigo:");enemigo.VidaActual();
			System.out.print("Vida Jugador:");player.VidaActual();
		}
			
	}
	
	public void MostrarTablero() {
		Obstaculo obt=new Obstaculo();
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length ; j++) {
				System.out.print("[");
				if(tablero[i][j].getValor() == 1 ) {
					System.out.print("#");	
				}
				else if(tablero[i][j].getValor() == 2 ) {
					System.out.print("E");	
				}
				else if(tablero[i][j].getValor() == 3 ) {
					System.out.print("P");	
				}
				else if(tablero[i][j].getValor() == 0 ) {
					System.out.print(" ");	
				}
				System.out.print("]");
			}
			System.out.println();
			}
	}
	
	public void MoverPlayer() {
		String eleccion;
	     Scanner teclado = new Scanner(System.in);
	     System.out.print("Introduzca el movimiento: ");
	     eleccion = teclado.nextLine();
	     if("w".equals(eleccion)) {
	    	 
	    	 VaciarCasilla(player.getPosicionX(),player.getPosicionY());
	    	 player.setPosicionX(player.getPosicionX()-1);
	    	 ColocarPlayer(player);
	    	  
	    	 
	     }else if("a".equals(eleccion)) {
	    	 VaciarCasilla(player.getPosicionX(),player.getPosicionY());
	    	 player.setPosicionY(player.getPosicionY()-1);
	    	 ColocarPlayer(player);
	     }
	     else if("s".equals(eleccion)) {
	    	 VaciarCasilla(player.getPosicionX(),player.getPosicionY());
	    	 player.setPosicionX(player.getPosicionX()+1);
	    	 ColocarPlayer(player);
	     }
	     else if("d".equals(eleccion)) {
	    	 VaciarCasilla(player.getPosicionX(),player.getPosicionY());
	    	 player.setPosicionY(player.getPosicionY()+1);
	    	 ColocarPlayer(player);
	     }
	     else {
	    	 System.out.print("Orden incorrecta, los controles son: w,a,s,d ");
	     }   
	}
}
