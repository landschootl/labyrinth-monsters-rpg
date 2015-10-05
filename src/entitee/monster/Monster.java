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
 * Classe qui repr�sente un monstre dans le donjon.
 * @author Ludov_000
 *
 */
public abstract class Monster extends Entitee {
	/**
	 * Le nom du monstre.
	 */
	private String name;
	/**
	 * Le timer qui g�re le temps entre deux coups.
	 */
	private Clock timerAttack = new Clock();
	/**
	 * Le nombre de d�gat effectu� par le monstre.
	 */
	private int degat;
	
	public Monster(String name, int SIZE_WIDTH, int SIZE_HEIGHT, int life, String pathSprite, int speed, int degat){
		super(SIZE_WIDTH, SIZE_HEIGHT, life, pathSprite, speed);
		this.name=name;
		this.degat=degat;
	}
	
	/**
	 * Initialise la position du monstre al�atoirement.
	 */
	public void initPositionBegin(){
		int x=(int) (6+(Math.random()*8));
		int y=(int) (6+(Math.random()*8));
		sprite.setPosition(new Vector2f(x*32,y*32));
	}
	
	/**
	 * Permet de g�rer les actions du monstre.
	 * @param positionCible : La position de la cible du monstre.
	 * @param time : Timer pour la gestion des frames.
	 */
	public void update(Vector2f positionCible, Time time) {
		super.update(positionCible);

		CollisionManager.collisionMonsterPlayer(this, time, timerAttack, positionCible);
		CollisionManager.collisionMonsterMunition(this);
	}
	
	/**
	 * Affiche les �l�ments graphiques dans la fen�tre de la console.
	 * @param window : pointeur sur la fenetre de l'application.
	 */
	public void draw(RenderWindow window){
		super.draw(window);
		Texte lifeBar = new Texte("life="+(int)life, 15, new Vector2f(getPosition().x,getPosition().y-16), Color.BLACK, Text.ITALIC);
		lifeBar.draw(window);
	}
	
	/**
	 * G�re le d�placement du monstre ainsi que son animation.
	 * @param positionCible : La position de la cible du monstre.
	 * @param time : Timer pour la gestion des frames.
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
