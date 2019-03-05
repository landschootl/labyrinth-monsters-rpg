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

import resources.Texte;
import application.Application;
import application.Application.State;

/**
 * Classe qui repr�sente la sc�ne lorsque la partie est perdu.
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
	 * Permet de g�rer les �v�nements de la sc�ne.
	 * @param event : l'�v�nement de l'application.
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
	 * Permet de g�rer les actions de la sc�ne.
	 */
	public void update() {

	}

	/**
	 * Affiche les �l�ments graphiques dans la fen�tre de la sc�ne.
	 */
	public void draw() {
		window.draw(background);
		text.draw(window);
		replay.draw(window);
		menu.draw(window);
	}
	
}
