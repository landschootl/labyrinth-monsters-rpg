package donjon.room;

import map.Map;

public class RoomBegin extends Room {

	public RoomBegin(){
		super.map = new Map(Map.modeleBegin);
	}
	
}
