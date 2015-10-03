package donjon.door;

import org.jsfml.system.Vector2f;

import donjon.room.Room;

public class DoorNorth extends Door {

	public DoorNorth(Room nextRoom, boolean locked) {
		super(nextRoom, locked);
		// TODO Auto-generated constructor stub
		door.setPosition(10*32, 1*32);
		checkpoint.setPosition(new Vector2f(10*32,2*32));
	}

}
