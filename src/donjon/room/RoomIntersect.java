package donjon.room;

import map.Map;

/**
 * Classe qui reprèsente la salle de transition entre les différentes salles du labyrinthe.
 * @author Ludov_000
 *
 */
public class RoomIntersect extends RoomInteractif {
	
	public RoomIntersect(){
		super(Map.modeleIntersection);
	}
	
}
