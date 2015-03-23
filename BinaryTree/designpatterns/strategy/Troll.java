package strategy;

public class Troll extends Character{

	public Troll(){
		weapon = new BattleAxe();
	}
	
	@Override
	public void fight() {
		weapon.useWeapon();
		
	}

}
