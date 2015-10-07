package donjon.room;

import map.Map;

/**
 * 
 * Class which represent a transition room between the differents rooms of the labyrinth.
 * @author Ludov_000
 *
 */
public class RoomIntersect extends RoomInteractif {
	
	public RoomIntersect(){
		super(Map.modeleIntersection[(int)(Math.random()*9)]);
	}
	
}
