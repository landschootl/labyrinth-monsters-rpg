package object;

import org.jsfml.graphics.Sprite;

/**
 * Cette class reprèsente les objets du jeu.
 * @author Ludov_000
 *
 */
public abstract class Object {
	protected Sprite sprite;
	protected String name;
	
	public Object(Sprite sprite, String name){
		this.sprite = sprite;
		this.name = name;
	}
	
	public abstract void pickUp();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
