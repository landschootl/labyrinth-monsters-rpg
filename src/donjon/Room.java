package donjon;

import org.jsfml.window.event.Event;

/**
 * Classe qui représente une salle du donjon.
 * @author Ludov_000
 *
 */
public abstract class Room {
	
	public Room(){
		
	}
	
	/**
	 * Fonction qui permet de gérer les événements.
	 * @param event : l'event sur lequel on écoute.
	 */
	public void handleEvents(Event event) {

	}

	/**
	 * Fonction qui permet de gérer les actions.
	 */
	public void update() {

	}

	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 */
	public void show() {
		
	}

}
