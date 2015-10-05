package scene;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.event.Event;

/**
 * Classe qui repr�sente la sc�ne lorsque la partie est en pause.
 * @author Ludov_000
 *
 */
public class ScenePause {
	/**
	 * Pointeur sur la fenetre de l'application.
	 */
	private RenderWindow window;

	public ScenePause(RenderWindow window){
		this.window=window;
	}
	
	/**
	 * Permet de g�rer les �v�nements de la sc�ne.
	 * @param event : l'�v�nement de l'application.
	 */
	public void handleEvents(Event event) {

	}

	/**
	 * Permet de g�rer les actions de la sc�ne.
	 */
	public void update() {

	}

	/**
	 * Affiche les �l�ments graphiques dans la fen�tre de la sc�ne.
	 */
	public void draw() {
		
	}
	
}
