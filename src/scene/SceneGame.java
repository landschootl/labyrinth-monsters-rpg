package scene;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.event.Event;

import console.Console;

/**
 * Classe qui représente la scène du jeu en cours.
 * @author Ludov_000
 *
 */
public class SceneGame {
	private RenderWindow window;
	private String stateOfGame = "Game"; // Propriété indiquant l'état de la partie.
	
	public SceneGame(RenderWindow window){
		Console.getInstance().addText("Bienvenue dans le jeu Donjon.");
		this.window=window;
	}
	
	/**
	 * Fonction qui permet de gérer les événements.
	 * @param event : l'event sur lequel on écoute.
	 */
	public void processEvents(Event event) {

	}

	/**
	 * Fonction qui permet de gérer les actions.
	 */
	public void update() {

	}

	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 */
	public void render() {
		Console.getInstance().render(window);
	}

	public String getStateOfGame() {
		return stateOfGame;
	}

	public void setStateOfGame(String stateOfGame) {
		this.stateOfGame = stateOfGame;
	}
	
}
