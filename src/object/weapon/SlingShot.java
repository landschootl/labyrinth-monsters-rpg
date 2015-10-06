package object.weapon;

import management.TilesetManager;

/**
 * Classe qui represente l'arme SlingShot.
 * @author Ludov_000
 *
 */
public class SlingShot extends Weapon {

	public SlingShot() {
		super(TilesetManager.getInstance().getSprite("slingShot"), "slingShot", 1, 130, 1.0f);
		// TODO Auto-generated constructor stub
	}
	
}