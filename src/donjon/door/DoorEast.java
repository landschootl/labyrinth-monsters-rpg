package donjon.door;

import org.jsfml.system.Vector2f;

import donjon.room.Room;

public class DoorEast extends Door {

	public DoorEast(Room nextRoom, boolean locked) {
		super(nextRoom, locked);
		// TODO Auto-generated constructor stub
		door.setPosition(18*32, 9*32);
		checkpoint.setPosition(new Vector2f(17*32,9*32));
	}

}
