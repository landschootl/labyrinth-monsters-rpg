package donjon.room;

import map.Map;

import org.jsfml.system.Time;

import scene.SceneGame;
import scene.SceneGame.EventGame;

/**
 * 
 * Class which represent the trap room of the labyrinth.
 * @author Ludov_000
 *
 */
public class RoomTrap extends Room {
	
	public RoomTrap(){
		super(Map.modeleTrap);
	}
	
	public void update(Time time){
		super.update(time);
		SceneGame.setEventOfGame(EventGame.PLAYER_FALL_INTO_TRAP);
	}
	
}
