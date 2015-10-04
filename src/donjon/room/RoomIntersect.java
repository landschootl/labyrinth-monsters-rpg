package donjon.room;

import java.util.ArrayList;

import map.Map;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Time;

import entitee.monster.Monster;
import entitee.player.Player;

public class RoomIntersect extends Room {
	private ArrayList<Monster> monsters = new ArrayList<>();
	
	public RoomIntersect(){
		super.map = new Map(Map.modeleIntersection);
	}
	
	public void addMonster(Monster monster){
		monsters.add(monster);
	}
	
	public void update(Player player, Time time){
		for(Monster monster : monsters)
			monster.update(player.getPosition(), time);
	}
	
	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 */
	public void draw(RenderWindow window) {
		super.draw(window);
		for(Monster monster : monsters)
			monster.draw(window);
	}
	
}
