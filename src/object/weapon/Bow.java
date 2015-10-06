package object.weapon;

import management.TilesetManager;

/**
 * 
 *This class represent the arm :bow.
 * @author Ludov_000
 *
 */
public class Bow extends Weapon {

	public Bow() {
		super(TilesetManager.getInstance().getSprite("bow"), "bow", 2, 140, 0.75f);
		// TODO Auto-generated constructor stub
	}
	
}
