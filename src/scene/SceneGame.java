package scene;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

import resource.Texte;
import console.Console;
import donjon.Donjon;
import entitee.player.Player;

/**
 * Classe qui repr�sente la sc�ne du jeu en cours.
 * @author Ludov_000
 *
 */
public class SceneGame {
	/**
	 * Pointeur sur la fenetre de l'application.
	 */
	private RenderWindow window;
	/**
	 * Le level de la partie.
	 */
	private int level = 1;
	
	private Donjon donjon = new Donjon(level);
	
	public SceneGame(RenderWindow window){
		Console.getInstance().presentation();
		this.window=window;
	}
	
	/**
	 * Augmente le level de la partie.
	 */
	public void upLevel(){
		level+=1;
		donjon = new Donjon(level);
		Player.getInstance().initPositionBegin();
	}
	
	/**
	 * Recommence la partie.
	 */
	public void restart(){
		level=1;
		donjon = new Donjon(level);
		//Player.init();
	}
	
	/**
	 * Permet de g�rer les �v�nements de la sc�ne.
	 * @param event : l'�v�nement de l'application.
	 */
	public void handleEvents(Event event) {
		Player.getInstance().handleEvents(event);
	}

	/**
	 * Permet de g�rer les actions de la sc�ne.
	 */
	public void update(Time time) {
	    donjon.update(time);
	    Player.getInstance().update();
	}

	/**
	 * Affiche les �l�ments graphiques dans la fen�tre de la sc�ne.
	 */
	public void draw() {
		Console.getInstance().draw(window);
		donjon.draw(window);
		Player.getInstance().draw(window);
		Texte textLevel = new Texte("Level : "+level, 20, new Vector2f(5,3), Color.BLACK, Text.BOLD);
		textLevel.draw(window);
	}
	
}
