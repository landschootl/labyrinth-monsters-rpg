package resource;

import management.ResourceManager;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;



public class Texte {
	private Text text;
	
	public Texte(String message, int size, Vector2f pos, Color color, int style) {
		text = new Text(message, ResourceManager.getFont("resource/font/calibri.ttf"), size);
		text.setPosition(pos);
		text.setColor(color);
		text.setStyle(style);
	}
	
	// Fonction qui permet de gérer les événements.
	public void processEvents(Event event) {

	}

	// Fonction qui permet de gérer les actions.
	public void update() {

	}

	// Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	public void render(RenderWindow window) {
		window.draw(text);
	}
	
	// Fonction qui permet de modifier la position du texte.
	public void setPosition(Vector2f pos){
		text.setPosition(pos);
	}
	
	// Fonction qui retourne la position du texte.
	public Vector2f getPosition(){
		return text.getPosition();
	}
	
}
