package donjon;

import management.CollisionManager;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

import player.Player;
import donjon.door.DoorEast;
import donjon.door.DoorNorth;
import donjon.door.DoorSouth;
import donjon.door.DoorWest;
import donjon.room.RoomExit;
import donjon.room.RoomIntersect;

/**
 * Classe qui représente le donjon
 * @author Ludov_000
 *
 */
public class Donjon {
	//private Map rooms = new HashMap();
	private RoomIntersect room = new RoomIntersect();
	private Player player = new Player();
	
	public Donjon(){
		room.addDoor(new DoorWest(new RoomExit(), false));
		room.addDoor(new DoorNorth(new RoomExit(), true));
		room.addDoor(new DoorEast(new RoomExit(), true));
		room.addDoor(new DoorSouth(new RoomExit(), true));
	}
	
	/**
	 * Fonction qui permet de gérer les événements.
	 * @param event : l'event sur lequel on écoute.
	 */
	public void handleEvents(Event event) {
		player.handleEvents(event);
	}

	/**
	 * Fonction qui permet de gérer les actions.
	 */
	public void update(Time time) {
		player.update();
		Vector2f lastPosition = player.getPosition();
		player.move(time);
		if(CollisionManager.collisionPlayerWall(player.getPosition()))
			player.setPosition(lastPosition);
	}

	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 */
	public void draw(RenderWindow window) {
		room.draw(window);
		player.draw(window);
	}
	
}
