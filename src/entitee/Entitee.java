package entitee;

import management.ResourceManager;

import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Clock;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;

public abstract class Entitee {
	protected int SIZE_WIDTH;
	protected int SIZE_HEIGHT;
	protected float life;
	protected Sprite sprite = new Sprite(); // Le sprite du joueur.
	protected IntRect[][] posSprites = new IntRect[4][3]; // Les différentes positions du découpage de la texture.
	protected int directionSprite=0, animationSprite=0; // La direction du joueur, ce sont les positions pour le tableau posSprites.
	protected float speedX=0, speedY=0; // La vitesse x et y du joueur. (-100, 0 ou +100).
	protected Clock timerAnimation = new Clock();
	protected int speed;
	
	public Entitee(int SIZE_WIDTH, int SIZE_HEIGHT, int life, String pathSprite, int speed, Vector2f posBegin){
		this.SIZE_WIDTH = SIZE_WIDTH;
		this.SIZE_HEIGHT = SIZE_HEIGHT;
		this.speed = speed;
		this.life = life;
		
		sprite.setTexture(ResourceManager.getTexture(pathSprite));
		for(int i=0; i<4; i++){
			for(int j=0; j<3; j++){
				posSprites[i][j]=new IntRect(j*SIZE_WIDTH,i*SIZE_HEIGHT,SIZE_WIDTH,SIZE_HEIGHT);
			}
		}
		sprite.setPosition(posBegin);
	}
	
	/**
	 * Fonction qui permet de gérer les actions.
	 * @param time 
	 */
	public void update(Vector2f positionCible) {
		sprite.setTextureRect(posSprites[directionSprite][animationSprite%3]);
		updateDirectionSprite(positionCible);
	}
	
	/**
	 * Fonction qui gère le déplacement du joueur ainsi que son animation.
	 * @param time : le temps pour la gestion des frames.
	 */
	public void move(Time time){
		if(timerAnimation.getElapsedTime().asSeconds() > 0.3 && (speedX != 0 || speedY != 0)){
			animationSprite++;
			timerAnimation.restart();
		}
	}
	
	/**
	 * Fonction qui gère la direction du sprite celon le viseur.
	 */
	public void updateDirectionSprite(Vector2f positionCible){
		if(positionCible.y>sprite.getPosition().y){
	        if(Math.abs(positionCible.y-sprite.getPosition().y)>Math.abs(positionCible.x-sprite.getPosition().x))
	            directionSprite=0;
	        else
	            if(positionCible.x<sprite.getPosition().x)
	                directionSprite=1;
	            else
	                directionSprite=2;
	    }
	    if(positionCible.y<sprite.getPosition().y){
	        if(Math.abs(positionCible.y-sprite.getPosition().y)>Math.abs(positionCible.x-sprite.getPosition().x))
	            directionSprite=3;
	        else
	            if(positionCible.x<sprite.getPosition().x)
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
		return speedX;
	}

	public void setVitesseX(float vitesseX) {
		this.speedX = vitesseX;
	}

	public float getVitesseY() {
		return speedY;
	}

	public void setVitesseY(float vitesseY) {
		this.speedY = vitesseY;
	}
	
	public Vector2f getPosition(){
		return sprite.getPosition();
	}
	
	public void setPosition(Vector2f position){
		sprite.setPosition(position);
	}

	public float getLife() {
		return life;
	}

	public void setLife(float life) {
		this.life = life;
	}
	
	public Sprite getSprite(){
		return sprite;
	}
}
