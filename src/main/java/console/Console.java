package console;

import java.util.ArrayList;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;

import resources.Texte;

/**
 * Singleton class that handles internal console in the application.
 * 
 * @author Ludov_000
 *
 */
public class Console {
	// Logique
	/**
	 * Unique instance of console class
	 */
	private static Console instance = null;
	
	// Graphique
	private RectangleShape background;
	private ArrayList<Texte> texts = new ArrayList<>();
	
	private Console(){
		initBackground();
		presentation();
	}
	
	/**
	 * Return and create the instance of the class if she dosen't exist.
	 * @return the only one instance of console class.
	 */
	public static Console getInstance(){
		if(instance==null)
			instance = new Console();
		return instance;
	}
	
	/**
	 * init the instance of class.
	 */
	 public static void init(){
		instance = new Console();
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
	 * Add message in the console.
	 * @param message : message to add.
	 * @param type : text type (BOLD, REGULAR, ITALIC, ..).
	 * @param color : text color.
	 */
	public void addText(String message, int type, Color color){
		if(texts.size()>7)
			removeText(0);
		texts.add(new Texte("> "+message, 15, new Vector2f(15,655+texts.size()*17), color, type));
	}
	
	/**
	 * remove a message.
	 * @param id : message id to remove.
	 */
	public void removeText(int id){
		texts.remove(id);
		for(int i=id; i<texts.size(); i++)
			texts.get(i).setPosition(new Vector2f(texts.get(i).getPosition().x,texts.get(i).getPosition().y-17));
	}

	/**
	 * Shows graphics elements in the window of the console.
	 * @param window : pointer to the window of the application.
	 */
	public void draw(RenderWindow window) {
		window.draw(background);
		for(Texte text : texts)
			text.draw(window);
	}
	
	/**
	 * shows the game presentation
	 */
	public void presentation(){
		addText("Bienvenue in the Donjon !", Text.BOLD, Color.RED);
		addText("Les commandes :", Text.BOLD, Color.BLUE);
		addText(" - 1 : utiliser small potion.", Text.REGULAR, Color.BLUE);
		addText(" - 2 : utiliser medium potion.", Text.REGULAR, Color.BLUE);
		addText(" - 3 : utiliser large potion.", Text.REGULAR, Color.BLUE);
		addText(" - z,q,s,d : se deplacer.", Text.REGULAR, Color.BLUE);
		addText(" - space : ramasser un object.", Text.REGULAR, Color.BLUE);
		addText(" - click right : tirer.", Text.REGULAR, Color.BLUE);
	}

	public ArrayList<Texte> getTexts() {
		return texts;
	}
	
}