package management;

import java.util.ArrayList;

import org.jsfml.system.Vector2f;

import donjon.door.Door;

/**
 * Class permettant de gérer les collisions dans le jeu.
 * @author Ludov_000
 *
 */
public class CollisionManager {
	
	public static boolean collisionPlayerWall(Vector2f posPlayer){
		return posPlayer.x<64 || posPlayer.x+32>576 || posPlayer.y<54 || posPlayer.y+32>576;
	}

	public static Door collisionPlayerDoors(Vector2f position, ArrayList<Door> doors) {
		// TODO Auto-generated method stub
		for(int i=0; i<doors.size(); i++){
			Vector2f position2 = doors.get(i).getPosition();
			if(position.x>position2.x-10 && position.x+32<position2.x+42 && position.y>position2.y-10 && position.y+32<position2.y+42)
				return doors.get(i);
		}
		return null;
	}

	
}
