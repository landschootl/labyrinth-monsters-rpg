package object.weapon;

import management.TilesetManager;

public class BeginnerBow extends Weapon {

	public BeginnerBow() {
		super(TilesetManager.getInstance().getSprite("beginnerBow"), "beginner bow", 1, 120, 1.0f);
		// TODO Auto-generated constructor stub
	}
	
}
