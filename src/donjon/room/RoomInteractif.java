package donjon.room;

import java.util.ArrayList;

import management.CollisionManager;
import object.Key;
import object.Object;
import object.equipment.Boot;
import object.equipment.Clothes;
import object.equipment.Glove;
import object.equipment.Helmet;
import object.equipment.Shield;
import object.potion.LargePotionLife;
import object.potion.MediumPotionLife;
import object.potion.SmallPotionLife;
import object.weapon.BeginnerBow;
import object.weapon.Bow;
import object.weapon.CrossBow;
import object.weapon.Gun;
import object.weapon.SlingShot;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;

import console.Console;
import entitee.monster.Monster;
import entitee.player.Player;

/**
 * Class which represent a room where we can play.
 * @author Ludov_000
 *
 */
public class RoomInteractif extends Room {
	private ArrayList<Monster> monsters = new ArrayList<>();
	private ArrayList<Object> objects = new ArrayList<>();
	
	public RoomInteractif(String[][] modeleMap) {
		super(modeleMap);
		// TODO Auto-generated constructor stub
	}
	
	public void addMonster(Monster monster){
		monsters.add(monster);
	}
	
	public void removeMonster(Monster monster){
		addObject(monster.getPosition());
		Console.getInstance().addText(monster.getName()+" est mort !", Text.REGULAR, new Color(96,65, 65));
		monsters.remove(monster);
	}
	
	public void addObject(Vector2f posObject){
		int alea = (int) (Math.random()*100);
		Object object = null;
		if(alea<10)
			object = new Key();
		else if(alea>=10&&alea<20)
			object = new SmallPotionLife();
		else if(alea>=20&&alea<27)
			object = new MediumPotionLife();
		else if(alea>=27&&alea<31)
			object = new LargePotionLife();
		else if(alea>=31&&alea<35)
			object = new Shield();
		else if(alea>=35&&alea<40)
			object = new Helmet();
		else if(alea>=40&&alea<45)
			object = new Boot();
		else if(alea>=45&&alea<50)
			object = new Clothes();
		else if(alea>=50&&alea<55)
			object = new Glove();
		else if(alea>=55&&alea<60)
			object = new BeginnerBow();
		else if(alea>=60&&alea<65)
			object = new Bow();
		else if(alea>=65&&alea<70)
			object = new CrossBow();
		else if(alea>=70&&alea<75)
			object = new Gun();
		else if(alea>=75&&alea<80)
			object = new SlingShot();
		if(alea<80){
			object.setPosition(posObject);
			objects.add(object);
		}
	}
	
	public void pickUpObject(Object object){
		object.pickUp();
		Console.getInstance().addText(object.getName()+" ramassé !", Text.REGULAR, Color.BLUE);
		objects.remove(object);
	}
	
	public void update(Time time){
		super.update(time);
		for(int i=0; i<monsters.size(); i++){
			Monster monster = monsters.get(i);
			monster.update(Player.getInstance().getPosition(), time);
			if(monster.isDead()){
				removeMonster(monster);
			}
		}
		CollisionManager.collisionMunitionsMap(this.map.getTiles());
		CollisionManager.collisionPlayerObjects(this.objects, this);
	}
	
	/**
	 * Function which enable to show the graphic in the window.
	 */
	public void draw(RenderWindow window) {
		super.draw(window);
		for(Object object : objects)
			object.drawWithName(window);
		for(Monster monster : monsters)
			monster.draw(window);
	}
	
	public ArrayList<Monster> getMonsters(){
		return monsters;
	}
	
	public ArrayList<Object> getObjects(){
		return objects;
	}

}
