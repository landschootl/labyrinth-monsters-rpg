package resource;

import management.ResourceManager;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;


/**
 * Classe permettant de g�n�rer un texte.
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
	 * Fonction qui permet de g�rer les �v�nements.
	 * @param event : l'event sur lequel on �coute.
	 */
	public void handleEvents(Event event) {

	}

	/**
	 * Fonction qui permet de g�rer les actions.
	 */
	public void update() {

	}

	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 * @param window : la fen�tre sur lequel on souhaite afficher les �l�ments.
	 */
	public void show(RenderWindow window) {
		window.draw(text);
	}
	
	public void setPosition(Vector2f pos){
		text.setPosition(pos);
	}
	
	public Vector2f getPosition(){
		return text.getPosition();
	}
	
}
