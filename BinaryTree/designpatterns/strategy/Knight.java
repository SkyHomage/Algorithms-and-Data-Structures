package strategy;

public class Knight extends Character{

	public Knight(){
		weapon = new LongSword();
	}
	
	@Override
	public void fight(){
		weapon.useWeapon();
	}
	
}
