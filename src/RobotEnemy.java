
public class RobotEnemy extends Robot {


	RobotEnemy(int posX,int posY){
		posx=posX;
		posy=posY;
		behaviour = new NormalBehaviour();
	} 
	public int getValor() {
		return 2;
	}
}
