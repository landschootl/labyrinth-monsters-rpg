package management;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.jsfml.audio.SoundBuffer;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.Texture;

/**
 * This class enable to stock and send every  for the application and check if the resources will be load only one time .
 * @author Ludov_000
 *
 */
public class ResourceManager {
	/**
	 *Fonts list.
	 */
	private static Map<String, Font> fonts = new HashMap<>();
	/**
	 * Textures list.
	 */
	private static Map<String, Texture> textures = new HashMap<>();
	/**
	 * SoundBuffer list.
	 */
	private static Map<String, SoundBuffer> soundBuffers = new HashMap<>();
	
	/**
	 * Enable to return the font and check if it exist, and load it if dosen't exist .
	 * @param url : font url.
	 * @return font
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
	 * enable to return the texture and check if it exist, and load it if dosen't exist.
	 * @param url : texture url.
	 * @return texture.
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
	
	/**
	 * enable to return the SoundBuffer and check if it exist, and load it if dosen't exist.
	 * @param url : soundBuffer url.
	 * @return soundBuffer.
	 */
	public static SoundBuffer getSoundBuffer(String url){
		if(!soundBuffers.containsKey(url)){
			soundBuffers.put(url, new SoundBuffer());
			try {
				((SoundBuffer) soundBuffers.get(url)).loadFromFile(Paths.get(url));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 	((SoundBuffer) soundBuffers.get(url));
	}
}
