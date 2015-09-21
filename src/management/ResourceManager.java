package management;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.jsfml.graphics.Font;
import org.jsfml.graphics.Texture;

/**
 * Classe permettant de stocker toutes les ressources utiles pour le jeu en s'asurant qu'elles seront charg� qu'une seule fois.
 * @author Ludov_000
 *
 */
public class ResourceManager {
	private static Map fonts = new HashMap<>();
	private static Map textures = new HashMap<>();
	
	/**
	 * Fonction qui permet de v�rifier si le Font souhait� existe, et de le cr�er ainsi que le charger si il n'�xiste pas.
	 * @param url : l'url absolue du font souhait�.
	 * @return le font demand�.
	 */
	public static Font getFont(String url){
		if(!fonts.containsKey(url)){
			fonts.put(url, new Font());
			try {
				((Font) fonts.get(url)).loadFromFile(Paths.get(url));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 	((Font) fonts.get(url));
	}
	
	/**
	 * Fonction qui permet de v�rifier si la texture souhait� existe, et de la cr�er ainsi que la charger si elle n'�xiste pas.
	 * @param url : l'url absolue de la texture souhait�.
	 * @return la texture demand�.
	 */
	public static Texture getTexture(String url){
		if(!textures.containsKey(url)){
			textures.put(url, new Texture());
			try {
				((Texture) textures.get(url)).loadFromFile(Paths.get(url));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 	((Texture) textures.get(url));
	}
}
