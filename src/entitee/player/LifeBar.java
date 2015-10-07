package entitee.player;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;

import resource.Texte;

/**
 * Life bar.
 * @author Ludov_000
 *
 */
public class LifeBar {
	// Graphique
	private RectangleShape background = new RectangleShape(new Vector2f(60,160));
	private RectangleShape blood = new RectangleShape();
	private Texte textLife = new Texte("",25,new Vector2f(293,690),Color.BLACK,Text.BOLD);
	
	public LifeBar(){
		initBackground();
	}
	
	/**
	 * Initialize life bar background.
	 */
	public void initBackground(){
		background.setFillColor(Color.WHITE);
		background.setOutlineThickness(10);
		background.setOutlineColor(new Color(97,56,11));
		background.setPosition(new Vector2f(290,650));
	}
	
	/**
	 * enable to manage the target events.
	 * @param life : current life.
	 * @param MAX_LIFE : maximum life.
	 */
	public void update(float life, float MAX_LIFE){
		float sizeBlood = (float) (160.0 * (life/MAX_LIFE));
		blood = new RectangleShape(new Vector2f(60,sizeBlood));
		float percentageLife = (life/MAX_LIFE)*100.0f;
		if(percentageLife<=35.0f)
			blood.setFillColor(new Color(250,51,51));
		else if(percentageLife>35.0f&&percentageLife<=70.0f)
			blood.setFillColor(new Color(250,154,51));
		else
			blood.setFillColor(new Color(25,217,11));
		blood.setPosition(new Vector2f(290,650+160-sizeBlood));
		textLife = new Texte((int)life+" / "+(int)MAX_LIFE,25,new Vector2f(293,690),Color.BLACK,Text.BOLD);
	}
	
	/**
	 * shows graphics elements in the windows of the console.
	 * @param window : pointer on the window of the application.
	 */
	public void draw(RenderWindow window) {
		window.draw(background);
		window.draw(blood);
		textLife.draw(window);
	}
	
}
