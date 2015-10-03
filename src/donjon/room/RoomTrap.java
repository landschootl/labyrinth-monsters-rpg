package donjon.room;

import map.Map;

public class RoomTrap extends Room {
	
	public RoomTrap(){
		super.map = new Map(Map.modeleTrap);
	}
	
}
