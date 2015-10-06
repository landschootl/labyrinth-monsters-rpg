package scene;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.Keyboard;
import org.jsfml.window.Keyboard.Key;
import org.jsfml.window.event.Event;

import application.Application;
import application.Application.State;

/**
 * Classe qui représente la scène lorsque la partie est perdu.
 * @author Ludov_000
 *
 */
public class SceneGameover {
	/**
	 * Pointeur sur la fenetre de l'application.
	 */
	private RenderWindow window;

	public SceneGameover(RenderWindow window){
		this.window=window;
	}
	
	/**
	 * Permet de gérer les événements de la scène.
	 * @param event : l'événement de l'application.
	 */
	public void handleEvents(Event event) {
		if(event.type == event.type.KEY_PRESSED){
			event.asKeyEvent();
			if(Keyboard.isKeyPressed(Key.A))
				Application.setStateOfApp(State.GAME);
		}
	}

	/**
	 * Permet de gérer les actions de la scène.
	 */
	public void update() {

	}

	/**
	 * Affiche les éléments graphiques dans la fenêtre de la scène.
	 */
	public void draw() {
		
	}
	
}
