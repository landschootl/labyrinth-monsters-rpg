package management;

import java.util.ArrayList;

import map.Tile;
import object.Object;
import object.weapon.Munition;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Text;
import org.jsfml.system.Clock;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;

import console.Console;
import donjon.door.Door;
import donjon.room.Room;
import donjon.room.RoomInteractif;
import entitee.monster.Monster;
import entitee.player.Player;

/**
 * This class enable to manage the collisions during the game.
 * @author Ludov_000
 *
 */
public class CollisionManager {
	
	/**
	 * Manage the collision between the player and the map in the current romm.
	 * @param room : current room.
	 * @param time : timer for frames manage.
	 */
	public static void collisionPlayerMap(Room room, Time time) {
		// TODO Auto-generated method stub
		Vector2f lastPosition = Player.getInstance().getPosition();
		Player.getInstance().move(time);
		if(collisionRectTiles(room.getMap().getTiles(),Player.getInstance().getSprite().getGlobalBounds()))
			Player.getInstance().setPosition(lastPosition);
	}
	
	/**
	 * manage the collision between the player bullets and the map.
	 * @param map : map to manage.
	 */
	public static void collisionMunitionsMap(Tile[][] map){
		for(int i=0; i<Player.getInstance().getMunitions().size(); i++){
			Munition munition = Player.getInstance().getMunitions().get(i);
			if(collisionRectTiles(map, munition.getShape().getGlobalBounds())){
				Player.getInstance().getMunitions().remove(munition);
			}
		}
	}
	
	/**
	 * manage the collision between a rectangle and a tiles of a array of a map.
	 * @param map : the map which possesses the tiles array.
	 * @param rect : the rectangle.
	 * @return boolean
	 */
	public static boolean collisionRectTiles(Tile[][] map, FloatRect rect){
		for(int i=0; i<map.length; i++)
			for(int j=0; j<map[i].length; j++)
				if(!collisionRectRect(map[i][j].getSprite().getGlobalBounds(), rect) && map[i][j].isChecked())
					return true;
		return false;
	}

	/**
	 * manage the collision between a player and the doors.
	 * @param doors : the doors.
	 * @return boolean
	 */
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
	
	/**
	 * manage the collision between a monster and a bullet.
	 * @param monster : The monster.
	 */
	public static void collisionMonsterMunition(Monster monster) {
		// TODO Auto-generated method stub
		for(int i=0; i<Player.getInstance().getMunitions().size(); i++){
			Munition munition = Player.getInstance().getMunitions().get(i);
			if(!collisionRectRect(munition.getShape().getGlobalBounds(), monster.getSprite().getGlobalBounds())){
				monster.loseLife(Player.getInstance().getInventory().getDamageShootWeapon());
				Player.getInstance().getMunitions().remove(munition);
			}
		}
	}
	
	/**
	 * Manage the collision between a monster and a player.
	 * @param monster : The monster.
	 * @param time : timer for frames manage.
	 * @param timerAttack : time between two attacks.
	 * @param positionPlayer : player position.
	 */
	public static void collisionMonsterPlayer(Monster monster, Time time, Clock timerAttack, Vector2f positionPlayer) {
		// TODO Auto-generated method stub
		if(collisionSpriteSprite(monster.getSprite(), Player.getInstance().getSprite())){
			if(timerAttack.getElapsedTime().asSeconds() > 1){
				Console.getInstance().addText("Vous vous êtes touchés par un monstre !", Text.REGULAR, Color.MAGENTA);
				Player.getInstance().loseLife(monster.getDegat());
				timerAttack.restart();
			}
		} else {
			monster.move(time, positionPlayer);
		}
	}
	
	/**
	 * manage the collision between the player and the objects in the room.
	 * @param objects : objects list.
	 * @param room : room which possesses the objects.
	 */
	public static void collisionPlayerObjects(ArrayList<Object> objects, RoomInteractif room) {
		// TODO Auto-generated method stub
		for(int i=0; i<objects.size(); i++){
			if(!collisionRectRect(objects.get(i).getSprite().getGlobalBounds(), Player.getInstance().getSprite().getGlobalBounds()))
				if(Player.getInstance().isActionPickUp())
					room.pickUpObject(objects.get(i));
		}
	}
	
	/**
	 * manage the collison between two sprite.
	 * @param sprite : sprite1.
	 * @param sprite2 : sprite2.
	 * @return boolean
	 */
	public static boolean collisionSpriteSprite(Sprite sprite, Sprite sprite2){
		return sprite.getGlobalBounds().intersection(sprite2.getGlobalBounds()) != null;
	}
	
	/**
	 * manage the collision between two rectangles.
	 * @param rect : rectangle1.
	 * @param rect2 : rectangle2.
	 * @return boolean
	 */
	public static boolean collisionRectRect(FloatRect rect, FloatRect rect2){
		return rect.intersection(rect2) == null;
	}

}
