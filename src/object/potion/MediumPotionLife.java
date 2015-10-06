package object.potion;

import entitee.player.Player;

/**
 * 
 *This class represent medium potion.
 *It add three life point to player.
 * @author Ludov_000
 *
 */
public class MediumPotionLife extends PotionLife {

	public MediumPotionLife() {
		super(3, "medium potion life");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pickUp() {
		// TODO Auto-generated method stub
		Player.getInstance().getInventory().addMediumPotionLife(this);
	}

}
