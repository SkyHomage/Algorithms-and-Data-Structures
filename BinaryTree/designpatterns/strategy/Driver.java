package strategy;

public class Driver {
	public static void main(String[] args){
		Character p1 = new Knight();
		Character p2 = new Troll();
		
		p1.fight();
		p2.fight();
	}
}
