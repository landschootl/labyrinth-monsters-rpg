package donjon.room;

import map.Map;

import org.jsfml.system.Time;

import application.Application;
import application.Application.State;

/**
 * Classe qui reprèsente la salle de fin du labyrinthe.
 * @author Ludov_000
 *
 */
public class RoomExit extends Room {
	
	public RoomExit(){
		super(Map.modeleExit);
	}
	
	public void update(Time time){
		super.update(time);
		System.out.println("perdu");
		Application.setStateOfApp(State.GAMEOVER);	
	}

}
