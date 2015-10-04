package entitee.player;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

import console.Console;
import entitee.Entitee;

/**
 * Cette classe représente le joueur dans  le jeu.
 * @author Ludov_000
 *
 */
public class Player extends Entitee {
	private final int MAX_LIFE = 3;
	
	private static Player instance = null;
	
	private Inventory inventory = new Inventory();
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
	                this.vitesseY=speed;
	            break;
	            case Q :
	            	this.vitesseY=-speed;
	            break;
	            case Z :
	            	this.vitesseX=-speed;
	            break;
	            case S :
	            	this.vitesseX=speed;
	            break;
	            default:
	            break;
	        }
	    }
		if(event.type==Event.Type.KEY_RELEASED){
	        switch(event.asKeyEvent().key){
	            case D :
	            	this.vitesseY=0;
	            break;
	            case Q :
	            	this.vitesseY=0;
	            break;
	            case Z :
	            	this.vitesseX=0;
	            break;
	            case S :
	            	this.vitesseX=0;;
	            break;
	            default:
	            break;
	        }
	    }
	}

	/**
	 * Fonction qui permet de gérer les actions.
	 */
	public void update() {
		super.update(viseur.getPosition());
		//Si On perd une vie ! 
		lifeBar.update(life, MAX_LIFE);
	}
	
	/**
	 * Fonction qui gère le déplacement du joueur ainsi que son animation.
	 * @param time : le temps pour la gestion des frames.
	 */
	public void move(Time time){
		super.move(time);
		sprite.setPosition(new Vector2f(sprite.getPosition().x+vitesseY*time.asSeconds(),sprite.getPosition().y+vitesseX*time.asSeconds()));
	}

	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 * @param window : La fenetre sur laquel on souhaite afficher les éléments.
	 */
	public void draw(RenderWindow window) {
		super.draw(window);
		lifeBar.draw(window);
		viseur.draw(window);
	}
}