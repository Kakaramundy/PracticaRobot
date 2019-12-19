public class MyClass {
	public static void main(String[] args) {
		
		Tablero tablero = new Tablero(10,10,4);
		RobotPlayer jugador = new RobotPlayer(9,9);
		tablero.ColocarPlayer(jugador);
		while (!jugador.Muerto()) {
			tablero.MostrarTablero();
			tablero.MoverPlayer();
			tablero.AnalizarTablero();	
		}
		System.out.print("GAME OVER");	
	}
}
