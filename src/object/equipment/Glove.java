package object.equipment;

import management.TilesetManager;
import entitee.player.Player;

public class Glove extends Equipment{
	
	public Glove() {
		super(TilesetManager.getInstance().getSprite("Glove"), 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pickUp() {
		// TODO Auto-generated method stub
		Player.getInstance().getInventory().setGlove(this);
	}

}
