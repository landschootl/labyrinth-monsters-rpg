package object.weapon;

import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;

public class Munition {
	private CircleShape shape;
	private float speedX=0, speedY=0;
	private Vector2f posBegin;
	private Vector2f posDirection;
	private int speed;
	
	public Munition(Vector2f posBegin, Vector2f posDirection, int speed) {
		this.posDirection=posDirection;
		this.posBegin=posBegin;
		this.speed=speed;
		shape = new CircleShape(2, 5);
		shape.setFillColor(Color.BLACK);
		shape.setPosition(posBegin);
	}
	
	public void move(Time time){
		double distance = (float)Math.sqrt((Math.abs(((posBegin.x-posDirection.x)*(posBegin.x-posDirection.x))+((posBegin.y-posDirection.y)*(posBegin.y-posDirection.y)))));
		speedX=(float)(((posDirection.x-posBegin.x)/distance)*speed)*time.asSeconds();
		speedY=(float)(((posDirection.y-posBegin.y)/distance)*speed)*time.asSeconds();
		shape.move(speedX, speedY);
	}
	
	public void draw(RenderWindow window){
		window.draw(shape);
	}
}
