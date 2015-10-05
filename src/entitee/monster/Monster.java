package entitee.monster;

import management.CollisionManager;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Clock;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;

import resource.Texte;
import console.Console;
import entitee.Entitee;
import entitee.player.Player;

public abstract class Monster extends Entitee {
	private String name;
	private Clock timerAttack = new Clock();
	private int degat;
	private Texte lifeBar = new Texte("life="+life, 15, getPosition(), Color.BLACK, Text.ITALIC);
	
	public Monster(String name, int SIZE_WIDTH, int SIZE_HEIGHT, int life, String pathSprite, int speed, int degat, Vector2f posBegin){
		super(SIZE_WIDTH, SIZE_HEIGHT, life, pathSprite, speed, posBegin);
		this.name=name;
		this.degat=degat;
	}
	
	/**
	 * Fonction qui permet de gérer les actions.
	 * @param time 
	 */
	public void update(Vector2f positionCible, Time time) {
		super.update(positionCible);
		lifeBar.setString("life="+(int)life);
		lifeBar.setPosition(new Vector2f(getPosition().x,getPosition().y-16));
		CollisionManager.collisionMonsterPlayer(this, time, timerAttack, positionCible);
		CollisionManager.collisionMonsterMunition(this);
	}
	
	public void draw(RenderWindow window){
		super.draw(window);
		lifeBar.draw(window);
	}
	
	/**
	 * Fonction qui gère le déplacement du joueur ainsi que son animation.
	 * @param time : le temps pour la gestion des frames.
	 */
	public void move(Time time, Vector2f positionCible){
		super.move(time);
		double distance = (float)Math.sqrt((Math.abs(((sprite.getPosition().x-positionCible.x)*(sprite.getPosition().x-positionCible.x))+((sprite.getPosition().y-positionCible.y)*(sprite.getPosition().y-positionCible.y)))));
	    speedX=(float)(((positionCible.x-sprite.getPosition().x)/distance)*speed)*time.asSeconds();
	    speedY=(float)(((positionCible.y-sprite.getPosition().y)/distance)*speed)*time.asSeconds();
		sprite.move(new Vector2f(speedX, speedY));
	}
	
	public String getName(){
		return name;
	}
	
	public int getDegat(){
		return degat;
	}
}
