package object;

import org.jsfml.graphics.Sprite;

/**
 * Cette class reprèsente les objets du jeu.
 * @author Ludov_000
 *
 */
public abstract class Object {
	protected Sprite sprite;
	
	public Object(Sprite sprite){
		this.sprite = sprite;
	}
	
	public abstract void pickUp();
}
