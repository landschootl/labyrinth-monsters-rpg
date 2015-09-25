package donjon;

import java.util.HashMap;
import java.util.Map;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.event.Event;

/**
 * Classe qui repr�sente le donjon
 * @author Ludov_000
 *
 */
public class Donjon {

	private Map rooms = new HashMap();
	private Room room;
	
	public Donjon(){
		room = new RoomIntersect();
	}
	
	/**
	 * Fonction qui permet de g�rer les �v�nements.
	 * @param event : l'event sur lequel on �coute.
	 */
	public void handleEvents(Event event) {

	}

	/**
	 * Fonction qui permet de g�rer les actions.
	 */
	public void update() {

	}

	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 */
	public void draw(RenderWindow window) {
		room.draw(window);
	}
	
}
