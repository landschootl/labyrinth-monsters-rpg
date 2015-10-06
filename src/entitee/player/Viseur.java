package entitee.player;

import management.ResourceManager;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

/**
 * Classe qui correspond au viseur du joueur.
 * @author Ludov_000
 *
 */
public class Viseur {
	// Graphique
	private Sprite sprite = new Sprite();
	
	public Viseur(){
		sprite.setTexture(ResourceManager.getTexture("resource/sprite/viseur.png"));
	}
	
	/**
	 * Permet de gérer les événements de la scène.
	 * @param event : l'événement de l'application.
	 */
	public void handleEvents(Event event) {
		if (event.type == Event.Type.MOUSE_MOVED) {
			sprite.setPosition(new Vector2f(event.asMouseEvent().position.x-16, event.asMouseEvent().position.y-16));
		}
	}
	
	/**
	 * Affiche les éléments graphiques dans la fenêtre de la console.
	 * @param window : pointeur sur la fenetre de l'application.
	 */
	public void draw(RenderWindow window) {
		window.draw(sprite);
	}
	
	public Vector2f getPosition(){
		return sprite.getPosition();
	}
	
	public void setPosition(Vector2f position){
		sprite.setPosition(position);
	}
}
