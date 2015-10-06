package donjon.room;

import java.util.ArrayList;

import management.CollisionManager;
import map.Map;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Time;

import donjon.door.Door;
import entitee.monster.Monster;

/**
 * Class which represent a room of the dungeon.
 * @author Ludov_000
 *
 */
public abstract class Room {
	/**
	 * map of the room.
	 */
	protected Map map;
	/**
	 * The doors in the room.
	 */
	private ArrayList<Door> doors = new ArrayList<>();
	
	public Room(String[][] modeleMap){
		this.map = new Map(modeleMap);
	}
	
	/**
	 * Enable to add a door in the room.
	 * @param door : added door.
	 */
	public void addDoor(Door door){
		doors.add(door);
	}
	
	/**
	 * enable to manage the actions of the room.
	 * @param time : Timer for the manage of the frames.
	 */
	public void update(Time time) {
		CollisionManager.collisionPlayerMap(this, time);
	}

	/**
	 * Shows the graphics elements in the window of the room
	 * @param window : Pointer on the window of the application.
	 */
	public void draw(RenderWindow window) {
		map.draw(window);
		for(Door door : doors)
			door.draw(window);
	}
	
	/**
	 * Add a monster.
	 * @param monster : added monster.
	 */
	public void addMonster(Monster monster){};
	
	/**
	 * Return a room identified by an id.
	 * @param id : id of the room.
	 * @return room
	 */
	public static Room generateRoomById(String id) {
		switch(id) {
		case "1":
			return new RoomBegin();
		case "2":
			return new RoomIntersect();
		case "3":
			return new RoomTrap();
		case "4":
			return new RoomExit();
		default:
			return null;
		}
	}
	
	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
	
	public ArrayList<Door> getDoors() {
		return doors;
	}

	public void setDoors(ArrayList<Door> doors) {
		this.doors = doors;
	}

}
