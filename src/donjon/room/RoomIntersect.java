package donjon.room;

import map.Map;

/**
 * Classe qui repr�sente la salle de transition entre les diff�rentes salles du labyrinthe.
 * @author Ludov_000
 *
 */
public class RoomIntersect extends RoomInteractif {
	
	public RoomIntersect(){
		super(Map.modeleIntersection);
	}
	
}
