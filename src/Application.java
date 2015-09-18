import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;


public class Application {
	public RenderWindow window = new RenderWindow();
	
	public Application(){
		window.create(new VideoMode(640, 800), "Donjon");
	}

	// Fonction principale qui éxécute une boucle déclenchant des événements tant que la fenêtre est ouverte.
	public void run(){
		while (window.isOpen()) {
			processEvents();
			update();
			render();
		}
	}
	
	// Fonction qui permet de gérer les événements.
	public void processEvents(){
		for (Event event : window.pollEvents()) {
			if (event.type == Event.Type.CLOSED) {
				window.close();
			}
			
		}
	}
	
	// Fonction qui permet de gérer les actions.
	public void update(){
		
	}
	
	// Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	public void render(){
		window.clear(Color.BLACK);
		
		window.display();
	}
}
