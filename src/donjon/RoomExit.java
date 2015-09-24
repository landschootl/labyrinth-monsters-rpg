package donjon;

import map.Map;

public class RoomExit extends Room {
	
	public RoomExit(){
		super.map = new Map(Map.modeleExit);
	}

}
