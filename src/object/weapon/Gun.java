package object.weapon;

import management.TilesetManager;

public class Gun extends Weapon {

	public Gun() {
		super(TilesetManager.getInstance().getSprite("gun"), "gun", 5, 180, 0.45f);
		// TODO Auto-generated constructor stub
	}
	
}