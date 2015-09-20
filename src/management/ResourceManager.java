package management;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.jsfml.graphics.Font;

public class ResourceManager {
	private static Map fonts = new HashMap<>();
	
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
}
