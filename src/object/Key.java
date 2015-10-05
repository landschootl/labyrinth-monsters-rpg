package object;

import entitee.player.Player;
import management.TilesetManager;

public class Key extends Object{

	public Key() {
		super(TilesetManager.getInstance().getSprite("key"), "key");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pickUp() {
		// TODO Auto-generated method stub
		Player.getInstance().getInventory().addKey(this);
	}

}
