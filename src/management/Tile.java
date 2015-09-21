package management;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;

/**
 * Classe d�finissant un tile pr�sent dans les tileset.
 * @author Ludov_000
 *
 */
public class Tile {
	private boolean checked; // D�fini si on peut marcher dessus ou pas.
	private Sprite sprite;
	
	public Tile(boolean checked, Sprite sprite){
		this.checked = checked;
		this.sprite = sprite;
	}
	
	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 * @param window : La fenetre sur laquel on souhaite afficher les �l�ments.
	 */
	public void render(RenderWindow window){
		window.draw(sprite);
	}
}
