package strategy;

public abstract class Character {
	protected WeaponBehavior weapon;
	
	public abstract void fight();

	public WeaponBehavior getWeapon() {
		return weapon;
	}

	public void setWeapon(WeaponBehavior weapon) {
		this.weapon = weapon;
	}
	
	
}
