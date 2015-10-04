package donjon.room;

import application.Application;
import map.Map;

public class RoomExit extends Room {
	
	public RoomExit(){
		super(Map.modeleExit);
	}
	
	public void update(){
		Application.setStateOfApp("GameOver");	
	}

}
