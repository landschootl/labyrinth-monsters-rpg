package scene;

import management.ResourceManager;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Clock;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;
import org.jsfml.window.Keyboard.Key;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.Event.Type;

import application.Application;
import application.Application.State;
import resource.Button;


/**
 * Classe qui reprèsente la scène lorsque le joueur est sur le menu.
 * @author Ludov_000
 *
 */
public class SceneMenu {
	/**
	 * Pointeur sur la fenetre de l'application.
	 */
	private RenderWindow window;

	private Sprite background = new Sprite();
	private Clock timerCompass = new Clock();
	private Sprite compass = new Sprite();
	private Button button = new Button(70, 6, new Color(254,154,59), new Color(59,36,11), new Vector2f(320,640), "enter the dungeon");
			
	public SceneMenu(RenderWindow window) {
		this.window=window;
		
		background.setTexture(ResourceManager.getTexture("resource/image/font.png"));
		compass.setTexture(ResourceManager.getTexture("resource/image/boussole.png"));
		compass.setPosition(new Vector2f(320, 280));
		compass.setOrigin(new Vector2f(180, 180));
	}

	/**
	 * Permet de gérer les événements de la scène.
	 * @param event : l'événement de l'application.
	 */
	public void handleEvents(Event event) {
		button.handleEvents(event);
		if(event.type == Type.KEY_PRESSED){
			if(Keyboard.isKeyPressed(Key.SPACE))
				Application.setStateOfApp(State.GAME);
		}
	}

	/**
	 * Permet de gérer les actions de la scène.
	 */
	public void update() {
		int rotation = (int) ((timerCompass.getElapsedTime().asSeconds()*10)%360);
		compass.setRotation(rotation);
		if(button.isClick())
			Application.setStateOfApp(State.GAME);
	}

	/**
	 * Affiche les éléments graphiques dans la fenêtre de la scène.
	 */
	public void draw() {
		window.setMouseCursorVisible(true);
		window.draw(background);
		window.draw(compass);
		button.draw(window);
	}

}
