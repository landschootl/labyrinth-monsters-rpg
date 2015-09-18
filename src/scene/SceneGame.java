package scene;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.event.Event;

public class SceneGame {
	private RenderWindow window;
	
	private String stateOfGame = "Menu";
	
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
		
	}

	public String getStateOfGame() {
		return stateOfGame;
	}

	public void setStateOfGame(String stateOfGame) {
		this.stateOfGame = stateOfGame;
	}
	
}
