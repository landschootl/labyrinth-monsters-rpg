package entitee.monster;

import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;

import entitee.Entitee;

public abstract class Monster extends Entitee {
	
	public Monster(int SIZE_WIDTH, int SIZE_HEIGHT, int life, String pathSprite, int speed, Vector2f posBegin){
		super(SIZE_WIDTH, SIZE_HEIGHT, life, pathSprite, speed, posBegin);
	}
	
	/**
	 * Fonction qui permet de gérer les actions.
	 * @param time 
	 */
	public void update(Vector2f positionCible, Time time) {
		sprite.setTextureRect(posSprites[directionSprite][animationSprite%3]);
		updateDirectionSprite(positionCible);
		move(time, positionCible);
	}
	
	/**
	 * Fonction qui gère le déplacement du joueur ainsi que son animation.
	 * @param time : le temps pour la gestion des frames.
	 */
	public void move(Time time, Vector2f positionCible){
		super.move(time);
		double distance = (float)Math.sqrt((Math.abs(((sprite.getPosition().x-positionCible.x)*(sprite.getPosition().x-positionCible.x))+((sprite.getPosition().y-positionCible.y)*(sprite.getPosition().y-positionCible.y)))));
	    vitesseX=(float)(((positionCible.x-sprite.getPosition().x)/distance)*speed)*time.asSeconds();
	    vitesseY=(float)(((positionCible.y-sprite.getPosition().y)/distance)*speed)*time.asSeconds();
		sprite.move(new Vector2f(vitesseX, vitesseY));
	}
}
