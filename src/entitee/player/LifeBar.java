package entitee.player;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;

import resource.Texte;

/**
 * Class qui correspond à la jauge de vie du joueur.
 * @author Ludov_000
 *
 */
public class LifeBar {
	private RectangleShape backgroundLife;
	private RectangleShape blood;
	private Texte textLife;
	
	public LifeBar(){
		backgroundLife = new RectangleShape(new Vector2f(60,160));
		backgroundLife.setFillColor(new Color(Color.WHITE, 300));
		backgroundLife.setOutlineThickness(10);
		backgroundLife.setOutlineColor(Color.BLACK);
		backgroundLife.setPosition(new Vector2f(290,650));
	}
	
	public void update(int life, int MAX_LIFE){
		float sizeBlood = (float) (160.0 * (life/MAX_LIFE));
		blood = new RectangleShape(new Vector2f(60,sizeBlood));
		blood.setFillColor(new Color(232,12,50));
		blood.setPosition(new Vector2f(290,650+160-sizeBlood));
		textLife = new Texte("Life\n"+life+"/"+(int)MAX_LIFE,30,new Vector2f(295,690),Color.BLACK,Text.BOLD);
	}
	
	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 * @param window : La fenetre sur laquel on souhaite afficher les éléments.
	 * @param mAX_LIFE 
	 * @param life 
	 */
	public void draw(RenderWindow window) {
		window.draw(backgroundLife);
		window.draw(blood);
		textLife.draw(window);
	}
	
}
