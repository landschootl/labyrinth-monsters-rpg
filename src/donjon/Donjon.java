package donjon;

import java.util.HashMap;
import java.util.Map;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Time;
import org.jsfml.window.event.Event;

import player.Player;

/**
 * Classe qui représente le donjon
 * @author Ludov_000
 *
 */
public class Donjon {

	//private Map rooms = new HashMap();
	private Room room = new RoomIntersect();
	private Player player = new Player();
	
	public Donjon(){
		
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
		player.move(time);
	}

	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 */
	public void draw(RenderWindow window) {
		room.draw(window);
		player.draw(window);
	}
	
}
