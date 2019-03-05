package object.equipment;

import management.TilesetManager;
import entitee.player.Player;

/**
 * This class represent clothes equipment.
 * It add one life point to player.
 * @author Ludov_000
 *
 */
public class Clothes extends Equipment{
	
	public Clothes() {
		super(TilesetManager.getInstance().getSprite("clothes"), "clothes", 2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pickUp() {
		// TODO Auto-generated method stub
		Player.getInstance().getInventory().setClothes(this);
	}

}
