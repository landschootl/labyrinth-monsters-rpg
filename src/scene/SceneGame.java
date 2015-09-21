package scene;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.event.Event;

import console.Console;

/**
 * Classe qui repr�sente la sc�ne du jeu en cours.
 * @author Ludov_000
 *
 */
public class SceneGame {
	private RenderWindow window;
	
	public SceneGame(RenderWindow window){
		Console.getInstance().addText("Bienvenue dans le jeu Donjon.");
		this.window=window;
	}
	
	/**
	 * Fonction qui permet de g�rer les �v�nements.
	 * @param event : l'event sur lequel on �coute.
	 */
	public void processEvents(Event event) {

	}

	/**
	 * Fonction qui permet de g�rer les actions.
	 */
	public void update() {

	}

	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 */
	public void render() {
		Console.getInstance().render(window);
	}
	
}
