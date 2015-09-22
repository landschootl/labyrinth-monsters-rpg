package scene;

import map.Map;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.window.event.Event;

import player.Player;
import console.Console;

/**
 * Classe qui représente la scène du jeu en cours.
 * @author Ludov_000
 *
 */
public class SceneGame {
	private RenderWindow window;
	private Player player = new Player();
	
	public SceneGame(RenderWindow window){
		Console.getInstance().addText("Bienvenue dans le jeu Donjon.", Text.BOLD, Color.RED);
		Console.getInstance().addText("Youpi la console marche parfaitement !", Text.REGULAR, Color.BLUE);
		Console.getInstance().addText("Thibault est qu'un gland !", Text.REGULAR, Color.BLUE);
		this.window=window;
	}
	
	/**
	 * Fonction qui permet de gérer les événements.
	 * @param event : l'event sur lequel on écoute.
	 */
	public void processEvents(Event event) {
		player.processEvents(event);
	}

	/**
	 * Fonction qui permet de gérer les actions.
	 */
	public void update() {
		player.update();
	}

	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 */
	public void render() {
		Console.getInstance().render(window);
		player.render(window);
	}
	
}
