package donjon.room;

import java.util.ArrayList;

import management.CollisionManager;
import map.Map;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Time;

import donjon.door.Door;
import entitee.monster.Monster;

/**
 * Classe qui représente une salle du donjon.
 * @author Ludov_000
 *
 */
public abstract class Room {
	/**
	 * La map de la salle.
	 */
	protected Map map;
	/**
	 * Les portes présentent dans la salle.
	 */
	private ArrayList<Door> doors = new ArrayList<>();
	
	public Room(String[][] modeleMap){
		this.map = new Map(modeleMap);
	}
	
	/**
	 * Permet d'ajouter une porte dans la salle.
	 * @param door : La porte à ajouter.
	 */
	public void addDoor(Door door){
		doors.add(door);
	}
	
	/**
	 * Permet de gérer les actions de la salle.
	 * @param time : Timer pour la gestion des frames.
	 */
	public void update(Time time) {
		CollisionManager.collisionPlayerMap(this, time);
	}

	/**
	 * Affiche les éléments graphiques dans la fenêtre de la salle.
	 * @param window : pointeur sur la fenetre de l'application.
	 */
	public void draw(RenderWindow window) {
		map.draw(window);
		for(Door door : doors)
			door.draw(window);
	}
	
	/**
	 * Ajouter un monstre.
	 * @param monster : monstre à ajouter.
	 */
	public void addMonster(Monster monster){};
	
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
