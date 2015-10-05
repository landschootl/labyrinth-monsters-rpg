package console;

import java.util.ArrayList;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;

import resource.Texte;

/**
 * Classe Singleton qui gère une console interne dans l'application.
 * @author Ludov_000
 *
 */
public class Console {
	// Logique
	/**
	 * L'unique instance de la classe Console.
	 */
	private static Console instance = null;
	
	// Graphique
	private RectangleShape background;
	private ArrayList<Texte> texts = new ArrayList<>();;
	
	private Console(){
		initBackground();
	}
	
	/**
	 * Retourne et créer l'instance de la classe si elle n'éxiste pas.
	 * @return la seule instance de la classe Console.
	 */
	public static Console getInstance(){
		if(instance==null)
			instance = new Console();
		return instance;
	}

	/**
	 * Initialise le background de la console.
	 */
	public void initBackground() {
		background = new RectangleShape(new Vector2f(270,160));
		background.setFillColor(new Color(Color.WHITE, 300));
		background.setOutlineThickness(10);
		background.setOutlineColor(new Color(97,56,11));
		background.setPosition(new Vector2f(10,650));
	}
	
	/**
	 * Ajoute un message dans la console.
	 * @param message : Le message à ajouter.
	 * @param type : Le type du text (BOLD, REGULAR, ITALIC, ..).
	 * @param color : La couleur du text.
	 */
	public void addText(String message, int type, Color color){
		if(texts.size()>7)
			removeText(0);
		texts.add(new Texte("> "+message, 15, new Vector2f(15,655+texts.size()*17), color, type));
	}
	
	/**
	 * Supprime un message.
	 * @param id : l'id du message à supprimer.
	 */
	public void removeText(int id){
		texts.remove(id);
		for(int i=id; i<texts.size(); i++)
			texts.get(i).setPosition(new Vector2f(texts.get(i).getPosition().x,texts.get(i).getPosition().y-17));
	}

	/**
	 * Affiche les éléments graphiques dans la fenêtre de la console.
	 * @param window : pointeur sur la fenetre de l'application.
	 */
	public void draw(RenderWindow window) {
		window.draw(background);
		for(Texte text : texts)
			text.draw(window);
	}
	
	/**
	 * Affiche la présentation du jeu.
	 */
	public void presentation(){
		addText("Bienvenue in the Donjon !", Text.BOLD, Color.RED);
		addText("Les commandes :", Text.BOLD, Color.BLUE);
		addText(" - 1 : utiliser small potion.", Text.REGULAR, Color.BLUE);
		addText(" - 2 : utiliser medium potion.", Text.REGULAR, Color.BLUE);
		addText(" - 3 : utiliser large potion.", Text.REGULAR, Color.BLUE);
		addText(" - z,q,s,d : se deplacer.", Text.REGULAR, Color.BLUE);
		addText(" - tab : ramasser un object.", Text.REGULAR, Color.BLUE);
		addText(" - click right : tirer.", Text.REGULAR, Color.BLUE);
	}
}