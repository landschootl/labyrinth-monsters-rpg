package donjon.room;

import java.util.ArrayList;

import map.Map;

import org.jsfml.graphics.RenderWindow;

import donjon.door.Door;

public class RoomIntersect extends Room {
	
	public RoomIntersect(){
		super.map = new Map(Map.modeleIntersection);
	}
	
	/**
	 * Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	 */
	public void draw(RenderWindow window) {
		super.draw(window);
	}
	
}
