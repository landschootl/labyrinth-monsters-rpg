package object.equipment;

import entitee.player.Player;
import management.TilesetManager;

/**
 * 
 * This class represent boot equipment.
 * they accelerate the moving speed.
 * @author Ludov_000
 *
 */
public class Boot extends Equipment {

	public Boot() {
		super(TilesetManager.getInstance().getSprite("boot"), "boot", 40);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pickUp() {
		// TODO Auto-generated method stub
		Player.getInstance().getInventory().setBoot(this);
	}

}
