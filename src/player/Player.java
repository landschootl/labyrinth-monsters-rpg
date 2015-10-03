package player;

import management.ResourceManager;

import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Clock;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

/**
 * Cette classe représente le joueur dans  le jeu.
 * @author Ludov_000
 *
 */
public class Player {
	private Sprite sprite = new Sprite(); // Le sprite du joueur.
	private IntRect[][] posSprites = new IntRect[4][3]; // Les différentes positions du découpage de la texture.
	private int directionSprite=0, animationSprite=0; // La direction du joueur, ce sont les positions pour le tableau posSprites.
	private float vitesseX=0, vitesseY=0; // La vitesse x et y du joueur. (-100, 0 ou +100).
	private Clock timerAnimation = new Clock();
	
	private LifeBar lifeBar = new LifeBar();
	private Viseur viseur = new Viseur();
	
	public Player(){
		initPlayer();
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
	                this.vitesseY=100;
	            break;
	            case Q :
	            	this.vitesseY=-100;
	            break;
	            case Z :
	            	this.vitesseX=-100;
	            break;
	            case S :
	            	this.vitesseX=+100;
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
		sprite.setTextureRect(posSprites[directionSprite][animationSprite%3]);
		updateDirectionSprite();
	}
	
	/**
	 * Fonction qui gère le déplacement du joueur ainsi que son animation.
	 * @param time : le temps pour la gestion des frames.
	 */
	public void move(Time time){
		sprite.setPosition(new Vector2f(sprite.getPosition().x+vitesseY*time.asSeconds(),sprite.getPosition().y+vitesseX*time.asSeconds()));
		if(timerAnimation.getElapsedTime().asSeconds() > 0.3 && (vitesseX != 0 || vitesseY != 0)){
			animationSprite++;
			timerAnimation.restart();
		}
	}
	
	/**
	 * Fonction qui gère la direction du sprite celon le viseur.
	 */
	public void updateDirectionSprite(){
		if(viseur.getPosition().y>sprite.getPosition().y){
	        if(Math.abs(viseur.getPosition().y-sprite.getPosition().y)>Math.abs(viseur.getPosition().x-sprite.getPosition().x))
	            directionSprite=0;
	        else
	            if(viseur.getPosition().x<sprite.getPosition().x)
	                directionSprite=1;
	            else
	                directionSprite=2;
	    }
	    if(viseur.getPosition().y<sprite.getPosition().y){
	        if(Math.abs(viseur.getPosition().y-sprite.getPosition().y)>Math.abs(viseur.getPosition().x-sprite.getPosition().x))
	            directionSprite=3;
	        else
	            if(viseur.getPosition().x<sprite.getPosition().x)
	                directionSprite=1;
	            else
	                directionSprite=2;
	    }
	}

	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 * @param window : La fenetre sur laquel on souhaite afficher les éléments.
	 */
	public void draw(RenderWindow window) {
		window.draw(sprite);
		lifeBar.draw(window);
		viseur.draw(window);
	}
	
	/**
	 * Fonction qui initialise le joueur.
	 */
	private void initPlayer() {
		sprite.setTexture(ResourceManager.getTexture("resource/sprite/soldier.png"));
		for(int i=0; i<4; i++){
			for(int j=0; j<3; j++){
				posSprites[i][j]=new IntRect(j*32,i*32,32,32);
			}
		}
		sprite.setPosition(new Vector2f(304,304));
	}

	public int getDirectionX() {
		return directionSprite;
	}

	public void setDirectionX(int directionX) {
		this.directionSprite = directionX;
	}

	public int getDirectionY() {
		return animationSprite;
	}

	public void setDirectionY(int directionY) {
		this.animationSprite = directionY;
	}

	public float getVitesseX() {
		return vitesseX;
	}

	public void setVitesseX(float vitesseX) {
		this.vitesseX = vitesseX;
	}

	public float getVitesseY() {
		return vitesseY;
	}

	public void setVitesseY(float vitesseY) {
		this.vitesseY = vitesseY;
	}
	
	public Vector2f getPosition(){
		return sprite.getPosition();
	}
	
	public void setPosition(Vector2f position){
		sprite.setPosition(position);
	}
}
