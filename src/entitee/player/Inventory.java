package entitee.player;

import java.util.ArrayList;

import object.Key;
import object.equipment.Boot;
import object.equipment.Clothes;
import object.equipment.Glove;
import object.equipment.Helmet;
import object.equipment.Shield;
import object.potion.PotionLife;
import object.weapon.BeginnerBow;
import object.weapon.Weapon;

public class Inventory {
	private ArrayList<PotionLife> smallPotionLifes = new ArrayList<>();
	private ArrayList<PotionLife> mediumPotionLifes = new ArrayList<>();
	private ArrayList<PotionLife> largePotionLifes = new ArrayList<>();
	private ArrayList<Key> keys = new ArrayList<>();
	private Weapon weapon = new BeginnerBow();
	private Boot boot = null;
	private Clothes clothes = null;
	private Glove glove = null;
	private Helmet helmet = null;
	private Shield shield = null;
	
	public Inventory(){
		
	}
	
	public void addSmallPotionLife(PotionLife potionLife){
		smallPotionLifes.add(potionLife);
	}
	
	public void addMediumPotionLife(PotionLife potionLife){
		mediumPotionLifes.add(potionLife);
	}
	
	public void addLargePotionLife(PotionLife potionLife){
		largePotionLifes.add(potionLife);
	}
	
	public void addKey(Key key){
		keys.add(key);
	}
	
	public int getLifeBonusEquipment(){
		return 0;
	}
	
	public int getSpeedBonusEquipment(){
		return 0;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Boot getBoot() {
		return boot;
	}

	public void setBoot(Boot boot) {
		this.boot = boot;
	}

	public Clothes getClothes() {
		return clothes;
	}

	public void setClothes(Clothes clothes) {
		this.clothes = clothes;
	}

	public Glove getGlove() {
		return glove;
	}

	public void setGlove(Glove glove) {
		this.glove = glove;
	}

	public Helmet getHelmet() {
		return helmet;
	}

	public void setHelmet(Helmet helmet) {
		this.helmet = helmet;
	}

	public Shield getShield() {
		return shield;
	}

	public void setShield(Shield shield) {
		this.shield = shield;
	}
}
