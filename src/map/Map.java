package map;

import management.TilesetManager;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2f;

/**
 * Classe qui correspond � une map dans une salle du donjon.
 * @author Ludov_000
 *
 */
public class Map {
	/**
	 * Les tiles qui composent la map.
	 */
	private Tile[][] tiles;
	/**
	 * La taille d'une map.
	 */
	private final int SIZE_MAP = 20;
	
	/**
	 * Un modele de map.
	 */
	public static String[][] modeleIntersection = {
		{"roof", "roof", "roof", "roof", "roof","roof", "roof", "roof", "roof", "roof","roof", "roof", "roof", "roof", "roof","roof", "roof", "roof", "roof", "roof"},
		{"roof", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "roof"},
		{"roof", "roof", "roof", "roof", "roof","roof", "roof", "roof", "roof", "roof","roof", "roof", "roof", "roof", "roof","roof", "roof", "roof", "roof", "roof"}
	};
	
	/**
	 * Un modele de map.
	 */
	public static String[][] modeleExit = {
		{"roof", "roof", "roof", "roof", "roof","roof", "roof", "roof", "roof", "roof","roof", "roof", "roof", "roof", "roof","roof", "roof", "roof", "roof", "roof"},
		{"roof", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "roof"},
		{"roof", "roof", "roof", "roof", "roof","roof", "roof", "roof", "roof", "roof","roof", "roof", "roof", "roof", "roof","roof", "roof", "roof", "roof", "roof"}
	};
	
	/**
	 * Un modele de map.
	 */
	public static String[][] modeleBegin = {
		{"roof", "roof", "roof", "roof", "roof","roof", "roof", "roof", "roof", "roof","roof", "roof", "roof", "roof", "roof","roof", "roof", "roof", "roof", "roof"},
		{"roof", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "timber", "timber", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "timber", "timber", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "roof", "waterLeft", "waterCenter", "waterCenter","waterCenter", "waterCenter", "waterCenter", "waterCenter", "waterCenter","waterCenter", "waterCenter", "waterCenter", "waterCenter", "waterCenter","waterCenter", "waterCenter", "waterRight", "roof", "roof"}
	};
	
	/**
	 * Un modele de map.
	 */
	public static String[][] modeleTrap = {
		{"roof", "roof", "roof", "roof", "roof","roof", "roof", "roof", "roof", "roof","roof", "roof", "roof", "roof", "roof","roof", "roof", "roof", "roof", "roof"},
		{"roof", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "roof"},
		{"roof", "wall", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "wall", "roof"},
		{"roof", "wall", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "wall", "roof"},
		{"roof", "wall", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "wall", "roof"},
		{"roof", "wall", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "wall", "roof"},
		{"roof", "wall", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "wall", "roof"},
		{"roof", "wall", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "wall", "roof"},
		{"roof", "wall", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "wall", "roof"},
		{"roof", "wall", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "wall", "roof"},
		{"roof", "wall", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "wall", "roof"},
		{"roof", "wall", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "wall", "roof"},
		{"roof", "wall", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "wall", "roof"},
		{"roof", "wall", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "wall", "roof"},
		{"roof", "wall", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "wall", "roof"},
		{"roof", "wall", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "wall", "roof"},
		{"roof", "wall", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "wall", "roof"},
		{"roof", "wall", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "lava", "wall", "roof"},
		{"roof", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "roof"},
		{"roof", "roof", "roof", "roof", "roof","roof", "roof", "roof", "roof", "roof","roof", "roof", "roof", "roof", "roof","roof", "roof", "roof", "roof", "roof"}
	};
	
	public Map(String[][] modeleMap){
		tiles = new Tile[SIZE_MAP][SIZE_MAP];
		for(int i=0;i<SIZE_MAP;i++)
			for(int j=0; j<SIZE_MAP;j++){
				tiles[i][j]=TilesetManager.getInstance().getTile(modeleMap[i][j], new Vector2f(j*32,i*32));
			}
	}
	
	/**
	 * Affiche les �l�ments graphiques dans la fen�tre de la console.
	 * @param window : pointeur sur la fenetre de l'application.
	 */
	public void draw(RenderWindow window){
		for(int i=0;i<SIZE_MAP;i++)
			for(int j=0; j<SIZE_MAP;j++)
				tiles[j][i].draw(window);
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] map) {
		this.tiles = map;
	}
	
	
}
