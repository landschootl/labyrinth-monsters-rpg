package object.potion;

import entitee.player.Player;

public class LargePotionLife extends PotionLife {

	public LargePotionLife() {
		super(5);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pickUp() {
		// TODO Auto-generated method stub
		Player.getInstance().getInventory().addLargePotionLife(this);
	}

}
