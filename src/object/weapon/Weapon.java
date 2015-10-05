package object.weapon;

import org.jsfml.graphics.Sprite;

import entitee.player.Player;

public abstract class Weapon extends object.Object{
	private int damage;
	private int speed;
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
