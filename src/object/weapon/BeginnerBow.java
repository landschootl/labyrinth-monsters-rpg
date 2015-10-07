package object.weapon;

import management.TilesetManager;

/**
 * 
 *This class represent the starting gun.
 * @author Ludov_000
 *
 */
public class BeginnerBow extends Weapon {

	public BeginnerBow() {
		super(TilesetManager.getInstance().getSprite("beginnerBow"), "beginner bow", 1, 150, 1f);
		// TODO Auto-generated constructor stub
	}
	
}
