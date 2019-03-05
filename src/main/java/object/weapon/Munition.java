package object.weapon;

import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;

/**
 * 
 *This class represent the ammunitions used by the player.
 * @author Ludov_000
 *
 */
public class Munition {
	
	/**
	 * moving speed.
	 */
	private int speed;
	/**
	 *moving on axes x and y.
	 */
	private float speedX=0, speedY=0;
	/**
	 * ammunition start position.
	 */
	private Vector2f posBegin;
	/**
	 * target direction.
	 */
	private Vector2f posDirection;
	
	
	private CircleShape shape;
	
	
	public Munition(Vector2f posBegin, Vector2f posDirection, int speed) {
		this.posDirection=posDirection;
		this.posBegin=posBegin;
		this.speed=speed;
		initShape();
	}
	
	/**
	 * initialize shape graphic.
	 */
	public void initShape(){
		shape = new CircleShape(2, 5);
		shape.setFillColor(Color.BLACK);
		shape.setPosition(posBegin);
	}
	
	/**
	 * manage the movement of the ammunition.
	 * @param time : timer for frames manage.
	 */
	public void move(Time time){
		double distance = (float)Math.sqrt((Math.abs(((posBegin.x-posDirection.x)*(posBegin.x-posDirection.x))+((posBegin.y-posDirection.y)*(posBegin.y-posDirection.y)))));
		speedX=(float)(((posDirection.x-posBegin.x)/distance)*speed)*time.asSeconds();
		speedY=(float)(((posDirection.y-posBegin.y)/distance)*speed)*time.asSeconds();
		shape.move(speedX, speedY);
	}
	
	/**
	 * Show the graphics elements in the windows of the console.
	 * @param window : pointer on the window of the application.
	 */
	public void draw(RenderWindow window){
		window.draw(shape);
	}
	
	public CircleShape getShape(){
		return shape;
	}
}
