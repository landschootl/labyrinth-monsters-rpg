package scene;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.event.Event;

import console.Console;

public class SceneGame {
	private RenderWindow window;
	private Console console = new Console();
	
	private String stateOfGame = "Game";
	
	public SceneGame(RenderWindow window){
		this.window=window;
	}
	
	// Fonction qui permet de gérer les événements.
	public void processEvents(Event event) {

	}

	// Fonction qui permet de gérer les actions.
	public void update() {

	}

	// Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	public void render() {
		console.render(window);
	}

	public String getStateOfGame() {
		return stateOfGame;
	}

	public void setStateOfGame(String stateOfGame) {
		this.stateOfGame = stateOfGame;
	}
	
}
