package map;

import management.TilesetManager;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2f;

public class Map {
	private Tile[][] map;
	private final int SIZE_MAP = 20;
	
	public static String[][] modeleIntersection = {
		{"toit", "toit", "toit", "toit", "toit","toit", "toit", "toit", "toit", "toit","toit", "toit", "toit", "toit", "toit","toit", "toit", "toit", "toit", "toit"},
		{"toit", "mur", "mur", "mur", "mur", "mur", "mur", "mur", "mur", "porteVerrouille1", "mur", "mur", "mur", "mur", "mur", "mur", "mur", "mur", "mur", "toit"},
		{"toit", "mur", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "mur", "toit"},
		{"toit", "mur", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "mur", "toit"},
		{"toit", "mur", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "mur", "toit"},
		{"toit", "mur", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "mur", "toit"},
		{"toit", "mur", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "mur", "toit"},
		{"toit", "mur", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "mur", "toit"},
		{"toit", "porteVerrouille1", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "porteVerrouille1", "toit"},
		{"toit", "mur", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "mur", "toit"},
		{"toit", "mur", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "mur", "toit"},
		{"toit", "mur", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "mur", "toit"},
		{"toit", "mur", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "mur", "toit"},
		{"toit", "mur", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "mur", "toit"},
		{"toit", "mur", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "mur", "toit"},
		{"toit", "mur", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "mur", "toit"},
		{"toit", "mur", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "mur", "toit"},
		{"toit", "mur", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "sol", "mur", "toit"},
		{"toit", "mur", "mur", "mur", "mur", "mur", "mur", "mur", "mur", "porteVerrouille1", "mur", "mur", "mur", "mur", "mur", "mur", "mur", "mur", "mur", "toit"},
		{"toit", "toit", "toit", "toit", "toit","toit", "toit", "toit", "toit", "toit","toit", "toit", "toit", "toit", "toit","toit", "toit", "toit", "toit", "toit"}
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
	public void render(RenderWindow window){
		for(int i=0;i<SIZE_MAP;i++)
			for(int j=0; j<SIZE_MAP;j++)
				map[j][i].render(window);
	}
}
