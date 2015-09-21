package management;

import java.util.HashMap;
import java.util.Map;

import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;

/**
 * Classe permettant de retourner un Tile depuis un tileset.
 * @author Ludov_000
 *
 */
public class TilesetManager {
	/**
	 * Design pattern Singleton, assure qu'il n'y est qu'une seule instance de la classe Console.
	 */
	private static TilesetManager instance = null;
	
	private final int SIZE_SPRITE = 32;
	
	private Map posTile = new HashMap<>();
	private Map lockedTile = new HashMap<>();
	
	public TilesetManager(){
		posTile.put("porte", new Vector2f(0,0));
		posTile.put("levier", new Vector2f(1,0));
		posTile.put("toit", new Vector2f(2,0));
		posTile.put("porte2", new Vector2f(0,1));
		posTile.put("depart", new Vector2f(1,1));
		posTile.put("mur", new Vector2f(2,1));
		posTile.put("coffreClose", new Vector2f(0,2));
		posTile.put("coffreOpen", new Vector2f(1,2));
		posTile.put("sol", new Vector2f(2,2));
		
		lockedTile.put("porte", false);
		lockedTile.put("levier", false);
		lockedTile.put("toit", false);
		lockedTile.put("porte2", false);
		lockedTile.put("depart", true);
		lockedTile.put("mur", false);
		lockedTile.put("coffreClose", false);
		lockedTile.put("coffreOpen", false);
		lockedTile.put("sol", true);
	}
	
	/**
	 * Fonction qui permet de créer la seule instance de TilesetManager si elle n'existe pas.
	 * @return la seule instance de la classe TilesetManager.
	 */
	public static TilesetManager getInstance(){
		if(instance==null)
			instance = new TilesetManager();
		return instance;
	}
	
	/**
	 * Retourne un Tile défini par son nom, en définissant la position du sprite.
	 * @param name : le nom du Tile souhaité.
	 * @param positionSprite : la position du Sprite.
	 * @return le Tile correspond au nom défini.
	 */
	public Tile getCelluleTest(String name, Vector2f positionSprite){
		Sprite sprite = new Sprite();
		int posX = (int) ((Vector2f) posTile.get(name)).x*SIZE_SPRITE;
		int posY = (int) ((Vector2f) posTile.get(name)).y*SIZE_SPRITE;
		sprite.setTexture(ResourceManager.getTexture("resource/tileset/tileset.png"));
		sprite.setTextureRect(new IntRect(posX,posY,SIZE_SPRITE,SIZE_SPRITE));
		sprite.setPosition(positionSprite);
		return new Tile(((boolean) lockedTile.get(name)), sprite);
	}
	
}
