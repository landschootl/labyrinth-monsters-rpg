package entitee.player;

import management.ResourceManager;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

/**
 * Player target.
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
	 * Enable to manage scene events.
	 * @param event : Application events.
	 */
	public void handleEvents(Event event) {
		if (event.type == Event.Type.MOUSE_MOVED) {
			sprite.setPosition(new Vector2f(event.asMouseEvent().position.x-16, event.asMouseEvent().position.y-16));
		}
	}
	
	/**
	 * Show graphics elements in the window of the console.
	 * @param window : pointer on the window of application.
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
