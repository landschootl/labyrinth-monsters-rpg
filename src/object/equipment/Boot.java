package object.equipment;

import entitee.player.Player;
import management.TilesetManager;

public class Boot extends Equipment {

	public Boot() {
		super(TilesetManager.getInstance().getSprite("Boot"), 20);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pickUp() {
		// TODO Auto-generated method stub
		Player.getInstance().getInventory().setBoot(this);
	}

}
