package management;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.jsfml.graphics.Font;
import org.jsfml.graphics.Texture;

/**
 * Classe permettant de stocker et renvoyer toutes les ressources (Fonts et Textures) utiles pour l'application en s'asurant qu'elles seront charg� qu'une seule fois.
 * @author Ludov_000
 *
 */
public class ResourceManager {
	/**
	 * Liste des fonts utiles dans l'application.
	 */
	private static Map<String, Font> fonts = new HashMap<>();
	/**
	 * Liste des textures utiles dans l'application.
	 */
	private static Map<String, Texture> textures = new HashMap<>();
	
	/**
	 * Permet de retourner le font souhait� en v�rifiant si le Font souhait� existe, et de le charger si il n'�xiste pas.
	 * @param url : l'url du font souhait�.
	 * @return le font
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
	 * Permet de retourner la texture souhait� en v�rifiant si le Font souhait� existe, et de le charger si il n'�xiste pas.
	 * @param url : l'url de la texture souhait�.
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
