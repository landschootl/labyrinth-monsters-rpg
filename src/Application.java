import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

import scene.SceneGame;
import scene.SceneGameover;
import scene.SceneMenu;

public class Application {
	public RenderWindow window = new RenderWindow();

	SceneGame sceneGame = new SceneGame();
	SceneMenu sceneMenu = new SceneMenu();
	SceneGameover sceneGameover = new SceneGameover();

	private String stateOfApp = "Menu";

	public Application() {
		window.create(new VideoMode(640, 800), "Donjon");
	}

	// Fonction principale qui éxécute une boucle déclenchant des événements
	// tant que la fenêtre est ouverte.
	public void run() {
		while (window.isOpen()) {
			processEvents();
			update();
			render();
		}
	}

	// Fonction qui permet de gérer les événements.
	public void processEvents() {
		for (Event event : window.pollEvents()) {
			if (event.type == Event.Type.CLOSED) {
				window.close();
			}
			switch (stateOfApp) {
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

	// Fonction qui permet de gérer les actions.
	public void update() {
		switch (stateOfApp) {
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
		switch (stateOfApp) {
		case "Menu":
			sceneMenu.render(window);
			break;
		case "Game":
			sceneGame.render(window);
			break;
		case "GameOver":
			sceneGameover.render(window);
			break;
		}
		window.display();
	}

	// Fonction qui change l'état de la partie en Menu.
	public void changedStateInMenu(){
		stateOfApp = "Menu";
	}
	
	// Fonction qui change l'état de la partie en Game.
	public void changedStateInGame(){
		stateOfApp = "Game";
	}
	
	// Fonction qui change l'état de la partie en GameOver.
	public void changedStateInGameover(){
		stateOfApp = "GameOver";
	}
}
