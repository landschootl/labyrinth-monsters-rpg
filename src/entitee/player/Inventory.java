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
 * Classe qui reprèsente l'inventaire du joueur.
 * @author Ludov_000
 *
 */
public class Inventory {
	// Logique
	/**
	 * Les petites potions de vies que possède le joueur.
	 */
	private ArrayList<PotionLife> smallPotionLifes = new ArrayList<>();
	/**
	 * Les moyennes potions de vies que possède le joueur.
	 */
	private ArrayList<PotionLife> mediumPotionLifes = new ArrayList<>();
	/**
	 * Les grandes potions de vies que possède le joueur.
	 */
	private ArrayList<PotionLife> largePotionLifes = new ArrayList<>();
	/**
	 * Les clés que possède le joueur.
	 */
	private ArrayList<Object> keys = new ArrayList<>();
	/**
	 * L'arme que possède le joueur.
	 */
	private Weapon weapon;
	/**
	 * Les bottes que possède le joueur.
	 */
	private Equipment boot = null;
	/**
	 * L'armure que possède le joueur.
	 */
	private Equipment clothes = null;
	/**
	 * Les gants que possède le joueur.
	 */
	private Equipment glove = null;
	/**
	 * Le casque que possède le joueur.
	 */
	private Equipment helmet = null;
	/**
	 * Le bouclier que possède le joueur.
	 */
	private Equipment shield = null;
	
	// Graphique
	private RectangleShape backgroundContour;
	private RectangleShape[][] backgroundCase = new RectangleShape[5][3];
	
	public Inventory(){
		initBackground();
		setWeapon(new BeginnerBow());
	}
	
	/**
	 * Initialise le background de l'inventaire.
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
	 * Affiche les éléments graphiques dans la fenêtre de la console.
	 * @param window : pointeur sur la fenetre de l'application.
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
	 * Affiche un object de l'inventaire en vérifiant si il n'est pas null.
	 * @param window : pointeur sur la fenetre de l'application.
	 * @param object ; l'object à afficher.
	 */
	public void drawObject(RenderWindow window, Object object){
		if(object!=null)
			object.draw(window);
	}
	
	/**
	 * Affiche une liste d'objets de l'inventaire.
	 * @param window : pointeur sur la fenetre de l'application.
	 * @param object : un objet de la liste.
	 * @param size : la taille de la liste.
	 */
	public void drawObjectList(RenderWindow window, Object object, int size){
		object.draw(window);
		Texte texteTmp = new Texte("* "+size, 15, new Vector2f(object.getPosition().x-10,object.getPosition().y-10), Color.BLACK, Text.BOLD);
		texteTmp.draw(window);
	}
	
	/**
	 * Ajoute un object clé dans l'inventaire.
	 * @param key : la clé à ajouter.
	 */
	public void addKey(Key key){
		key.setPosition(new Vector2f(370+1*54,660+0*54));
		keys.add(key);
	}
	
	/**
	 * Utilise une clé de l'inventaire et la supprime.
	 * @return boolean
	 */
	public boolean useKey(){
		if(keys.isEmpty()){
			return false;
		} else {
			Console.getInstance().addText(keys.get(0).getName()+" utilisé !", Text.REGULAR, Color.BLACK);
			keys.remove(0);
			return true;
		}
	}
	
	/**
	 * Ajoute une petite potion de vie l'inventaire et initialise sa position dans l'inventaire.
	 * @param potionLife : la petite potion de vie à ajouter.
	 */
	public void addSmallPotionLife(PotionLife potionLife){
		potionLife.setPosition(new Vector2f(370+0*54,660+0*54));
		smallPotionLifes.add(potionLife);
	}
	
	/**
	 * Ajoute une moyenne potion de vie l'inventaire et initialise sa position dans l'inventaire.
	 * @param potionLife : la moyenne potion de vie à ajouter.
	 */
	public void addMediumPotionLife(PotionLife potionLife){
		potionLife.setPosition(new Vector2f(370+0*54,660+1*54));
		mediumPotionLifes.add(potionLife);
	}
	
	/**
	 * Ajoute une grande potion de vie l'inventaire et initialise sa position dans l'inventaire.
	 * @param potionLife : la grande potion de vie à ajouter.
	 */
	public void addLargePotionLife(PotionLife potionLife){
		potionLife.setPosition(new Vector2f(370+0*54,660+2*54));
		largePotionLifes.add(potionLife);
	}
	
	/**
	 * Retourne le bonus de vie de chaque equipment accumulé présent dans l'inventaire.
	 * @return le bonus de vie
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
	 * Retourne le bonus de vitesse des bottes présentent dans l'inventaire.
	 * @return le bonus de vitesse
	 */
	public int getSpeedBonusEquipment(){
		if(boot==null)
			return 0;
		else
			return boot.getBonus();
	}
	
	/**
	 * Utilise une petite potion de vie dans l'inventaire.
	 */
	public void useSmallPotion() {
		usePotion(smallPotionLifes);
	}
	
	/**
	 * Utilise une moyenne potion de vie dans l'inventaire.
	 */
	public void useMediumPotion() {
		usePotion(mediumPotionLifes);
	}
	
	/**
	 * Utilise une grande potion de vie dans l'inventaire.
	 */
	public void useLargePotion() {
		usePotion(largePotionLifes);
	}
	
	/**
	 * Utilise une potion présente dans l'inventaire en vérifiant si il y en a bien une.
	 * @param array : le tableau de potion à utiliser.
	 */
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
	
	/**
	 * Retourne la caractéristique de temps entre deux intervalles d'attaque de l'arme.
	 * @return
	 */
	public float getIntervalShootWeapon(){
		if(weapon!=null)
			return weapon.getIntervalShoot();
		return 0.0f;
	}
	
	/**
	 * Retourne la caractéristique de vitesse de la munition de l'arme.
	 * @return
	 */
	public int getSpeedShootWeapon(){
		if(weapon!=null)
			return weapon.getSpeed();
		return 0;
	}
	
	/**
	 * Retourne la caractéristique de puissance de l'arme.
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
