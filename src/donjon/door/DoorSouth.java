package donjon.door;

import org.jsfml.system.Vector2f;

import donjon.room.Room;

public class DoorSouth extends Door {

	public DoorSouth(Room nextRoom, boolean locked) {
		super(nextRoom, locked);
		// TODO Auto-generated constructor stub
		door.setPosition(10*32, 18*32);
		checkpoint.setPosition(new Vector2f(10*32,17*32));
	}

}
