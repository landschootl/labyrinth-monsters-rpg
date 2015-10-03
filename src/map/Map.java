package map;

import management.TilesetManager;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2f;

public class Map {
	private Tile[][] map;
	private final int SIZE_MAP = 20;
	
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
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "wall", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "timber", "timber", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "wall", "roof"},
		{"roof", "roof", "waterLeft", "waterCenter", "waterCenter","waterCenter", "waterCenter", "waterCenter", "waterCenter", "timber","timber", "waterCenter", "waterCenter", "waterCenter", "waterCenter","waterCenter", "waterCenter", "waterRight", "wall", "roof"}
	};
	
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
		map = new Tile[SIZE_MAP][SIZE_MAP];
		for(int i=0;i<SIZE_MAP;i++)
			for(int j=0; j<SIZE_MAP;j++){
				map[i][j]=TilesetManager.getInstance().getTile(modeleMap[i][j], new Vector2f(j*32,i*32));
			}
	}
	
	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 * @param window : La fenetre sur laquel on souhaite afficher les éléments.
	 */
	public void draw(RenderWindow window){
		for(int i=0;i<SIZE_MAP;i++)
			for(int j=0; j<SIZE_MAP;j++)
				map[j][i].draw(window);
	}

	public Tile[][] getMap() {
		return map;
	}

	public void setMap(Tile[][] map) {
		this.map = map;
	}
	
	
}
