package entitee;

import management.ResourceManager;

import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Clock;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;

/**
 * Classe qui représente un individu en mouvement.
 * @author Ludov_000
 *
 */
public abstract class Entitee {
	// Logique
	/**
	 * Taille en largeur de l'individu.
	 */
	protected int SIZE_WIDTH;
	/**
	 * Taille en longueur de l'individu.
	 */
	protected int SIZE_HEIGHT;
	/**
	 * Nombre de vie.
	 */
	protected float life;
	/**
	 * Les différentes positions du sprite dans la texture.
	 */
	protected IntRect[][] positionSprite = new IntRect[4][3];
	/**
	 * Les positions dans le tableau de posSprites celon la direction et l'état de l'animation de l'individu.
	 */
	protected int direction=0, animationSprite=0;
	/**
	 * La vitesse de l'individu sur l'axe x et y de la fenetre.
	 */
	protected float speedX=0, speedY=0;
	/**
	 * Timer qui gère l'animation du sprite.
	 */
	protected Clock timerAnimation = new Clock();
	/**
	 * La vitesse de l'individu.
	 */
	protected int speed;
	
	// Graphique
	protected Sprite sprite = new Sprite();
	
	public Entitee(int SIZE_WIDTH, int SIZE_HEIGHT, int life, String pathSprite, int speed){
		this.SIZE_WIDTH = SIZE_WIDTH;
		this.SIZE_HEIGHT = SIZE_HEIGHT;
		this.speed = speed;
		this.life = life;
		
		sprite.setTexture(ResourceManager.getTexture(pathSprite));
		for(int i=0; i<4; i++){
			for(int j=0; j<3; j++){
				positionSprite[i][j]=new IntRect(j*SIZE_WIDTH,i*SIZE_HEIGHT,SIZE_WIDTH,SIZE_HEIGHT);
			}
		}
		initPositionBegin();
	}
	
	/**
	 * Initialise la position de départ de l'individu.
	 */
	public abstract void initPositionBegin();
	
	/**
	 * Fonction qui permet de gérer les actions.
	 * @param time : Timer pour la gestion des frames.
	 */
	public void update(Vector2f positionCible) {
		sprite.setTextureRect(positionSprite[direction][animationSprite%3]);
		updateDirectionSprite(positionCible);
	}
	
	/**
	 * Gère le déplacement du joueur ainsi que son animation.
	 * @param time : Timer pour la gestion des frames.
	 */
	public void move(Time time){
		if(timerAnimation.getElapsedTime().asSeconds() > 0.3 && (speedX != 0 || speedY != 0)){
			animationSprite++;
			timerAnimation.restart();
		}
	}
	
	/**
	 * Fonction qui gère la direction de l'individu.
	 * @param positionCible : La position de repère.
	 */
	public void updateDirectionSprite(Vector2f positionCible){
		if(positionCible.y>sprite.getPosition().y){
	        if(Math.abs(positionCible.y-sprite.getPosition().y)>Math.abs(positionCible.x-sprite.getPosition().x))
	            direction=0;
	        else
	            if(positionCible.x<sprite.getPosition().x)
	                direction=1;
	            else
	                direction=2;
	    }
	    if(positionCible.y<sprite.getPosition().y){
	        if(Math.abs(positionCible.y-sprite.getPosition().y)>Math.abs(positionCible.x-sprite.getPosition().x))
	            direction=3;
	        else
	            if(positionCible.x<sprite.getPosition().x)
	                direction=1;
	            else
	                direction=2;
	    }
	}
	
	/**
	 * Affiche les éléments graphiques dans la fenêtre de la console.
	 * @param window : pointeur sur la fenetre de l'application.
	 */
	public void draw(RenderWindow window) {
		window.draw(sprite);
	}
	
	/**
	 * Enleve des points de vie à l'individu.
	 * @param degat : Le nombre de point de vie à enlever.
	 */
	public void loseLife(int degat) {
		// TODO Auto-generated method stub
		if((life-degat)<0)
			life=0;
		else 
			life-=degat;
	}
	
	/**
	 * Indique si l'invidu est mort.
	 * @return boolean.
	 */
	public boolean isDead(){
		return life<=0;
	}
	
	public int getDirectionX() {
		return direction;
	}

	public void setDirectionX(int directionX) {
		this.direction = directionX;
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
