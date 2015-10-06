package object.potion;

import entitee.player.Player;

/**
 * Classe qui représente une petite potion de vie.
 * Elle redonne 1 point de vie à l'utilisateur.
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
