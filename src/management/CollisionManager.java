package management;

import java.util.ArrayList;

import map.Tile;

import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;

import donjon.door.Door;
import entitee.player.Player;

/**
 * Class permettant de gérer les collisions dans le jeu.
 * @author Ludov_000
 *
 */
public class CollisionManager {
	
	public static boolean collisionPlayerMap(Tile[][] map){
		for(int i=0; i<map.length; i++)
			for(int j=0; j<map[i].length; j++)
				if(collisionSpriteSprite(map[i][j].getSprite(), Player.getInstance().getSprite()) && map[i][j].isChecked())
					return true;
		return false;
	}

	public static Door collisionPlayerDoors(ArrayList<Door> doors) {
		// TODO Auto-generated method stub
		Vector2f position = Player.getInstance().getPosition();
		for(int i=0; i<doors.size(); i++){
			Vector2f position2 = doors.get(i).getPosition();
			if(position.x>position2.x-10 && position.x+32<position2.x+42 && position.y>position2.y-10 && position.y+32<position2.y+42)
				return doors.get(i);
		}
		return null;
	}

	public static boolean collisionMonsterPlayer(Sprite monster, Sprite player){
		return false;
	}
	
	public static boolean collisionSpriteSprite(Sprite sprite, Sprite sprite2){
		return sprite.getGlobalBounds().intersection(sprite2.getGlobalBounds()) != null;
	}
}
