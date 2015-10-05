package object.potion;

import entitee.player.Player;

public class LargePotionLife extends PotionLife {

	public LargePotionLife() {
		super(5, "Large potion life");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pickUp() {
		// TODO Auto-generated method stub
		Player.getInstance().getInventory().addLargePotionLife(this);
	}

}
