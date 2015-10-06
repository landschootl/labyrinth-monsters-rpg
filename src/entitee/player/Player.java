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

import scene.SceneGame;
import scene.SceneGame.EventGame;
import application.Application;
import application.Application.State;
import console.Console;
import entitee.Entitee;

/**
 * Player singleton class.
 * @author Ludov_000
 *
 */
public class Player extends Entitee {
	/**
	 * Maximum life.
	 */
	private final float MAX_LIFE = 3;
	/**
	 * This timer manage the interval between two shoot.
	 */
	private Clock intervalShoot = new Clock();
	/**
	 * if the player execute an action pick up an object.
	 */
	private boolean actionPickUp = false;
	
	/**
	 * the only instance from player class.
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
	 * Return and create the class instance if it dosen't exist.
	 * @return The only instance from player class.
	 */
	public static Player getInstance(){
		if(instance==null)
			instance = new Player();
		return instance;
	}
	
	/**
	 * Reinitialize the instance.
	 */
	public void init(){
		life = MAX_LIFE;
		inventory = new Inventory();
		initPositionBegin();
	}
	
	/**
	 * initialize start depart position.
	 */
	public void initPositionBegin(){
		sprite.setPosition(new Vector2f(10*32,18*32));
	}
	
	/**
	 *Enable to mange scene events.
	 * @param event : application event.
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
	 * This function enable to manage the actions.
	 * @param time : Timer for frames manage.
	 */
	public void update() {
		super.update(viseur.getPosition());
		lifeBar.update(life, MAX_LIFE+inventory.getLifeBonusEquipment());
		if(isDead()){
			SceneGame.setEventOfGame(EventGame.PLAYER_IS_DEAD);
		}
	}
	
	/**
	 * manage the player movements as well as his animation.
	 * @param time : Timer for frames manage.
	 */
	public void move(Time time){
		super.move(time);
		for(Munition munition : munitions)
			munition.move(time);
		sprite.setPosition(new Vector2f(sprite.getPosition().x+speedY*time.asSeconds(),sprite.getPosition().y+speedX*time.asSeconds()));
	}

	/**
	 * Show graphics elements in the window of the console.
	 * @param window : pointer on the windows of the application.
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
	 * execute a shoot.
	 */
	public void shoot(){
		munitions.add(new Munition(new Vector2f(getPosition().x+16,getPosition().y+16),viseur.getPosition(),inventory.getSpeedShootWeapon()));
	}
	
	/**
	 * Add life points to player.
	 * @param nbLife : added points life.
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
	 * remove points life to player.
	 * @param degat : lost points life.
	 */
	public void loseLife(int degat) {
		// TODO Auto-generated method stub
		float lifeBefore = life;
		super.loseLife(degat);
		float lifeAfter = life;
		float looseLife = lifeBefore-lifeAfter;
		Console.getInstance().addText("- "+(int)looseLife+" point de vies !", Text.REGULAR, Color.RED);
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