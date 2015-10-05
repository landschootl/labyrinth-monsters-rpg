package object.potion;

import entitee.player.Player;

public class SmallPotionLife extends PotionLife {

	public SmallPotionLife() {
		super(1, "small potion life");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pickUp() {
		// TODO Auto-generated method stub
		Player.getInstance().getInventory().addSmallPotionLife(this);
	}

}
