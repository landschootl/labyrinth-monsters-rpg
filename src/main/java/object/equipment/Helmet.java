package object.equipment;

import management.TilesetManager;
import entitee.player.Player;

/**
 * 
 *This class represent helmet equipment.
 *It add one life point to player.
 * @author Ludov_000
 *
 */
public class Helmet extends Equipment{
	
	public Helmet() {
		super(TilesetManager.getInstance().getSprite("helmet"), "helmet", 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pickUp() {
		// TODO Auto-generated method stub
		Player.getInstance().getInventory().setHelmet(this);
	}

}