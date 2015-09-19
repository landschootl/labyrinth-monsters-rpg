package resource;

import java.io.IOException;
import java.nio.file.Paths;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;



public class Texte {
	private Font font = new Font();
	private Text text;
	
	public Texte(String message, int size, Vector2f pos, Color color, int style) {
		try {
			font.loadFromFile(Paths.get("sgsdg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		text = new Text(message, font, size);
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
	
}
