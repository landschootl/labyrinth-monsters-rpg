package donjon.room;

import map.Map;

import org.jsfml.system.Time;

import scene.SceneGame;
import scene.SceneGame.EventGame;

/**
 * Room end.
 * @author Ludov_000
 *
 */
public class RoomExit extends Room {
	
	public RoomExit(){
		super(Map.modeleExit);
	}
	
	public void update(Time time){
		super.update(time);
		SceneGame.setEventOfGame(EventGame.WIN_LEVEL);	
	}

}
