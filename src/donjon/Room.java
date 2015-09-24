package donjon;

import map.Map;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.event.Event;

/**
 * Classe qui repr�sente une salle du donjon.
 * @author Ludov_000
 *
 */
public abstract class Room {
	protected Map map;
	
	public Room(){
		
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
	public void show(RenderWindow window) {
		map.show(window);
	}

}
