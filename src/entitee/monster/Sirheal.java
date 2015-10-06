package entitee.monster;

import org.jsfml.system.Clock;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;

/**
 * "Sirheal" monster.
 * it regenerates
 * @author Ludov_000
 *
 */
public class Sirheal extends Monster{
	/**
	 * max life.
	 */
	private int MAX_LIFE = 8;
	/**
	 * this timer manage the time between two healing.
	 */
	private Clock timerHeal = new Clock();
		
	public Sirheal() {
		super("Sirheal", 32, 32, 8, "resource/sprite/sirheal.png", 40, 2);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * enable to manage monster actions.
	 * @param positionCible : monster target position.
	 * @param time : Timer for frames manage.
	 */
	public void update(Vector2f positionCible, Time time){
		super.update(positionCible, time);
		if(timerHeal.getElapsedTime().asSeconds()>5 && life<MAX_LIFE){
			life+=1;
			timerHeal.restart();
		}
	}

}
