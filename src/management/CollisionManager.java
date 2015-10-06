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
 * Classe qui permet de gérer les collisions dans le jeu.
 * @author Ludov_000
 *
 */
public class CollisionManager {
	
	/**
	 * Gère la collision entre le joueur et la map dans la salle ou il se trouve.
	 * @param room : la salle ou la map se trouve.
	 * @param time : timer qui permet de gérer les frames.
	 */
	public static void collisionPlayerMap(Room room, Time time) {
		// TODO Auto-generated method stub
		Vector2f lastPosition = Player.getInstance().getPosition();
		Player.getInstance().move(time);
		if(collisionRectTiles(room.getMap().getTiles(),Player.getInstance().getSprite().getGlobalBounds()))
			Player.getInstance().setPosition(lastPosition);
	}
	
	/**
	 * Gère la collision entre les munitions du joueur et la map dans la salle ou il se trouve.
	 * @param map : la map à gérer.
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
	 * Gère la collision entre les un rectangle et un tableau de Tiles d'une map.
	 * @param map : la map qui possède le tableau de tiles.
	 * @param rect : le rectangle.
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
	 * Gère la collision entre le joueur et les portes.
	 * @param doors : les portes.
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
	 * Gère la collision entre un monstre et une munition d'un joueur.
	 * @param monster : le monstre.
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
	 * Gère la collision entre un monstre et un joueur.
	 * @param monster : le monstre.
	 * @param time : timer qui gère les frames.
	 * @param timerAttack : le temps entre deux attaques.
	 * @param positionPlayer : la position du joueur.
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
	 * Gère la collision entre le joueur et les objects présent dans une salle.
	 * @param objects : la liste des objets.
	 * @param room : la salle qui possède les objets.
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
	 * Gère la collision entre deux Sprites.
	 * @param sprite : sprite1.
	 * @param sprite2 : sprite2.
	 * @return boolean
	 */
	public static boolean collisionSpriteSprite(Sprite sprite, Sprite sprite2){
		return sprite.getGlobalBounds().intersection(sprite2.getGlobalBounds()) != null;
	}
	
	/**
	 * Gère la collision entre deux rectangles.
	 * @param rect : rectangle1.
	 * @param rect2 : rectangle2.
	 * @return boolean
	 */
	public static boolean collisionRectRect(FloatRect rect, FloatRect rect2){
		return rect.intersection(rect2) == null;
	}

}
