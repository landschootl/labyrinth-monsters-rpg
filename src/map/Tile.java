package map;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;

/**
 * Class defining a tile present in a map.
 * @author Ludov_000
 *
 */
public class Tile {
	/**
	 * Define if we can walk on the tile.
	 */
	private boolean checked;
	
		private Sprite sprite;
	
	public Tile(boolean checked, Sprite sprite){
		this.checked = checked;
		this.sprite = sprite;
	}
	
	/**
	 * Show the graphics elements in the windows of the console.
	 * @param window : pointer on the window of the application.
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
