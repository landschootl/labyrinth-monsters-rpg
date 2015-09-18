import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

import scene.SceneGame;
import scene.SceneGameover;
import scene.SceneMenu;

public class Application {
	public RenderWindow window = new RenderWindow();

	SceneGame sceneGame = new SceneGame(window);
	SceneMenu sceneMenu = new SceneMenu(window);
	SceneGameover sceneGameover = new SceneGameover(window);

	public Application() {
		window.create(new VideoMode(640, 800), "Donjon");
	}

	// Fonction principale qui �x�cute une boucle d�clenchant des �v�nements
	// tant que la fen�tre est ouverte.
	public void run() {
		while (window.isOpen()) {
			processEvents();
			update();
			render();
		}
	}

	// Fonction qui permet de g�rer les �v�nements.
	public void processEvents() {
		for (Event event : window.pollEvents()) {
			if (event.type == Event.Type.CLOSED) {
				window.close();
			}
			switch (sceneGame.getStateOfGame()) {
			case "Menu":
				sceneMenu.processEvents(event);
				break;
			case "Game":
				sceneGame.processEvents(event);
				break;
			case "GameOver":
				sceneGameover.processEvents(event);
				break;
			}
		}
	}

	// Fonction qui permet de g�rer les actions.
	public void update() {
		switch (sceneGame.getStateOfGame()) {
		case "Menu":
			sceneMenu.update();
			break;
		case "Game":
			sceneGame.update();
			break;
		case "GameOver":
			sceneGameover.update();
			break;
		}
	}

	// Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	public void render() {
		window.clear(Color.BLACK);
		switch (sceneGame.getStateOfGame()) {
		case "Menu":
			sceneMenu.render();
			break;
		case "Game":
			sceneGame.render();
			break;
		case "GameOver":
			sceneGameover.render();
			break;
		}
		window.display();
	}
	
}
