package donjon;

import map.Map;

public class RoomIntersect extends Room {

	public RoomIntersect(){
		super.map = new Map(Map.modeleIntersection);
	}
	
}
