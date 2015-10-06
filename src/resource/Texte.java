package resource;

import management.ResourceManager;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;


/**
 * Classe qui permet de créer et afficher un text.
 * @author Ludov_000
 *
 */
public class Texte {
	private Text text;
	
	public Texte(String message, int size, Vector2f pos, Color color, int style) {
		text = new Text(message, ResourceManager.getFont("resource/font/calibri.ttf"), size);
		text.setPosition(pos);
		text.setColor(color);
		text.setStyle(style);
	}

	/**
	 * Affiche les éléments graphiques dans la fenêtre de la console.
	 * @param window : pointeur sur la fenetre de l'application.
	 */
	public void draw(RenderWindow window) {
		window.draw(text);
	}
	
	public void setPosition(Vector2f pos){
		text.setPosition(pos);
	}
	
	public Vector2f getPosition(){
		return text.getPosition();
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}
	
	public void setString(String string){
		text.setString(string);
	}
	
}
