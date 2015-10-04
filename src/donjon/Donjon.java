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
		RoomIntersect roomTmp = new RoomIntersect();
		roomTmp.addMonster(new Zombie(new Vector2f(100,100)));
		roomTmp.addDoor(new DoorWest(new RoomExit(), false));
		roomTmp.addDoor(new DoorNorth(new RoomTrap(), true));
		roomTmp.addDoor(new DoorEast(new RoomExit(), true));
		roomTmp.addDoor(new DoorSouth(new RoomExit(), true));
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
		
		Vector2f lastPosition = Player.getInstance().getPosition();
		Player.getInstance().move(time);
		// Collision playerMur
		if(CollisionManager.collisionPlayerWall(Player.getInstance().getPosition()))
			Player.getInstance().setPosition(lastPosition);
		// Collision playerDoor
		Door doorTmp = CollisionManager.collisionPlayerDoors(Player.getInstance().getPosition(), room.getDoors());
		if(doorTmp!=null)
			if(!doorTmp.isLocked()){
				System.out.println(time.asSeconds());
				if(time.asMicroseconds()%500==0)
					Console.getInstance().addText("La porte est verrouillé !", Text.REGULAR, Color.RED);
			} else {
				room=doorTmp.getNextRoom();
			}
		// Collision playerCoffre
	}

	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 */
	public void draw(RenderWindow window) {
		room.draw(window);
		Player.getInstance().draw(window);
	}
}
