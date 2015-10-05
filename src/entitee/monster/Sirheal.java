package entitee.monster;

import org.jsfml.system.Clock;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;

/**
 * Classe qui représente le monstre "Sirheal".
 * Il regénère tout seul sa vie.
 * @author Ludov_000
 *
 */
public class Sirheal extends Monster{
	/**
	 * Le maximum de sa vie.
	 */
	private int MAX_LIFE = 8;
	/**
	 * Timer qui gère le temps entre deux guérisons.
	 */
	private Clock timerHeal = new Clock();
		
	public Sirheal() {
		super("Sirheal", 32, 32, 8, "resource/sprite/sirheal.png", 40, 2);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Permet de gérer les actions du monstre.
	 * @param positionCible : La position de la cible du monstre.
	 * @param time : Timer pour la gestion des frames.
	 */
	public void update(Vector2f positionCible, Time time){
		super.update(positionCible, time);
		if(timerHeal.getElapsedTime().asSeconds()>5 && life<MAX_LIFE){
			life+=1;
			timerHeal.restart();
		}
	}

}
