package map;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;

/**
 * Classe définissant un tile présent dans les tileset.
 * @author Ludov_000
 *
 */
public class Tile {
	private boolean checked; // Défini si on peut marcher dessus ou pas.
	private Sprite sprite;
	
	public Tile(boolean checked, Sprite sprite){
		this.checked = checked;
		this.sprite = sprite;
	}
	
	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 * @param window : La fenetre sur laquel on souhaite afficher les éléments.
	 */
	public void draw(RenderWindow window){
		window.draw(sprite);
	}
	
	public Vector2f getPosition(){
		return sprite.getPosition();
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
}
