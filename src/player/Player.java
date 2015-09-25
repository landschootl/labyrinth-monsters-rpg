package player;

import management.ResourceManager;
import management.SpriteManager;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Text;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

import resource.Texte;

/**
 * Cette classe représente le joueur dans  le jeu.
 * @author Ludov_000
 *
 */
public class Player {
	private float nbMaxLife = 8;
	private int nbLife = 3;
	
	private Sprite[][] sprites;
	private Vector2f direction = new Vector2f(0,2);
	
	
	private RectangleShape backgroundLife;
	private RectangleShape blood;
	private Texte textLife;
	
	private Sprite viseur = new Sprite();
	
	public Player(){
		sprites = SpriteManager.getArraySprite("resource/sprite/soldier.png");
		initDesignLife();
		viseur.setTexture(ResourceManager.getTexture("resource/sprite/viseur.png"));
	}
	
	/**
	 * Fonction qui permet de gérer les événements.
	 * @param event : l'événement sur lequel on écoute.
	 */
	public void handleEvents(Event event) {
		if (event.type == Event.Type.MOUSE_MOVED) {
			viseur.setPosition(new Vector2f(event.asMouseEvent().position.x-16, event.asMouseEvent().position.y-16));
		}
	}

	/**
	 * Fonction qui permet de gérer les actions.
	 * @param time : le temps pour la gestion des frames.
	 */
	public void update(Time time) {
		
	}

	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 * @param window : La fenetre sur laquel on souhaite afficher les éléments.
	 */
	public void draw(RenderWindow window) {
		window.draw(sprites[(int) direction.x][(int) direction.y]);
		window.draw(backgroundLife);
		window.draw(blood);
		textLife.draw(window);
		window.draw(viseur);
	}
	
	/**
	 * Fonction qui initialise le design de la vie du joueur.
	 */
	private void initDesignLife() {
		// TODO Auto-generated method stub
		backgroundLife = new RectangleShape(new Vector2f(60,160));
		backgroundLife.setFillColor(new Color(Color.WHITE, 300));
		backgroundLife.setOutlineThickness(10);
		backgroundLife.setOutlineColor(Color.BLACK);
		backgroundLife.setPosition(new Vector2f(290,650));
		
		float sizeBlood = (float) (160.0 * (nbLife/nbMaxLife));
		blood = new RectangleShape(new Vector2f(60,sizeBlood));
		blood.setFillColor(new Color(232,12,50));
		blood.setPosition(new Vector2f(290,650+160-sizeBlood));
		
		textLife = new Texte("Life\n"+nbLife+"/"+(int)nbMaxLife,30,new Vector2f(295,690),Color.BLACK,Text.BOLD);
	}

}
