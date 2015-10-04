package entitee.player;

import management.ResourceManager;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

/**
 * Class qui correspond au viseur du joueur.
 * @author Ludov_000
 *
 */
public class Viseur {
	private Sprite sprite = new Sprite();
	
	public Viseur(){
		sprite.setTexture(ResourceManager.getTexture("resource/sprite/viseur.png"));
	}
	
	/**
	 * Fonction qui permet de gérer les événements.
	 * @param event : l'événement sur lequel on écoute.
	 */
	public void handleEvents(Event event) {
		if (event.type == Event.Type.MOUSE_MOVED) {
			sprite.setPosition(new Vector2f(event.asMouseEvent().position.x-16, event.asMouseEvent().position.y-16));
		}
	}
	
	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 * @param window : La fenetre sur laquel on souhaite afficher les éléments.
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
