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
 * Classe qui repr�sente une porte permettant de changer de salle.
 * @author Ludov_000
 *
 */
public abstract class Door {
	// Logique
	/**
	 * La salle ou amm�ne la porte.
	 */
	protected Room nextRoom;
	/**
	 * La position du joueur apr�s avoir pass� la porte.
	 */
	protected Vector2f nextPositionPlayer;
	/**
	 * Si la porte est verrouill� ou non.
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
	 * Affiche les �l�ments graphiques dans la fen�tre de la porte.
	 * @param window : pointeur sur la fenetre de l'application.
	 */
	public void draw(RenderWindow window) {
		window.draw(door);
		window.draw(checkpoint);
	}
	
	/**
	 * D�v�rouille la porte.
	 */
	public void unlock(){
		locked=false;
		Console.getInstance().addText("Porte d�v�rrouill� !", Text.REGULAR, Color.BLACK);
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
