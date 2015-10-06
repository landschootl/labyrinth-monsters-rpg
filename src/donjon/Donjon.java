package donjon;

import java.util.HashMap;

import management.CollisionManager;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Time;

import console.Console;
import donjon.door.Door;
import donjon.door.DoorEast;
import donjon.door.DoorNorth;
import donjon.door.DoorSouth;
import donjon.door.DoorWest;
import donjon.room.Room;
import donjon.room.RoomBegin;
import donjon.room.RoomExit;
import donjon.room.RoomIntersect;
import donjon.room.RoomTrap;
import entitee.monster.Barroc;
import entitee.monster.Malloc;
import entitee.monster.Rodeur;
import entitee.monster.Runner;
import entitee.monster.Sirheal;
import entitee.player.Player;

/**
 * Classe qui représente le donjon de la partie.
 * @author Ludov_000
 *
 */
public class Donjon {
	/**
	 * Toutes les salles du donjon.
	 */
	private HashMap<Integer, Room> rooms = new HashMap<Integer, Room>();
	/**
	 * La room de départ.
	 */
	private Room roomBegin;
	/**
	 * La salle courrante sur laquel on se trouve.
	 */
	private Room room;
	
	public Donjon(int level){
		createDonjon(level);
	}
	
	/**
	 * Créer les différentes salles du donjon.
	 * @param level : Le level de la partie.
	 */
	public void createDonjon(int level){
		Room room1 = new RoomBegin();
//		room1.addMonster(new Rodeur());
//		room1.addMonster(new Rodeur());
		room1.addMonster(new Malloc());
		room1.addMonster(new Barroc());
		room1.addMonster(new Runner());
		room1.addMonster(new Barroc());
		room1.addMonster(new Sirheal());
		rooms.put(1, room1);
		
		Room room2 = new RoomIntersect();
		room2.addMonster(new Rodeur());
		room2.addMonster(new Rodeur());
		room2.addMonster(new Runner());
		room2.addMonster(new Runner ());
		room2.addMonster(new Rodeur());
		room2.addMonster(new Rodeur());
		room2.addMonster(new Rodeur());
		rooms.put(2, room2);
		
		room1.addDoor(new DoorWest(room2, false));
		room1.addDoor(new DoorNorth(new RoomTrap(), false));
		room1.addDoor(new DoorEast(new RoomExit(), true));
		
		room2.addDoor(new DoorWest(new RoomTrap(), false));
		room2.addDoor(new DoorNorth(new RoomTrap(), false));
		room2.addDoor(new DoorEast(room1, false));
		room2.addDoor(new DoorSouth(new RoomTrap(), false));
		roomBegin = room1;
		room = roomBegin;
	}

	/**
	 * Permet de gérer les actions de la scène.
	 */
	public void update(Time time){
		room.update(time);
		
		Door doorTmp = CollisionManager.collisionPlayerDoors(room.getDoors());
		if(doorTmp!=null)
			if(doorTmp.isLocked()){
				if(Player.getInstance().getInventory().useKey()){
					doorTmp.unlock();
				}
			} else {
				changedRoom(doorTmp);
			}
	}
	
	/**
	 * Affiche les éléments graphiques dans la fenêtre de la scène.
	 */
	public void draw(RenderWindow window) {
		room.draw(window);
	}
	
	/**
	 * Change la room courante.
	 * @param door : la porte empruntée pour changer de salle.
	 */
	public void changedRoom(Door door){
		Console.getInstance().addText("Vous avez changé de salle !", Text.REGULAR, Color.GREEN);
		this.room=door.getNextRoom();
		Player.getInstance().setPosition(door.getNextPositionPlayer());
	}
}
