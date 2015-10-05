package donjon.room;

import java.util.ArrayList;

import management.CollisionManager;
import map.Map;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Time;

import console.Console;
import entitee.monster.Monster;
import entitee.player.Player;

public class RoomIntersect extends Room {
	private ArrayList<Monster> monsters = new ArrayList<>();
	
	public RoomIntersect(){
		super(Map.modeleIntersection);
	}
	
	public void addMonster(Monster monster){
		monsters.add(monster);
	}
	
	public void update(Time time){
		super.update(time);
		for(int i=0; i<monsters.size(); i++){
			Monster monster = monsters.get(i);
			monster.update(Player.getInstance().getPosition(), time);
			if(monster.isDead()){
				Console.getInstance().addText(monster.getName()+" est mort !", Text.REGULAR, Color.CYAN);
				monsters.remove(monster);
			}
		}
		CollisionManager.collisionMunitionsMap(this.map.getMap());
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
