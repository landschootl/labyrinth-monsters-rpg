package object.equipment;

import management.TilesetManager;
import entitee.player.Player;

/**
 * 
 *This class represent glove equipment.
 *It add one life point to player.
 * @author Ludov_000
 *
 */
public class Glove extends Equipment{
	
	public Glove() {
		super(TilesetManager.getInstance().getSprite("glove"), "glove", 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pickUp() {
		// TODO Auto-generated method stub
		Player.getInstance().getInventory().setGlove(this);
	}

}
