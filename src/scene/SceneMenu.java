package scene;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.event.Event;

/**
 * Classe qui reprèsente la scène lorsque le joueur est sur le menu.
 * @author Ludov_000
 *
 */
public class SceneMenu {
	/**
	 * Pointeur sur la fenetre de l'application.
	 */
	private RenderWindow window;

	public SceneMenu(RenderWindow window) {
		this.window=window;
	}

	/**
	 * Permet de gérer les événements de la scène.
	 * @param event : l'événement de l'application.
	 */
	public void handleEvents(Event event) {

	}

	/**
	 * Permet de gérer les actions de la scène.
	 */
	public void update() {

	}

	/**
	 * Affiche les éléments graphiques dans la fenêtre de la scène.
	 */
	public void draw() {
		
	}

}
