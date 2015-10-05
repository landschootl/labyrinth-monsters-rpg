package object.weapon;

import management.TilesetManager;

public class CrossBow extends Weapon {

	public CrossBow() {
		super(TilesetManager.getInstance().getSprite("crossBow"), "crossBow", 3, 150, 0.60f);
		// TODO Auto-generated constructor stub
	}
	
}