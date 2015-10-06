package object;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;

import resource.Texte;

/**
 * Classe qui reprèsente les objets du jeu.
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
	 * L'object est ramassé.
	 */
	public abstract void pickUp();
	
	/**
	 * Affiche les éléments graphiques dans la fenêtre de la console avec le nom au dessus de l'object.
	 * @param window : pointeur sur la fenetre de l'application.
	 */
	public void drawWithName(RenderWindow window){
		draw(window);
		textName.draw(window);
	}
	
	/**
	 * Affiche les éléments graphiques dans la fenêtre de la console.
	 * @param window : pointeur sur la fenetre de l'application.
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
	}
	
	public Vector2f getPosition(){
		return sprite.getPosition();
	}
	
	public Sprite getSprite(){
		return sprite;
	}
	
}
