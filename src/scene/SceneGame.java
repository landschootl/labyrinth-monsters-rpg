package scene;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Clock;
import org.jsfml.system.Time;
import org.jsfml.window.event.Event;

import console.Console;
import donjon.Donjon;

/**
 * Classe qui repr�sente la sc�ne du jeu en cours.
 * @author Ludov_000
 *
 */
public class SceneGame {
	private RenderWindow window;
	private Clock timerFrame = new Clock(); // Permet la gestion des frames.
	private Donjon donjon = new Donjon();
	
	public SceneGame(RenderWindow window){
		Console.getInstance().addText("Bienvenue dans le jeu Donjon.", Text.BOLD, Color.RED);
		Console.getInstance().addText("Youpi la console marche parfaitement !", Text.REGULAR, Color.BLUE);
		Console.getInstance().addText("Thibault est qu'un gland !", Text.REGULAR, Color.BLUE);
		this.window=window;
	}
	
	/**
	 * Fonction qui permet de g�rer les �v�nements.
	 * @param event : l'event sur lequel on �coute.
	 */
	public void handleEvents(Event event) {
		donjon.handleEvents(event);
	}

	/**
	 * Fonction qui permet de g�rer les actions.
	 */
	public void update() {
		// Gestion des frames.
	    Time time;
	    time=timerFrame.getElapsedTime();
	    timerFrame.restart();
		
	    donjon.update(time);
	}

	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 */
	public void draw() {
		Console.getInstance().draw(window);
		donjon.draw(window);
	}
	
}
