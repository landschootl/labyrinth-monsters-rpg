package donjon.door;

import org.jsfml.system.Vector2f;

import donjon.room.Room;

/**
 * Classe qui reprèsente une porte situé à l'est.
 * @author Ludov_000
 *
 */
public class DoorEast extends Door {

	public DoorEast(Room nextRoom, boolean locked) {
		super(nextRoom, locked, new Vector2f(3*32,9*32));
		// TODO Auto-generated constructor stub
		door.setPosition(18*32, 9*32);
		checkpoint.setPosition(new Vector2f(17*32,9*32));
	}

}
