package object.weapon;

import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;

/**
 * Classe qui repr�sente une munition utilis� par les armes.
 * @author Ludov_000
 *
 */
public class Munition {
	// Logique
	/**
	 * La vitesse de d�placement.
	 */
	private int speed;
	/**
	 * Le d�placement sur les axes x et y.
	 */
	private float speedX=0, speedY=0;
	/**
	 * La position de d�part de la munition.
	 */
	private Vector2f posBegin;
	/**
	 * La direction de la cible.
	 */
	private Vector2f posDirection;
	
	// Graphique
	private CircleShape shape;
	
	
	public Munition(Vector2f posBegin, Vector2f posDirection, int speed) {
		this.posDirection=posDirection;
		this.posBegin=posBegin;
		this.speed=speed;
		initShape();
	}
	
	/**
	 * Initialise le graphique du shape.
	 */
	public void initShape(){
		shape = new CircleShape(2, 5);
		shape.setFillColor(Color.BLACK);
		shape.setPosition(posBegin);
	}
	
	/**
	 * G�re le d�placement de la munition.
	 * @param time : timer pour la gestion de frames.
	 */
	public void move(Time time){
		double distance = (float)Math.sqrt((Math.abs(((posBegin.x-posDirection.x)*(posBegin.x-posDirection.x))+((posBegin.y-posDirection.y)*(posBegin.y-posDirection.y)))));
		speedX=(float)(((posDirection.x-posBegin.x)/distance)*speed)*time.asSeconds();
		speedY=(float)(((posDirection.y-posBegin.y)/distance)*speed)*time.asSeconds();
		shape.move(speedX, speedY);
	}
	
	/**
	 * Affiche les �l�ments graphiques dans la fen�tre de la console.
	 * @param window : pointeur sur la fenetre de l'application.
	 */
	public void draw(RenderWindow window){
		window.draw(shape);
	}
	
	public CircleShape getShape(){
		return shape;
	}
}
