package object.potion;

import entitee.player.Player;

/**
 * Classe qui repr�sente une moyenne potion de vie.
 * Elle redonne 3 point de vie � l'utilisateur.
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
