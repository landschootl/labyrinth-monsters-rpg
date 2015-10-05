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
import console.Console;
import entitee.Entitee;

/**
 * Cette classe représente le joueur dans  le jeu.
 * @author Ludov_000
 *
 */
public class Player extends Entitee {
	private final float MAX_LIFE = 3;
	private Clock intervalShoot = new Clock();
	
	private static Player instance = null;
	
	private Inventory inventory = new Inventory();
	private ArrayList<Munition> munitions = new ArrayList<>();
	private LifeBar lifeBar = new LifeBar();
	private Viseur viseur = new Viseur();
	
	private Player(){
		super(32, 32, 3, "resource/sprite/soldier.png", 100, new Vector2f(500, 500));
	}
	
	/**
	 * Fonction qui permet de créer la seule instance de Player si elle n'existe pas.
	 * @return la seule instance de la classe Player.
	 */
	public static Player getInstance(){
		if(instance==null)
			instance = new Player();
		return instance;
	}
	
	/**
	 * Fonction qui permet de gérer les événements.
	 * @param event : l'événement sur lequel on écoute.
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
	 */
	public void update() {
		super.update(viseur.getPosition());
		//Si On perd une vie ! 
		lifeBar.update(life, MAX_LIFE+inventory.getLifeBonusEquipment());
	}
	
	/**
	 * Fonction qui gère le déplacement du joueur ainsi que son animation.
	 * @param time : le temps pour la gestion des frames.
	 */
	public void move(Time time){
		super.move(time);
		for(Munition munition : munitions)
			munition.move(time);
		sprite.setPosition(new Vector2f(sprite.getPosition().x+speedY*time.asSeconds(),sprite.getPosition().y+speedX*time.asSeconds()));
	}

	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 * @param window : La fenetre sur laquel on souhaite afficher les éléments.
	 */
	public void draw(RenderWindow window) {
		super.draw(window);
		lifeBar.draw(window);
		viseur.draw(window);
		for(Munition munition : munitions)
			munition.draw(window);
	}
	
	public void shoot(){
		munitions.add(new Munition(getPosition(),viseur.getPosition(),inventory.getSpeedShootWeapon()));
	}
	
	public boolean addLife(float nbLife){
		float maxLife = MAX_LIFE+inventory.getLifeBonusEquipment();
		if(life==maxLife){
			Console.getInstance().getInstance().addText("La jauge de vie est pleine !", Text.REGULAR, Color.RED);
			return false;
		}
		float lifeGain=0;
		if((life+nbLife)>maxLife){
			life=MAX_LIFE;		
			lifeGain=maxLife-(life+nbLife);
		} else {
			life+=nbLife;
			lifeGain=nbLife;
		}
		Console.getInstance().getInstance().addText("+ "+(int)lifeGain+" point de vies !", Text.REGULAR, Color.BLACK);
		return true;
	}
	
	public void loseLife(int degat) {
		// TODO Auto-generated method stub
		float loseLife = 0;
		if((life-degat)<0){
			life=0;
			loseLife=(life-degat);
		} else {
			life-=degat;
			loseLife=degat;
		}
		Console.getInstance().getInstance().addText("- "+(int)loseLife+" point de vies !", Text.REGULAR, Color.MAGENTA);
		if(life==0)
			isDead();
	}
	
	public void isDead(){
		Console.getInstance().getInstance().addText("Vous êtes mort !", Text.BOLD, Color.RED);
		Application.setStateOfApp("gameOver");
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
	
}