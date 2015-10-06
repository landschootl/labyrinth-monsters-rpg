package object.potion;

import entitee.player.Player;

/**
 * Classe qui repr�sente une large potion de vie.
 * Elle redonne 5 point de vie � l'utilisateur.
 * @author Ludov_000
 *
 */
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
