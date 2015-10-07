package entitee.monster;

import management.CollisionManager;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Clock;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;

import resource.Texte;
import entitee.Entitee;

/**
 * this class represent a monster in the dungeon.
 * @author Ludov_000
 *
 */
public abstract class Monster extends Entitee {
	/**
	 * Name monster.
	 */
	private String name;
	/**
	 * the timer manage the time between two shoots.
	 */
	private Clock timerAttack = new Clock();
	/**
	 * Monster damage.
	 */
	private int degat;
	
	public Monster(String name, int SIZE_WIDTH, int SIZE_HEIGHT, int life, String pathSprite, int speed, int degat){
		super(SIZE_WIDTH, SIZE_HEIGHT, life, pathSprite, speed);
		this.name=name;
		this.degat=degat;
	}
	
	/**
	 * Initialize random monster position.
	 */
	public void initPositionBegin(){
		int x=(int) (6+(Math.random()*8));
		int y=(int) (6+(Math.random()*8));
		sprite.setPosition(new Vector2f(x*32,y*32));
	}
	
	/**
	 * Manage monster actions
	 * @param positionCible : Monster target position.
	 * @param time : Timer for frames gestions.
	 */
	public void update(Vector2f positionCible, Time time) {
		super.update(positionCible);

		CollisionManager.collisionMonsterPlayer(this, time, timerAttack, positionCible);
		CollisionManager.collisionMonsterMunition(this);
	}
	
	/**
	 * Show the graphics elements in the window of the console.
	 * @param window : Pointer on the window of the application..
	 */
	public void draw(RenderWindow window){
		super.draw(window);
		Texte lifeBar = new Texte("life="+(int)life, 15, new Vector2f(getPosition().x,getPosition().y-16), Color.BLACK, Text.ITALIC);
		lifeBar.draw(window);
	}
	
	/**
	 * Manage the monster movements as well as his animation
	 * @param positionCible : Monster target position.
	 * @param time : Timer for frames manage.
	 */
	public void move(Time time, Vector2f positionCible){
		super.move(time);
		double distance = (float)Math.sqrt((Math.abs(((sprite.getPosition().x-positionCible.x)*(sprite.getPosition().x-positionCible.x))+((sprite.getPosition().y-positionCible.y)*(sprite.getPosition().y-positionCible.y)))));
	    speedX=(float)(((positionCible.x-sprite.getPosition().x)/distance)*speed)*time.asSeconds();
	    speedY=(float)(((positionCible.y-sprite.getPosition().y)/distance)*speed)*time.asSeconds();
		sprite.move(new Vector2f(speedX, speedY));
	}
	
	/**
	 * Return a monster identified by an id.
	 * @param id : id of the monster.
	 * @return monster
	 */
	public static Monster generateMonsterById(String id) {
		switch(id) {
		case "1":
			return new Rodeur();
		case "2":
			return new Runner();
		case "3":
			return new Barroc();
		case "4":
			return new Malloc();
		case "5":
			return new Sirheal();
		case "6":
			return new Dragon();
		default:
			return null;
		}
	}
	
	public String getName(){
		return name;
	}
	
	public int getDegat(){
		return degat;
	}
}
