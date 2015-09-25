package management;

import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

/**
 * Cette classe permet de découper un sprite en créant un tableau de sprites .
 * @author Ludov_000
 *
 */
public class SpriteManager {
	
	/**
	 * Decoupe le Sprite en tableau de Sprite.
	 * @param urlSprite : l'url du sprite.
	 * @return Une tableau de Sprite.
	 */
	public static Sprite[][] getArraySprite(String urlSprite){
		Texture texture = ResourceManager.getTexture(urlSprite);
		Sprite[][] sprites = new Sprite[4][3];
		for(int i=0; i<4; i++){
			for(int j=0; j<3; j++){
				Sprite sprite = new Sprite();
				sprite.setTextureRect(new IntRect(j*32,i*32,32,32));
				sprite.setTexture(texture);
				sprites[i][j]=sprite;
			}
		}
		return sprites;
	}
	
}
