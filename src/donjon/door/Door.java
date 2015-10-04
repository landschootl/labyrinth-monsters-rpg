package donjon.door;

import management.TilesetManager;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;

import donjon.room.Room;

/**
 * Class qui reprèsente un porte dans une room.
 * @author Ludov_000
 *
 */
public abstract class Door {
	protected Sprite door;
	protected Sprite checkpoint;
	protected Room nextRoom;
	protected boolean locked;
	
	public Door(Room nextRoom, boolean locked){
		this.nextRoom=nextRoom;
		this.locked=locked;
		if(locked)
			this.door = TilesetManager.getInstance().getSprite("doorOpen");
		else
			this.door = TilesetManager.getInstance().getSprite("doorClose");
		this.checkpoint = TilesetManager.getInstance().getSprite("checkpoint");
	}
	
	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 */
	public void draw(RenderWindow window) {
		window.draw(door);
		window.draw(checkpoint);
	}
	
	public Vector2f getPosition(){
		return checkpoint.getPosition();
	}

	public Room getNextRoom() {
		return nextRoom;
	}

	public void setNextRoom(Room nextRoom) {
		this.nextRoom = nextRoom;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}
}
