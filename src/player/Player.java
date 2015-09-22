package player;

import management.ResourceManager;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Mouse;
import org.jsfml.window.event.Event;

/**
 * Cette classe représente le joueur dans  le jeu.
 * @author Ludov_000
 *
 */
public class Player {
	private int nbMaxLife = 3;
	private int nbLife = 3;
	
	private Sprite viseur = new Sprite();
	
	public Player(){
		viseur.setTexture(ResourceManager.getTexture("resource/sprite/viseur.png"));
	}
	
	/**
	 * Fonction qui permet de gérer les événements.
	 * @param event : l'événement sur lequel on écoute.
	 */
	public void processEvents(Event event) {
		if (event.type == Event.Type.MOUSE_MOVED) {
			viseur.setPosition(new Vector2f(event.asMouseEvent().position.x-16, event.asMouseEvent().position.y-16));
		}
	}

	/**
	 * Fonction qui permet de gérer les actions.
	 */
	public void update() {
		
	}

	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 * @param window : La fenetre sur laquel on souhaite afficher les éléments.
	 */
	public void render(RenderWindow window) {
		window.draw(viseur);
	}
}
