package object.potion;

import entitee.player.Player;

public class MediumPotionLife extends PotionLife {

	public MediumPotionLife() {
		super(3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pickUp() {
		// TODO Auto-generated method stub
		Player.getInstance().getInventory().addMediumPotionLife(this);
	}

}
