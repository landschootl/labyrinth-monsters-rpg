package donjon.room;

import map.Map;

import org.jsfml.system.Time;

import entitee.player.Player;

/**
 * Classe qui reprèsente la salle piege du labyrinthe.
 * @author Ludov_000
 *
 */
public class RoomTrap extends Room {
	
	public RoomTrap(){
		super(Map.modeleTrap);
	}
	
	public void update(Time time){
		super.update(time);
		Player.getInstance().loseLife((int)Player.getInstance().getLife()/3);
		Player.getInstance().initPositionBegin();
	}
	
}
