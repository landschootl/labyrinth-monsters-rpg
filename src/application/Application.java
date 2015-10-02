package application;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

import scene.SceneGame;
import scene.SceneGameover;
import scene.SceneMenu;
import scene.ScenePause;

/**
 * Classe permettant de gérer les différentes scènes du jeu.
 * @author Ludov_000
 *
 */
public class Application {
	public RenderWindow window = new RenderWindow();
	
	private static String stateOfApp = "Game"; // Propriété indiquant l'état de l'application.

	SceneGame sceneGame = new SceneGame(window);
	SceneMenu sceneMenu = new SceneMenu(window);
	SceneGameover sceneGameover = new SceneGameover(window);
	ScenePause scenePause = new ScenePause(window);

	public Application() {
		window.create(new VideoMode(640, 820), "Donjon");
		window.setMouseCursorVisible(false);
	}

	/**
	 * Fonction principale qui éxécute une boucle déclenchant des événements
	 * tant que la fenêtre est ouverte.
	 */
	public void run() {
		while (window.isOpen()) {
			processEvents();
			update();
			render();
		}
	}

	/**
	 * Fonction qui permet de gérer les événements.
	 */
	public void processEvents() {
		for (Event event : window.pollEvents()) {
			if (event.type == Event.Type.CLOSED) {
				window.close();
			}
			switch (stateOfApp) {
			case "Menu":
				sceneMenu.handleEvents(event);
				break;
			case "Game":
				sceneGame.handleEvents(event);
				break;
			case "GameOver":
				sceneGameover.handleEvents(event);
				break;
			case "Pause":
				scenePause.handleEvents(event);
				break;
			}
		}
	}
	
	/**
	 * Fonction qui permet de gérer les actions.
	 */
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
		case "Pause":
			scenePause.update();
			break;
		}
	}

	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 */
	public void render() {
		window.clear(Color.BLACK);
		switch (stateOfApp) {
		case "Menu":
			sceneMenu.draw();
			break;
		case "Game":
			sceneGame.draw();
			break;
		case "GameOver":
			sceneGameover.draw();
			break;
		case "Pause":
			sceneGame.draw();
			scenePause.draw();
			break;
		}
		window.display();
	}
	
	/**
	 * Fonction qui permet de changer l'état de l'application.
	 * @param stateOfApp : L'état de l'application.
	 */
	public static void setStateOfApp(String stateOfApp) {
		Application.stateOfApp = stateOfApp;
	}
	
}
