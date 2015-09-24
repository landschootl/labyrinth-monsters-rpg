package console;

import java.util.ArrayList;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

import resource.Texte;

/**
 * Classe qui simule une console pour l'intérieur du jeu.
 * @author Ludov_000
 *
 */
public class Console {
	/**
	 * Design pattern Singleton, assure qu'il n'y est qu'une seule instance de la classe Console.
	 */
	private static Console instance = null;
	
	private RectangleShape background;
	private ArrayList<Texte> texts;
	
	/**
	 * Constructeur en private pour éviter qu'on déclare une nouvelle instance de la classe.
	 */
	private Console(){
		initBackground();
		initTexts();
	}
	
	/**
	 * Fonction qui permet de créer la seule instance de Console si elle n'existe pas.
	 * @return la seule instance de la classe Console.
	 */
	public static Console getInstance(){
		if(instance==null)
			instance = new Console();
		return instance;
	}
	
	/**
	 * Fonction qui initialise les textes.
	 */
	public void initTexts() {
		texts = new ArrayList<>();
	}

	/**
	 * Fonction qui initialise le background de la console.
	 */
	public void initBackground() {
		background = new RectangleShape(new Vector2f(270,160));
		background.setFillColor(new Color(Color.WHITE, 300));
		background.setOutlineThickness(10);
		background.setOutlineColor(Color.BLACK);
		background.setPosition(new Vector2f(10,650));
	}
	
	/**
	 * Fonction qui permet d'ajouter un message dans la console.
	 * @param message : le message qu'on souhaite ajouter à la console.
	 */
	public void addText(String message, int type, Color color){
		if(texts.size()>7)
			removeText(0);
		texts.add(new Texte("> "+message, 15, new Vector2f(15,655+texts.size()*17), color, type));
	}
	
	/**
	 * Fonction qui permet de supprimer le message correspondant à l'id donné en paramètre.
	 * @param id : l'idée du message à supprimer.
	 */
	public void removeText(int id){
		texts.remove(id);
		for(int i=id; i<texts.size(); i++)
			texts.get(i).setPosition(new Vector2f(texts.get(i).getPosition().x,texts.get(i).getPosition().y-17));
	}
	
	/**
	 * Fonction qui permet de gérer les événements.
	 * @param event : l'événement sur lequel on écoute.
	 */
	public void handleEvents(Event event) {
		
	}

	/**
	 * Fonction qui permet de gérer les actions.
	 */
	public void update() {

	}

	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 * @param window : La fenetre sur laquel on souhaite afficher les éléments.
	 */
	public void show(RenderWindow window) {
		window.draw(background);
		for(Texte text : texts)
			text.show(window);
	}
}