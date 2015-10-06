package object.weapon;

import management.TilesetManager;

/**
 * 
 *This class represent the arm :Crossbow.
 * @author Ludov_000
 *
 */
public class CrossBow extends Weapon {

	public CrossBow() {
		super(TilesetManager.getInstance().getSprite("crossbow"), "crossBow", 3, 150, 0.60f);
		// TODO Auto-generated constructor stub
	}
	
}