package application;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Clock;
import org.jsfml.system.Time;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

import scene.SceneGame;
import scene.SceneGameover;
import scene.SceneMenu;
import scene.ScenePause;

/**
 * 
 * This class manage the differents scenes when the player playing.
 * @author Ludov_000
 *
 */
public class Application {
	/**
	 * application window.
	 */
	public RenderWindow window = new RenderWindow();
	
	/**
	 * Enable frames management in the game.
	 */
	private Clock timerFrame = new Clock();
	
	/**
	 * The differents steps of the application.
	 * @author Ludov_000
	 */
	public enum State {
		GAME,
		GAMEOVER,
		MENU,
		PAUSE
	}
	
	/**
	 * Indicates the current state of the application.
	 */
	private static State stateOfApp = State.MENU;

	SceneGame sceneGame = new SceneGame(window);
	SceneMenu sceneMenu = new SceneMenu(window);
	SceneGameover sceneGameover = new SceneGameover(window);
	ScenePause scenePause = new ScenePause(window);

	public Application() {
		window.create(new VideoMode(640, 820), "Donjon");
	}
	
	/**
	 * Main loop of the application. 
	 * The loop executes as long as the window is open.
	 */
	public void run() {
		while (window.isOpen()) {
			processEvents();
			update();
			render();
		}
	}

	/**
	 * Manage events of the application.
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
			default:
				break;
			}
		}
	}
	
	/**
	 * Manage actions of the application.
	 */
	public void update() {
		Time time;
	    time=timerFrame.getElapsedTime();
	    timerFrame.restart();
		switch (stateOfApp) {
		case MENU:
			sceneMenu.update();
			break;
		case GAME:
			sceneGame.update(time);;
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
	 * Show graphics elements in the window of the application.
	 */
	public void render() {
		window.clear(Color.BLACK);
		switch (stateOfApp) {
		case MENU:
			window.setMouseCursorVisible(true);
			sceneMenu.draw();
			break;
		case GAME:
			window.setMouseCursorVisible(false);
			sceneGame.draw();
			break;
		case GAMEOVER:
			sceneGame.draw();
			sceneGameover.draw();
			break;
		case PAUSE:
			sceneGame.draw();
			scenePause.draw();
			break;
		default:
			break;
		}
		window.display();
	}
	
	/**
	 * Enable to change the current state of the application.
	 * @param stateOfApp : The state of the application is expect.
	 */
	public static void setStateOfApp(State state) {
		Application.stateOfApp = state;
	}
	
}
