package scene;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;
import org.jsfml.window.Keyboard.Key;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.Event.Type;

import resource.Texte;
import application.Application;
import application.Application.State;

/**
 * Classe qui représente la scène lorsque la partie est en pause.
 * @author Ludov_000
 *
 */
public class ScenePause {
	/**
	 * Pointeur sur la fenetre de l'application.
	 */
	private RenderWindow window;
	
	private RectangleShape background = new RectangleShape(new Vector2f(640,240));
	private Texte text = new Texte("Pause", 200, new Vector2f(70,260),Color.WHITE,Text.REGULAR);

	public ScenePause(RenderWindow window){
		this.window=window;
		
		background.setPosition(0, 280);
		background.setFillColor(new Color(220,220,220,100));
	}
	
	/**
	 * Permet de gérer les événements de la scène.
	 * @param event : l'événement de l'application.
	 */
	public void handleEvents(Event event) {
		if(event.type == Type.KEY_PRESSED){
			event.asKeyEvent();
			if(Keyboard.isKeyPressed(Key.ESCAPE))
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
		window.draw(background);
		text.draw(window);
	}
	
}
