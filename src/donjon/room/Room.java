package donjon.room;

import java.util.ArrayList;

import map.Map;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Time;
import org.jsfml.window.event.Event;

import donjon.door.Door;
import entitee.monster.Monster;
import entitee.player.Player;

/**
 * Classe qui représente une salle du donjon.
 * @author Ludov_000
 *
 */
public abstract class Room {
	protected Map map;
	private ArrayList<Door> doors = new ArrayList<>();
	
	public Room(){
		
	}
	
	/**
	 * Fonction qui permet d'ajouter une porte dans la salle.
	 * @param door : La porte à ajouter.
	 */
	public void addDoor(Door door){
		doors.add(door);
	}
	
	/**
	 * Fonction qui permet de gérer les événements.
	 * @param event : l'event sur lequel on écoute.
	 */
	public void handleEvents(Event event) {

	}

	/**
	 * Fonction qui permet de gérer les actions.
	 * @param time 
	 * @param player 
	 */
	public void update(Player player, Time time) {

	}

	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 */
	public void draw(RenderWindow window) {
		map.draw(window);
		for(Door door : doors)
			door.draw(window);
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
