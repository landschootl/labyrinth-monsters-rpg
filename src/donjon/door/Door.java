package donjon.door;

import management.TilesetManager;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;

import console.Console;
import donjon.room.Room;

/**
 * 
 * Class that represents a door for changing room.
 * @author Ludov_000
 *
 */
public abstract class Door {
	// Logique
	/**
	 * the room where the door leads
	 */
	protected Room nextRoom;
	/**
	 * The position of the player when he passed a door.
	 */
	protected Vector2f nextPositionPlayer;
	/**
	 * if the door is locked or not.
	 */
	protected boolean locked;
	
	// Graphique
	protected Sprite door;
	protected Sprite checkpoint;
	
	public Door(Room nextRoom, boolean locked, Vector2f nextPositionPlayer){
		this.nextRoom=nextRoom;
		this.locked=locked;
		this.nextPositionPlayer=nextPositionPlayer;
		if(!locked)
			this.door = TilesetManager.getInstance().getSprite("doorOpen");
		else
			this.door = TilesetManager.getInstance().getSprite("doorClose");
		this.checkpoint = TilesetManager.getInstance().getSprite("checkpoint");
	}
	
	/**
	 * Shows graphics elements in the window of the door
	 * @param window : pointer on the window of the application.
	 */
	public void draw(RenderWindow window) {
		window.draw(door);
		window.draw(checkpoint);
	}
	
	/**
	 * Unlock the door.
	 */
	public void unlock(){
		locked=false;
		Console.getInstance().addText("Porte dévérouillé !", Text.REGULAR, Color.BLACK);
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
	
	public Vector2f getNextPositionPlayer(){
		return nextPositionPlayer;
	}
}
