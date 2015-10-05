package object;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;

import resource.Texte;

/**
 * Cette class reprèsente les objets du jeu.
 * @author Ludov_000
 *
 */
public abstract class Object {
	protected Sprite sprite;
	protected String name;
	protected Texte textName;
	
	public Object(Sprite sprite, String name){
		this.sprite = sprite;
		this.name = name;
		textName = new Texte(name, 15, sprite.getPosition(), Color.BLACK, Text.ITALIC);
	}
	
	public abstract void pickUp();
	
	public void drawWithName(RenderWindow window){
		window.draw(sprite);
		textName.draw(window);
	}
	
	public void draw(RenderWindow window){
		window.draw(sprite);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPosition(Vector2f position){
		sprite.setPosition(position);
		textName.setPosition(new Vector2f(position.x+6,position.y-10));
	}
	
	public Vector2f getPosition(){
		return sprite.getPosition();
	}
	
	public Sprite getSprite(){
		return sprite;
	}
	
}
