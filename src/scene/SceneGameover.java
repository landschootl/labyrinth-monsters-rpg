package scene;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.event.Event;

public class SceneGameover {
	private RenderWindow window;

	public SceneGameover(RenderWindow window){
		this.window=window;
	}
	
	// Fonction qui permet de gérer les événements.
	public void processEvents(Event event) {

	}

	// Fonction qui permet de gérer les actions.
	public void update() {

	}

	// Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	public void render() {
		window.clear(Color.BLACK);

		window.display();
	}
	
}
