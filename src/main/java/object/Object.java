package object;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;

import resources.Texte;

/**
 * this class represent game objects.
 * @author Ludov_000
 *
 */
public abstract class Object {
	// Logique
	/**
	 * Le nom de l'object.
	 */
	protected String name;
	
	// Graphique
	protected Sprite sprite;
	protected Texte textName;
	
	public Object(Sprite sprite, String name){
		this.sprite = sprite;
		this.name = name;
		textName = new Texte(name, 15, sprite.getPosition(), Color.BLACK, Text.ITALIC);
	}
	
	/**
	 * L'object est ramass�.
	 */
	public abstract void pickUp();
	
	/**
	 * Show the graphics elements in the windows of the console.
	 * @param window : pointer on the window of the application.
	 */
	public void drawWithName(RenderWindow window){
		draw(window);
		textName.draw(window);
	}
	
	/**
	 * Show the graphics elements in the windows of the console.
	 * @param window : pointer on the window of the application.
	 */
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
		textName.setPosition(new Vector2f(getPosition().x+(sprite.getLocalBounds().width-textName.getText().getGlobalBounds().width)/2,getPosition().y-16));
	}
	
	public Vector2f getPosition(){
		return sprite.getPosition();
	}
	
	public Sprite getSprite(){
		return sprite;
	}
	
}
