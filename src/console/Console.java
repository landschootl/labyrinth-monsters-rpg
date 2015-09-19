package console;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

public class Console {
	private RectangleShape background;
	
	public Console(){
		initBackground();
	}
	
	// Fonction qui initialise le background de la console.
	private void initBackground() {
		background = new RectangleShape(new Vector2f(272,120));
		background.setFillColor(new Color(Color.BLACK, 0));
		background.setOutlineThickness(8);
		background.setOutlineColor(new Color(Color.WHITE, 0));
		background.setPosition(new Vector2f(0,680));
	}
	
	// Fonction qui permet de gérer les événements.
	public void processEvents(Event event) {

	}

	// Fonction qui permet de gérer les actions.
	public void update() {

	}

	// Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	public void render(RenderWindow window) {
		window.draw(background);
	}
}
