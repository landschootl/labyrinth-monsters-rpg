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
 * Classe qui gére les différentes scènes de l'application.
 * @author Ludov_000
 *
 */
public class Application {
	/**
	 * La fenetre de l'application.
	 */
	public RenderWindow window = new RenderWindow();
	
	/**
	 * Les différentes étapes de l'application possible.
	 * @author Ludov_000
	 *
	 */
	public enum State {
		GAME,
		GAMEOVER,
		MENU,
		PAUSE
	}
	
	/**
	 * Indique l'état en cours de l'application.
	 */
	private static State stateOfApp = State.GAME;

	SceneGame sceneGame = new SceneGame(window);
	SceneMenu sceneMenu = new SceneMenu(window);
	SceneGameover sceneGameover = new SceneGameover(window);
	ScenePause scenePause = new ScenePause(window);

	public Application() {
		window.create(new VideoMode(640, 820), "Donjon");
		window.setMouseCursorVisible(false);
	}
	
	/**
	 * Boucle principale de l'application qui tourne tant que la fenetre est ouverte.
	 */
	public void run() {
		while (window.isOpen()) {
			processEvents();
			update();
			render();
		}
	}

	/**
	 * Gère les événements de l'application.
	 */
	public void processEvents() {
		for (Event event : window.pollEvents()) {
			if (event.type == Event.Type.CLOSED) {
				window.close();
			}
			switch (stateOfApp) {
			case MENU:
				sceneMenu.handleEvents(event);
				break;
			case GAME:
				sceneGame.handleEvents(event);
				break;
			case GAMEOVER:
				sceneGameover.handleEvents(event);
				break;
			case PAUSE:
				scenePause.handleEvents(event);
				break;
			}
		}
	}
	
	/**
	 * Gère les actions de l'application.
	 */
	public void update() {
		switch (stateOfApp) {
		case MENU:
			sceneMenu.update();
			break;
		case GAME:
			sceneGame.update();
			break;
		case GAMEOVER:
			sceneGameover.update();
			break;
		case PAUSE:
			scenePause.update();
			break;
		}
	}

	/**
	 * Affiche les éléments graphiques dans la fenêtre de l'application.
	 */
	public void render() {
		window.clear(Color.BLACK);
		switch (stateOfApp) {
		case MENU:
			sceneMenu.draw();
			break;
		case GAME:
			sceneGame.draw();
			break;
		case GAMEOVER:
			sceneGameover.draw();
			break;
		case PAUSE:
			sceneGame.draw();
			scenePause.draw();
			break;
		}
		window.display();
	}
	
	/**
	 * Permet de changer l'état en cours de l'application.
	 * @param stateOfApp : L'état de l'application attendu.
	 */
	public static void setStateOfApp(State state) {
		Application.stateOfApp = state;
	}
	
}
