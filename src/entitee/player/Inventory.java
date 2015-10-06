package entitee.player;

import java.util.ArrayList;

import object.Key;
import object.Object;
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
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;

import resource.Texte;
import console.Console;

/**
 * Inventory of the player.
 * @author Ludov_000
 *
 */
public class Inventory {
	// Logique
	/**
	 * Small potions.
	 */
	private ArrayList<PotionLife> smallPotionLifes = new ArrayList<>();
	/**
	 * Middle potions.
	 */
	private ArrayList<PotionLife> mediumPotionLifes = new ArrayList<>();
	/**
	 * Big potions.
	 */
	private ArrayList<PotionLife> largePotionLifes = new ArrayList<>();
	/**
	 * Keys.
	 */
	private ArrayList<Object> keys = new ArrayList<>();
	/**
	 * Weapon.
	 */
	private Weapon weapon;
	/**
	 * Boots.
	 */
	private Equipment boot = null;
	/**
	 * Armor.
	 */
	private Equipment clothes = null;
	/**
	 * Gloves.
	 */
	private Equipment glove = null;
	/**
	 * helmets.
	 */
	private Equipment helmet = null;
	/**
	 * shield.
	 */
	private Equipment shield = null;
	
	
	private RectangleShape backgroundContour;
	private RectangleShape[][] backgroundCase = new RectangleShape[5][3];
	
	public Inventory(){
		initBackground();
		setWeapon(new BeginnerBow());
	}
	
	/**
	 * initialize inventory background.
	 */
	public void initBackground(){
		backgroundContour = new RectangleShape(new Vector2f(270,160));
		backgroundContour.setOutlineThickness(10);
		backgroundContour.setOutlineColor(new Color(97,56,11));
		backgroundContour.setPosition(new Vector2f(360,650));
		for(int i=0; i<5; i++){
			for(int j=0; j<3; j++){
				backgroundCase[i][j] = new RectangleShape(new Vector2f(54,54));
				backgroundCase[i][j].setFillColor(new Color(Color.WHITE, 300));
				backgroundCase[i][j].setOutlineThickness(2);
				backgroundCase[i][j].setOutlineColor(new Color(97,56,11));
				backgroundCase[i][j].setPosition(new Vector2f(360+i*54,650+j*54));
			}
		}
	}
	
	/**
	 * Show the graphics elements in the window of the console.
	 * @param window : poiter on the window of the application.
	 */
	public void draw(RenderWindow window){
		window.draw(backgroundContour);
		for(int i=0; i<5; i++){
			for(int j=0; j<3; j++){
				window.draw(backgroundCase[i][j]);
			}
		}
		drawObject(window, boot);
		drawObject(window, clothes);
		drawObject(window, glove);
		drawObject(window, weapon);
		drawObject(window, helmet);
		drawObject(window, shield);
		if(!smallPotionLifes.isEmpty()) drawObjectList(window, smallPotionLifes.get(0), smallPotionLifes.size());
		if(!mediumPotionLifes.isEmpty()) drawObjectList(window, mediumPotionLifes.get(0), mediumPotionLifes.size());
		if(!largePotionLifes.isEmpty()) drawObjectList(window, largePotionLifes.get(0), largePotionLifes.size());
		if(!keys.isEmpty()) drawObjectList(window, keys.get(0), keys.size());
	}

	/**
	 * Show an inventory object and check if he's not null.
	 * @param window : pointer on the window of the console.
	 * @param object ; object to show.
	 */
	public void drawObject(RenderWindow window, Object object){
		if(object!=null)
			object.draw(window);
	}
	
	/**
	 * add an object list to the inventory.
	 * @param window : pointer on the window of the console.
	 * @param object : an object of the list .
	 * @param size : Liste size.
	 */
	public void drawObjectList(RenderWindow window, Object object, int size){
		object.draw(window);
		Texte texteTmp = new Texte("* "+size, 15, new Vector2f(object.getPosition().x-10,object.getPosition().y-10), Color.BLACK, Text.BOLD);
		texteTmp.draw(window);
	}
	
	/**
	 * Add an object to the inventory.
	 * @param key : keys to add.
	 */
	public void addKey(Key key){
		key.setPosition(new Vector2f(370+1*54,660+0*54));
		keys.add(key);
	}
	
	/**
	 * using a key from the inventory and remove it.
	 * @return boolean
	 */
	public boolean useKey(){
		if(keys.isEmpty()){
			return false;
		} else {
			Console.getInstance().addText(keys.get(0).getName()+" utilis� !", Text.REGULAR, Color.BLACK);
			keys.remove(0);
			return true;
		}
	}
	
	/**
	 * Add a little life potion to the inventory and initialize his position in the inventory.
	 * @param potionLife : added little potion.
	 */
	public void addSmallPotionLife(PotionLife potionLife){
		potionLife.setPosition(new Vector2f(370+0*54,660+0*54));
		smallPotionLifes.add(potionLife);
	}
	
	/**
	 * Add a middle life potion to the inventory and initialize his position in the inventory.
	 * @param potionLife : added middle potion.
	 */
	public void addMediumPotionLife(PotionLife potionLife){
		potionLife.setPosition(new Vector2f(370+0*54,660+1*54));
		mediumPotionLifes.add(potionLife);
	}
	
	/**
	 * Add a bgig life potion to the inventory and initialize his position in the inventory.
	 * @param potionLife : added big potion.
	 */
	public void addLargePotionLife(PotionLife potionLife){
		potionLife.setPosition(new Vector2f(370+0*54,660+2*54));
		largePotionLifes.add(potionLife);
	}
	
	/**
	 * Return life bonus for all equipment in the inventory.
	 * @return bonus life.
	 */
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
	
	/**
	 * Return bonus life for each all boots in the inventory.
	 * @return Velocity bonus.
	 */
	public int getSpeedBonusEquipment(){
		if(boot==null)
			return 0;
		else
			return boot.getBonus();
	}
	
	/**
	 * Use a little potion in the inventory.
	 */
	public void useSmallPotion() {
		usePotion(smallPotionLifes);
	}
	
	/**
	 * Use a middle potion in the inventory.
	 */
	public void useMediumPotion() {
		usePotion(mediumPotionLifes);
	}
	
	/**
	 * Use a big potion in the inventory.
	 */
	public void useLargePotion() {
		usePotion(largePotionLifes);
	}
	
	/**
	 * Use a potion from the inventory and check if there are at least one potion in the inventory.
	 * @param array : potion array to use.
	 */
	public void usePotion(ArrayList<PotionLife> array) {
		if(array.isEmpty()){
			Console.getInstance().addText("You don't have potion !", Text.REGULAR, Color.RED);
		} else {
			if(array.get(0).action()){
				Console.getInstance().addText(array.get(0).getName()+" used !", Text.REGULAR, Color.BLACK);
				array.remove(0);
			}
		}
	}
	
	/**
	 * Return the time characteristic between two arm attack interval
	 * @return
	 */
	public float getIntervalShootWeapon(){
		if(weapon!=null)
			return weapon.getIntervalShoot();
		return 0.0f;
	}
	
	/**
	 * Return the shoot velocity characteristic.
	 * @return
	 */
	public int getSpeedShootWeapon(){
		if(weapon!=null)
			return weapon.getSpeed();
		return 0;
	}
	
	/**
	 *Return arm power characteristic
	 * @return
	 */
	public int getDamageShootWeapon(){
		if(weapon!=null)
			return weapon.getDamage();
		return 0;
	}

	public void setWeapon(Weapon weapon) {
		weapon.setPosition(new Vector2f(370+2*54,660+1*54));
		this.weapon = weapon;
	}

	public void setBoot(Boot boot) {
		boot.setPosition(new Vector2f(370+3*54,660+2*54));
		this.boot = boot;
	}

	public void setClothes(Clothes clothes) {
		clothes.setPosition(new Vector2f(370+3*54,660+1*54));
		this.clothes = clothes;
	}

	public void setGlove(Glove glove) {
		glove.setPosition(new Vector2f(370+4*54,660+1*54));
		this.glove = glove;
	}


	public void setHelmet(Helmet helmet) {
		helmet.setPosition(new Vector2f(370+3*54,660+0*54));
		this.helmet = helmet;
	}

	public void setShield(Shield shield) {
		shield.setPosition(new Vector2f(370+4*54,660+0*54));
		this.shield = shield;
	}
}
