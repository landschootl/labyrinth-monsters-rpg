package map;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;

/**
 * Classe d�finissant un tile pr�sent dans une map.
 * @author Ludov_000
 *
 */
public class Tile {
	// Logique
	/**
	 * D�finiti si on peut marcher sur le tile.
	 */
	private boolean checked;
	
	// Graphique
	private Sprite sprite;
	
	public Tile(boolean checked, Sprite sprite){
		this.checked = checked;
		this.sprite = sprite;
	}
	
	/**
	 * Affiche les �l�ments graphiques dans la fen�tre de la console.
	 * @param window : pointeur sur la fenetre de l'application.
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
