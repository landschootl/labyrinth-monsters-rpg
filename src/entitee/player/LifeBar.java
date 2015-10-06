package entitee.player;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;

import resource.Texte;

/**
 * Classe qui correspond à la jauge de vie du joueur.
 * @author Ludov_000
 *
 */
public class LifeBar {
	// Graphique
	private RectangleShape background;
	private RectangleShape blood;
	private Texte textLife;
	
	public LifeBar(){
		initBackground();
	}
	
	/**
	 * Initialise le background de la jauge de vie.
	 */
	public void initBackground(){
		background = new RectangleShape(new Vector2f(60,160));
		background.setFillColor(Color.WHITE);
		background.setOutlineThickness(10);
		background.setOutlineColor(new Color(97,56,11));
		background.setPosition(new Vector2f(290,650));
	}
	
	/**
	 * Permet de gérer les événements du viseur.
	 * @param life : la vie actuelle du joueur.
	 * @param MAX_LIFE : la vie max du joueur.
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
	 * Affiche les éléments graphiques dans la fenêtre de la console.
	 * @param window : pointeur sur la fenetre de l'application.
	 */
	public void draw(RenderWindow window) {
		window.draw(background);
		window.draw(blood);
		textLife.draw(window);
	}
	
}
