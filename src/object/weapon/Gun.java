package object.weapon;

import management.TilesetManager;

/**
 * 
 *This class represent the arm :Gun.
 * @author Ludov_000
 *
 */
public class Gun extends Weapon {

	public Gun() {
		super(TilesetManager.getInstance().getSprite("gun"), "gun", 5, 180, 0.45f);
		// TODO Auto-generated constructor stub
	}
	
}