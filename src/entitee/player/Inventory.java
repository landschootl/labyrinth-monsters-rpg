package entitee.player;

import java.util.ArrayList;

import object.Key;
import object.equipment.Boot;
import object.equipment.Clothes;
import object.equipment.Equipment;
import object.equipment.Glove;
import object.equipment.Helmet;
import object.equipment.Shield;
import object.potion.PotionLife;
import object.weapon.BeginnerBow;
import object.weapon.Weapon;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Text;

import console.Console;

public class Inventory {
	private ArrayList<PotionLife> smallPotionLifes = new ArrayList<>();
	private ArrayList<PotionLife> mediumPotionLifes = new ArrayList<>();
	private ArrayList<PotionLife> largePotionLifes = new ArrayList<>();
	private ArrayList<Key> keys = new ArrayList<>();
	private Weapon weapon = new BeginnerBow();
	private Equipment boot = null;
	private Equipment clothes = null;
	private Equipment glove = null;
	private Equipment helmet = null;
	private Equipment shield = null;
	
	public Inventory(){
		
	}
	
	public void addKey(Key key){
		keys.add(key);
	}
	
	public boolean useKey(){
		if(keys.isEmpty()){
			return false;
		} else {
			Console.getInstance().addText(keys.get(0).getName()+" utilisé !", Text.REGULAR, Color.BLACK);
			keys.remove(0);
			return true;
		}
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
	
	public int getLifeBonusEquipment(){
		int bonus = 0;
		if(clothes!=null)
			bonus+=clothes.getBonus();
		if(helmet!=null)
			bonus+=helmet.getBonus();
		if(shield!=null)
			bonus+=shield.getBonus();
		if(glove!=null)
			bonus+=glove.getBonus();
		return bonus;
	}
	
	public int getSpeedBonusEquipment(){
		if(boot==null)
			return 0;
		else
			return boot.getBonus();
	}
	
	public void useSmallPotion() {
		usePotion(smallPotionLifes);
	}
	
	public void useMediumPotion() {
		usePotion(mediumPotionLifes);
	}
	
	public void useLargePotion() {
		usePotion(largePotionLifes);
	}
	
	public void usePotion(ArrayList<PotionLife> array) {
		if(array.isEmpty()){
			Console.getInstance().addText("Vous ne possédez pas de potion !", Text.REGULAR, Color.RED);
		} else {
			if(array.get(0).action()){
				Console.getInstance().addText(array.get(0).getName()+" utilisé !", Text.REGULAR, Color.BLACK);
				array.remove(0);
			}
		}
	}
	
	public float getIntervalShootWeapon(){
		if(weapon!=null)
			return weapon.getIntervalShoot();
		return 0.0f;
	}
	
	public int getSpeedShootWeapon(){
		if(weapon!=null)
			return weapon.getSpeed();
		return 0;
	}
	
	public int getDamageShootWeapon(){
		if(weapon!=null)
			return weapon.getDamage();
		return 0;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Equipment getBoot() {
		return boot;
	}

	public void setBoot(Boot boot) {
		this.boot = boot;
	}

	public Equipment getClothes() {
		return clothes;
	}

	public void setClothes(Clothes clothes) {
		this.clothes = clothes;
	}

	public Equipment getGlove() {
		return glove;
	}

	public void setGlove(Glove glove) {
		this.glove = glove;
	}

	public Equipment getHelmet() {
		return helmet;
	}

	public void setHelmet(Helmet helmet) {
		this.helmet = helmet;
	}

	public Equipment getShield() {
		return shield;
	}

	public void setShield(Shield shield) {
		this.shield = shield;
	}
}
