
public abstract class Robot extends Elemento {
	protected Behaviour behaviour;
	protected int vida=100;
	protected int ataque=25;
	protected int defensa=25;
	
	public void Move() {
		behaviour.moveCommand();
	}
	public void Accion(Robot rival) {

		Move();
		if(behaviour instanceof AgressiveBehaviour ) {
			rival.BajarVida(ataque);
			
		}
		else if(behaviour instanceof DefensiveBehaviour) {
			vida+=defensa;
		}
	
	}
	public void VidaActual() {
		System.out.println(vida);	
	}
	public void BajarVida(int daño) {
		vida-=daño;
	}
	
	public void Agresivo() {
		behaviour=new AgressiveBehaviour();
	}
	public boolean Muerto() {
		if( vida > 0) {
			 return false;	
		}
		else {
			return true;
		}		
	}
}
