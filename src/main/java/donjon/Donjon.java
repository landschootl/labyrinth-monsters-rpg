package donjon;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

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
import entitee.monster.Monster;
import entitee.player.Player;

/**
 * the class represent the game dungeon.
 * @author Ludov_000
 *
 */
public class Donjon {
	/**
	 * all dungeon rooms.
	 */
	private HashMap<String, Room> rooms = new HashMap<String, Room>();
	/**
	 * start map.
	 */
	private Room roomBegin;
	/**
	 * current room.
	 */
	private Room room;
	
	public Donjon(int level){
		generateDonjon(level);
	}
	
	/**
	 * Create the differents rooms of the dungeon.
	 * @param level :level of the game.
	 */
	public void generateDonjon(int level) {
		File file = new File("src/main/resources/level/level" +level+".txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (IOException e) {
			System.err.println("Impossible d'ouvrir le fichier du niveau");
			e.printStackTrace();
		}
		String idRoom;
		sc.next();
		// Create rooms
		while(sc.hasNextInt()) { // On v�rifie si c'est bien un un nombre qui suit
			idRoom = sc.next(); // Mais on le r�cup�re en string (plus facile pour la hashmap)
			rooms.put(idRoom,Room.generateRoomById(sc.next()));
		}
		sc.next();
		// Create doors
		while(sc.hasNextInt()) {
			idRoom = sc.next();
			String idNextRoom = sc.next();
			if(!idNextRoom.equals("0"))
				rooms.get(idRoom).addDoor(new DoorWest(rooms.get(idNextRoom),sc.nextBoolean()));
			idNextRoom = sc.next();
			if(!idNextRoom.equals("0"))
				rooms.get(idRoom).addDoor(new DoorNorth(rooms.get(idNextRoom),sc.nextBoolean()));
			idNextRoom = sc.next();
			if(!idNextRoom.equals("0"))
				rooms.get(idRoom).addDoor(new DoorEast(rooms.get(idNextRoom),sc.nextBoolean()));
			idNextRoom = sc.next();
			if(!idNextRoom.equals("0"))
				rooms.get(idRoom).addDoor(new DoorSouth(rooms.get(idNextRoom),sc.nextBoolean()));
		}
		sc.next();
		sc.nextLine();
		// Create monster
		while(sc.hasNextLine()) {
			String[] str =  sc.nextLine().split(" ");
			idRoom = str[0];
			for(int i=1; i<str.length; i++)
				rooms.get(idRoom+"").addMonster(Monster.generateMonsterById(str[i]));
		}
		
		roomBegin = rooms.get("1");
		room = roomBegin;
	}
	
	/**
	 * enable to manage the actions of the scene.
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
	 * Shows the graphics elements in the window of the scene.
	 */
	public void draw(RenderWindow window) {
		room.draw(window);
	}
	
	/**
	 * Change the current room.
	 * @param door : the door that allows changing romm.
	 */
	public void changedRoom(Door door){
		Console.getInstance().addText("Vous avez chang� de salle !", Text.REGULAR, Color.BLACK);
		this.room=door.getNextRoom();
		Player.getInstance().setPosition(door.getNextPositionPlayer());
	}

	/**
	 * Return in the begin room of the dungeon.
	 */
	public void returnBeginRoom() {
		// TODO Auto-generated method stub
		room = roomBegin;
	}

	public HashMap<String, Room> getRooms() {
		return rooms;
	}

	public Room getRoom() {
		return room;
	}
	
	public Room getRoomBegin() {
		return roomBegin;
	}
	
}
