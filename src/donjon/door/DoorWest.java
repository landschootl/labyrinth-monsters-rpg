package donjon.door;

import org.jsfml.system.Vector2f;

import donjon.room.Room;

/**
 * Classe qui reprèsente une porte situé à l'ouest.
 * @author Ludov_000
 *
 */
public class DoorWest extends Door {

	public DoorWest(Room nextRoom, boolean locked) {
		super(nextRoom, locked, new Vector2f(16*32,9*32));
		// TODO Auto-generated constructor stub
		door.setPosition(1*32, 9*32);
		checkpoint.setPosition(new Vector2f(2*32,9*32));
	}

}
