package object.weapon;

import management.TilesetManager;

public class Bow extends Weapon {

	public Bow() {
		super(TilesetManager.getInstance().getSprite("bow"), "bow", 2, 120, 0.75f);
		// TODO Auto-generated constructor stub
	}
	
}
