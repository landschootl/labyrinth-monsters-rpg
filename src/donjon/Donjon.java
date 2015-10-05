package donjon;

import management.CollisionManager;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

import console.Console;
import donjon.door.Door;
import donjon.door.DoorEast;
import donjon.door.DoorNorth;
import donjon.door.DoorSouth;
import donjon.door.DoorWest;
import donjon.room.Room;
import donjon.room.RoomExit;
import donjon.room.RoomIntersect;
import donjon.room.RoomTrap;
import entitee.monster.Zombie;
import entitee.player.Player;

/**
 * Classe qui représente le donjon
 * @author Ludov_000
 *
 */
public class Donjon {
	//private Map rooms = new HashMap();
	private Room room;
	
	public Donjon(){
		createDonjon();
	}
	
	public void createDonjon(){
		RoomIntersect roomTmp = new RoomIntersect();
		roomTmp.addMonster(new Zombie(new Vector2f(100,100)));
		roomTmp.addMonster(new Zombie(new Vector2f(150,150)));
		roomTmp.addDoor(new DoorWest(new RoomExit(), true));
		roomTmp.addDoor(new DoorNorth(new RoomTrap(), false));
		roomTmp.addDoor(new DoorEast(new RoomExit(), false));
		roomTmp.addDoor(new DoorSouth(new RoomExit(), false));
		room = roomTmp;
	}
	
	/**
	 * Fonction qui permet de gérer les événements.
	 * @param event : l'event sur lequel on écoute.
	 */
	public void handleEvents(Event event) {
		Player.getInstance().handleEvents(event);
	}

	/**
	 * Fonction qui permet de gérer les actions.
	 */
	public void update(Time time){
		Player.getInstance().update();
		room.update(time);
		
		Door doorTmp = CollisionManager.collisionPlayerDoors(room.getDoors());
		if(doorTmp!=null)
			if(doorTmp.isLocked()){
				if(Player.getInstance().getInventory().useKey()){
					doorTmp.setLocked(true);
					Console.getInstance().addText("Porte dévérrouillé !", Text.REGULAR, Color.BLACK);
					changedRoom(doorTmp.getNextRoom());
				}
			} else {
				changedRoom(doorTmp.getNextRoom());
			}
	}

	public void changedRoom(Room room){
		Console.getInstance().addText("Vous avez changé de salle !", Text.REGULAR, Color.GREEN);
		this.room=room;
	}
	
	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 */
	public void draw(RenderWindow window) {
		room.draw(window);
		Player.getInstance().draw(window);
	}
}
