package management;

import java.util.HashMap;
import java.util.Map;

import map.Tile;

import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;

/**
 * Singleton class enable to return a tile or a sprite since a tileset.
 * @author Ludov_000
 *
 */
public class TilesetManager {
	/**
	 * unique instance from TilesetManager class.
	 */
	private static TilesetManager instance = null;
	
	
	private final int SIZE_SPRITE = 32;
	
	private Map<String, Vector2f> posTile = new HashMap<>();
	private Map<String, Boolean> lockedTile = new HashMap<>();
	
	public TilesetManager(){
		posTile.put("doorClose", new Vector2f(0,0));
		posTile.put("lever", new Vector2f(1,0));
		posTile.put("roof", new Vector2f(2,0));
		posTile.put("doorOpen", new Vector2f(0,1));
		posTile.put("lava", new Vector2f(1,1));
		posTile.put("wall", new Vector2f(2,1));
		posTile.put("safeClose", new Vector2f(0,2));
		posTile.put("safeOpen", new Vector2f(1,2));
		posTile.put("grass", new Vector2f(2,2));
		posTile.put("waterLeft", new Vector2f(0,3));
		posTile.put("waterCenter", new Vector2f(1,3));
		posTile.put("waterRight", new Vector2f(2,3));
		posTile.put("timber", new Vector2f(3,3));
		posTile.put("checkpoint", new Vector2f(4,3));
		
		posTile.put("beginnerBow", new Vector2f(3,0));
		posTile.put("slingShot", new Vector2f(4,0));
		posTile.put("gun", new Vector2f(5,0));
		posTile.put("bow", new Vector2f(6,0));
		posTile.put("shield", new Vector2f(3,1));
		posTile.put("helmet", new Vector2f(4,1));
		posTile.put("clothes", new Vector2f(5,1));
		posTile.put("boot", new Vector2f(6,1));
		posTile.put("map", new Vector2f(3,2));
		posTile.put("potionLife", new Vector2f(4,2));
		posTile.put("lamp", new Vector2f(5,2));
		posTile.put("key", new Vector2f(6,2));
		posTile.put("crossbow", new Vector2f(5,3));
		posTile.put("glove", new Vector2f(6,3));
		
		lockedTile.put("doorClose", true);
		lockedTile.put("lever", true);
		lockedTile.put("roof", true);
		lockedTile.put("doorOpen", false);
		lockedTile.put("lava", true);
		lockedTile.put("wall", true);
		lockedTile.put("safeClose", true);
		lockedTile.put("safeOpen", true);
		lockedTile.put("grass", false);
		lockedTile.put("waterLeft", true);
		lockedTile.put("waterCenter", true);
		lockedTile.put("waterRight", true);
		lockedTile.put("timber", false);
		lockedTile.put("checkpoint", false);
		
		lockedTile.put("beginnerBow", false);
		lockedTile.put("slingShot", false);
		lockedTile.put("gun", false);
		lockedTile.put("bow", false);
		lockedTile.put("shield", false);
		lockedTile.put("helmet", false);
		lockedTile.put("clothes", false);
		lockedTile.put("boot", false);
		lockedTile.put("map", false);
		lockedTile.put("potionLife", false);
		lockedTile.put("lamp", false);
		lockedTile.put("key", false);
		lockedTile.put("crossbow", false);
		lockedTile.put("glove", false);
	}
	
	/**
	 * This function enable to create the only tilesetManager instance if it dosen't exist.
	 * @return only instance from TilesetManager class.
	 */
	public static TilesetManager getInstance(){
		if(instance==null)
			instance = new TilesetManager();
		return instance;
	}
	
	/**
	 * Return a Tile identify by his name, defining the sprite position.
	 * @param name : name of the desired Tile.
	 * @param positionSprite : Sprite position.
	 * @return Tile corresponding to the defined name.
	 */
	public Tile getTile(String name, Vector2f positionSprite){
		Sprite sprite = new Sprite();
		int posX = (int) ((Vector2f) posTile.get(name)).x*SIZE_SPRITE;
		int posY = (int) ((Vector2f) posTile.get(name)).y*SIZE_SPRITE;
		sprite.setTexture(ResourceManager.getTexture("src/main/resources/tileset/tileset.png"));
		sprite.setTextureRect(new IntRect(posX,posY,SIZE_SPRITE,SIZE_SPRITE));
		sprite.setPosition(positionSprite);
		return new Tile(((boolean) lockedTile.get(name)), sprite);
	}
	
	/**
	 * Return the sprite matches the name passed as argument.
	 * @param name : name of the desired Tile.
	 * @return Tile corresponding to the defined name..
	 */
	public Sprite getSprite(String name){
		Sprite sprite = new Sprite();
		int posX = (int) ((Vector2f) posTile.get(name)).x*SIZE_SPRITE;
		int posY = (int) ((Vector2f) posTile.get(name)).y*SIZE_SPRITE;
		sprite.setTexture(ResourceManager.getTexture("src/main/resources/tileset/tileset.png"));
		sprite.setTextureRect(new IntRect(posX,posY,SIZE_SPRITE,SIZE_SPRITE));
		return sprite;
	}
	
	/**
	 * Return the sprite matches the name passes as argument with a attribute position.
	 * @param name : name of the desired Tile.
	 * @param positionSprite : Sprite position.
	 * @return Tile corresponding to the defined name.
	 */
	public Sprite getSpriteWhithPosition(String name, Vector2f positionSprite){
		Sprite sprite = getSprite(name);
		sprite.setPosition(positionSprite);
		return sprite;
	}
	
}
