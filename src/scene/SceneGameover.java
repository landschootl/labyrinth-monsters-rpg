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
 * Classe qui représente la scène lorsque la partie est perdu.
 * @author Ludov_000
 *
 */
public class SceneGameover {
	/**
	 * Pointeur sur la fenetre de l'application.
	 */
	private RenderWindow window;
	
	private RectangleShape background = new RectangleShape(new Vector2f(640,280));
	private Texte text = new Texte("Game Over", 100, new Vector2f(90,240), Color.BLACK, Text.REGULAR);
	private Texte replay = new Texte("Press SPACE to play again", 40, new Vector2f(90,370), Color.BLACK, Text.REGULAR);
	private Texte menu = new Texte("Press ECHAP to go to menu", 40, new Vector2f(90,450), Color.BLACK, Text.REGULAR);

	public SceneGameover(RenderWindow window){
		this.window=window;
		
		background.setPosition(0, 250);
		background.setFillColor(new Color(220,220,220,100));
	}
	
	/**
	 * Permet de gérer les événements de la scène.
	 * @param event : l'événement de l'application.
	 */
	public void handleEvents(Event event) {
		if(event.type == Type.KEY_PRESSED){
			if(Keyboard.isKeyPressed(Key.ESCAPE))
				Application.setStateOfApp(State.MENU);
			if(Keyboard.isKeyPressed(Key.SPACE))
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
		replay.draw(window);
		menu.draw(window);
	}
	
}
