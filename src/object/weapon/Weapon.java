package object.weapon;

import org.jsfml.graphics.Sprite;

import entitee.player.Player;

/**
 * Classe qui represente un objet arme.
 * @author Ludov_000
 *
 */
public abstract class Weapon extends object.Object{
	/**
	 * Le point de degat causé par l'arme. 
	 */
	private int damage;
	/**
	 * La vitesse des munitions de l'arme.
	 */
	private int speed;
	/**
	 * L'intervalle de temps entre deux attaques de l'arme.
	 */
	private float intervalShoot;
	
	public Weapon(Sprite sprite, String name, int damage, int speed, float intervalShoot){
		super(sprite, name);
		this.damage = damage;
		this.speed=speed;
		this.intervalShoot=intervalShoot;
	}
	
	@Override
	public void pickUp() {
		// TODO Auto-generated method stub
		Player.getInstance().getInventory().setWeapon(this);
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public float getIntervalShoot() {
		return intervalShoot;
	}

	public void setIntervalShoot(float intervalShoot) {
		this.intervalShoot = intervalShoot;
	}
}
