package management;

import org.jsfml.system.Vector2f;

/**
 * Class permettant de gérer les collisions dans le jeu.
 * @author Ludov_000
 *
 */
public class CollisionManager {
	
	public static boolean collisionPlayerWall(Vector2f posPlayer){
		return posPlayer.x<64 || posPlayer.x+32>576 || posPlayer.y<64 || posPlayer.y+32>576;
	}
	
}
