package donjon.door;

import org.jsfml.system.Vector2f;

import donjon.room.Room;

/**
 * South door.
 * @author Ludov_000
 *
 */
public class DoorSouth extends Door {

	public DoorSouth(Room nextRoom, boolean locked) {
		super(nextRoom, locked, new Vector2f(10*32,3*32));
		// TODO Auto-generated constructor stub
		door.setPosition(10*32, 18*32);
		checkpoint.setPosition(new Vector2f(10*32,17*32));
	}

}
