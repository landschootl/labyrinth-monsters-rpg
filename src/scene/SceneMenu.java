package scene;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.event.Event;

public class SceneMenu {
	
	public SceneMenu(){
		
	}
	
	// Fonction qui permet de g�rer les �v�nements.
	public void processEvents(Event event) {

	}

	// Fonction qui permet de g�rer les actions.
	public void update() {

	}

	// Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	public void render(RenderWindow window) {
		window.clear(Color.BLACK);

		window.display();
	}
	
}
