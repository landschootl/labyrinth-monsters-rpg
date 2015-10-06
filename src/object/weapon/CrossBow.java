package object.weapon;

import management.TilesetManager;

/**
 * Classe qui represente l'arme CrossBow.
 * @author Ludov_000
 *
 */
public class CrossBow extends Weapon {

	public CrossBow() {
		super(TilesetManager.getInstance().getSprite("crossbow"), "crossBow", 3, 150, 0.60f);
		// TODO Auto-generated constructor stub
	}
	
}