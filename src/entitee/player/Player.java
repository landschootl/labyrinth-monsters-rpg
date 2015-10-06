package entitee.player;

import java.util.ArrayList;

import object.weapon.Munition;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Clock;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

import application.Application;
import application.Application.State;
import console.Console;
import entitee.Entitee;

/**
 * Classe singleton qui représente le joueur.
 * @author Ludov_000
 *
 */
public class Player extends Entitee {
	/**
	 * Le maximum de sa vie.
	 */
	private final float MAX_LIFE = 3;
	/**
	 * Timer qui gère le temps entre deux tirs.
	 */
	private Clock intervalShoot = new Clock();
	/**
	 * Si le joueur exécute l'action pour ramasser un object.
	 */
	private boolean actionPickUp = false;
	
	/**
	 * L'unique instance de la classe joueur.
	 */
	private static Player instance = null;
	
	private Inventory inventory = new Inventory();
	/**
	 * Les tirs du joueur.
	 */
	private ArrayList<Munition> munitions = new ArrayList<>();
	private LifeBar lifeBar = new LifeBar();
	private Viseur viseur = new Viseur();
	
	private Player(){
		super(32, 32, 3, "resource/sprite/soldier.png", 100);
	}
	
	/**
	 * Initialise la position de départ du joueur.
	 */
	public void initPositionBegin(){
		sprite.setPosition(new Vector2f(10*32,18*32));
	}
	
	/**
	 * Retourne et créer l'instance de la classe si elle n'éxiste pas.
	 * @return la seule instance de la classe Player.
	 */
	public static Player getInstance(){
		if(instance==null)
			init();
		return instance;
	}
	
	/**
	 * Reinitialise l'instance.
	 */
	public static void init(){
		instance = new Player();
	}
	
	/**
	 * Permet de gérer les événements de la scène.
	 * @param event : l'événement de l'application.
	 */
	public void handleEvents(Event event) {
		viseur.handleEvents(event);
		if(event.type==Event.Type.KEY_PRESSED){
	        switch(event.asKeyEvent().key){
	            case D :
	                this.speedY=speed+inventory.getSpeedBonusEquipment();
	            break;
	            case Q :
	            	this.speedY=-speed-inventory.getSpeedBonusEquipment();
	            break;
	            case Z :
	            	this.speedX=-speed-inventory.getSpeedBonusEquipment();
	            break;
	            case S :
	            	this.speedX=speed+inventory.getSpeedBonusEquipment();
	            break;
	            case NUM1 :
	            	inventory.useSmallPotion();
	            break;
	            case NUM2 :
	            	inventory.useMediumPotion();
	            break;
	            case NUM3 :
	            	inventory.useLargePotion();
	            break;
	            case TAB :
	            	actionPickUp=true;
	            break;
	            case ESCAPE :
	            	Application.setStateOfApp(State.PAUSE);
	           	break;
	            default:
	            break;
	        }
	    }
		if(event.type==Event.Type.KEY_RELEASED){
	        switch(event.asKeyEvent().key){
	            case D :
	            	this.speedY=0;
	            break;
	            case Q :
	            	this.speedY=0;
	            break;
	            case Z :
	            	this.speedX=0;
	            break;
	            case S :
	            	this.speedX=0;;
	            break;
	            case TAB :
	            	actionPickUp=false;
	            break;
	            default:
	            break;
	        }
	    }
		if(event.type==Event.Type.MOUSE_BUTTON_PRESSED){
			if(intervalShoot.getElapsedTime().asSeconds()>inventory.getIntervalShootWeapon()){
				shoot();
				intervalShoot.restart();
			}
		}
	}

	/**
	 * Fonction qui permet de gérer les actions.
	 * @param time : Timer pour la gestion des frames.
	 */
	public void update() {
		super.update(viseur.getPosition());
		//Si On perd une vie ! 
		lifeBar.update(life, MAX_LIFE+inventory.getLifeBonusEquipment());
		if(isDead()){
			Console.getInstance().addText("Vous êtes mort !", Text.BOLD, Color.RED);
			Application.setStateOfApp(State.GAMEOVER);
		}
	}
	
	/**
	 * Gère le déplacement du joueur ainsi que son animation.
	 * @param time : Timer pour la gestion des frames.
	 */
	public void move(Time time){
		super.move(time);
		for(Munition munition : munitions)
			munition.move(time);
		sprite.setPosition(new Vector2f(sprite.getPosition().x+speedY*time.asSeconds(),sprite.getPosition().y+speedX*time.asSeconds()));
	}

	/**
	 * Affiche les éléments graphiques dans la fenêtre de la console.
	 * @param window : pointeur sur la fenetre de l'application.
	 */
	public void draw(RenderWindow window) {
		super.draw(window);
		lifeBar.draw(window);
		inventory.draw(window);
		viseur.draw(window);
		for(Munition munition : munitions)
			munition.draw(window);
	}
	
	/**
	 * Execute un tir.
	 */
	public void shoot(){
		munitions.add(new Munition(new Vector2f(getPosition().x+16,getPosition().y+16),viseur.getPosition(),inventory.getSpeedShootWeapon()));
	}
	
	/**
	 * Ajoute des points de vie au joueur.
	 * @param nbLife : le nombre de point de vie à ajouter.
	 * @return boolean
	 */
	public boolean addLife(float nbLife){
		float maxLife = MAX_LIFE+inventory.getLifeBonusEquipment();
		if(life==maxLife){
			Console.getInstance().addText("La jauge de vie est pleine !", Text.REGULAR, Color.RED);
			return false;
		}
		float lifeGain=0;
		if((life+nbLife)>maxLife){
			lifeGain=maxLife-life;
			life=maxLife;		
		} else {
			lifeGain=nbLife;
			life+=nbLife;
		}
		Console.getInstance().addText("+ "+(int)lifeGain+" point de vies !", Text.REGULAR, Color.BLACK);
		return true;
	}
	
	/**
	 * Enleve des points de vie au joueur.
	 * @param degat : le nombre de point de vie perdu.
	 */
	public void loseLife(int degat) {
		// TODO Auto-generated method stub
		float lifeBefore = life;
		super.loseLife(degat);
		float lifeAfter = life;
		float looseLife = lifeBefore-lifeAfter;
		Console.getInstance().addText("- "+(int)looseLife+" point de vies !", Text.REGULAR, Color.MAGENTA);
	}
	
	public float getMAX_LIFE() {
		return MAX_LIFE;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public ArrayList<Munition> getMunitions() {
		return munitions;
	}

	public void setMunitions(ArrayList<Munition> munitions) {
		this.munitions = munitions;
	}
	
	public boolean isActionPickUp(){
		return actionPickUp;
	}

}