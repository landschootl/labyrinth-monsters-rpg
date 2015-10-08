package entitee;

import management.ResourceManager;

import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Clock;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;

/**
 * 
 * The class represent an individual moving.
 * @author Ludov_000
 *
 */
public abstract class Entitee {
	// Logique
	/**
	 * width of the character.
	 */
	protected int SIZE_WIDTH;
	/**
	 * height of the character.
	 */
	protected int SIZE_HEIGHT;
	/**
	 * number of life.
	 */
	protected float life;
	/**
	 * The differents position of the sprite in the texture.
	 */
	protected IntRect[][] positionSprite = new IntRect[4][3];
	/**
	 * The position in the posSprites board according to the direction and the state of the individual animation.
	 */
	protected int direction=0, animationSprite=0;
	/**
	 * velocity.
	 */
	protected float speedX=0, speedY=0;
	/**
	 * Timer which manage the animation.
	 */
	protected Clock timerAnimation = new Clock();
	/**
	 * character velocity.
	 */
	protected int speed;
	
	
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
	 * Initialize the start position of the individual.
	 */
	public abstract void initPositionBegin();
	
	/**
	 * This function manage the actions
	 * @param time : Timer for the frames manages.
	 */
	public void update(Vector2f positionCible) {
		sprite.setTextureRect(positionSprite[direction][animationSprite%3]);
		updateDirectionSprite(positionCible);
	}
	
	/**
	 * Manage the movments of the player as wall as his animation.
	 * @param time : Timer for the frames gestion.
	 */
	public void move(Time time){
		if(timerAnimation.getElapsedTime().asSeconds() > 0.3 && (speedX != 0 || speedY != 0)){
			animationSprite++;
			timerAnimation.restart();
		}
	}
	
	/**
	 * This function manage the direction of the character.
	 * @param positionCible : landmark position.
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
	 * Show graphics elements in the window of the console.
	 * @param window : pointer on the window of the application.
	 */
	public void draw(RenderWindow window) {
		window.draw(sprite);
	}
	
	/**
	 * remove life points to the character.
	 * @param degat : number of points.
	 */
	public void loseLife(int degat) {
		// TODO Auto-generated method stub
		if((life-degat)<0)
			life=0;
		else 
			life-=degat;
	}
	
	/**
	 * said id the character is dead.
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

	public int getSIZE_WIDTH() {
		return SIZE_WIDTH;
	}

	public int getSIZE_HEIGHT() {
		return SIZE_HEIGHT;
	}

	public int getSpeed() {
		return speed;
	}
	
}
