package object.weapon;

import management.TilesetManager;

public class SlingShot extends Weapon {

	public SlingShot() {
		super(TilesetManager.getInstance().getSprite("slingShot"), "slingShot", 1, 125, 1.0f);
		// TODO Auto-generated constructor stub
	}
	
}