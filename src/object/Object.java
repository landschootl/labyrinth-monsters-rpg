package object;

import org.jsfml.graphics.Sprite;

/**
 * Cette class reprèsente les objets du jeu.
 * @author Ludov_000
 *
 */
public abstract class Object {
	private Sprite sprite;
	
	public Object(){
		
	}
	
	public abstract void action();
	
	public abstract void pickUp();
}
