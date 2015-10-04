package object.equipment;

import management.TilesetManager;
import entitee.player.Player;

public class Clothes extends Equipment{
	
	public Clothes() {
		super(TilesetManager.getInstance().getSprite("Clothes"), 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pickUp() {
		// TODO Auto-generated method stub
		Player.getInstance().getInventory().setClothes(this);
	}

}
