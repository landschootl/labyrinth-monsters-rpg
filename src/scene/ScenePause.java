package scene;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.event.Event;

/**
 * Classe qui repr�sente la sc�ne lorsque la partie est en pause.
 * @author Ludov_000
 *
 */
public class ScenePause {
	private RenderWindow window;

	public ScenePause(RenderWindow window){
		this.window=window;
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
	public void show() {
		
	}
	
}
