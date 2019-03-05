package object.potion;

import entitee.player.Player;

/**
 * 
 *This class represent small potion.
 *It add one life point to player.
 * @author Ludov_000
 *
 */
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
