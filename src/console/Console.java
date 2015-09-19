package console;

import java.util.ArrayList;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

import resource.Texte;

public class Console {
	private RectangleShape background;
	private ArrayList<Texte> texts;
	
	public Console(){
		initBackground();
		initTexts();
	}
	
	// Fonction qui initialise les textes.
	public void initTexts() {
		texts = new ArrayList<>();
		addText("Bienvenue dans le jeu Donjon.1");
		addText("Bienvenue dans le jeu Donjon.2");
		addText("Bienvenue dans le jeu Donjon.3");
		addText("Bienvenue dans le jeu Donjon.4");
		addText("Bienvenue dans le jeu Donjon.5");
		addText("Bienvenue dans le jeu Donjon.6");
		addText("Bienvenue dans le jeu Donjon.7");
		addText("Bienvenue dans le jeu Donjon.8");
		addText("Bienvenue dans le jeu Donjon.9");
		addText("Bienvenue dans le jeu Donjon.10");
		addText("Bienvenue dans le jeu Donjon.10");
	}

	// Fonction qui initialise le background de la console.
	public void initBackground() {
		background = new RectangleShape(new Vector2f(262,150));
		background.setFillColor(new Color(Color.WHITE, 100));
		background.setOutlineThickness(10);
		background.setOutlineColor(new Color(Color.WHITE, 50));
		background.setPosition(new Vector2f(10,640));
	}
	
	// Fonction qui permet d'ajouter un message dans la console.
	public void addText(String message){
		if(texts.size()>7)
			removeText(0);
		texts.add(new Texte("> "+message, 15, new Vector2f(15,645+texts.size()*17), Color.BLUE, Text.REGULAR));
	}
	
	// Fonction qui permet de supprimer le message correspondant à l'id donné en paramètre.
	public void removeText(int id){
		texts.remove(id);
		for(int i=id; i<texts.size(); i++)
			texts.get(i).setPosition(new Vector2f(texts.get(i).getPosition().x,texts.get(i).getPosition().y-17));
	}
	
	// Fonction qui permet de gérer les événements.
	public void processEvents(Event event) {

	}

	// Fonction qui permet de gérer les actions.
	public void update() {

	}

	// Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	public void render(RenderWindow window) {
		window.draw(background);
		for(Texte text : texts)
			text.render(window);
	}
}
