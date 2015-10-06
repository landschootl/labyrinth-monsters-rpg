package object.equipment;

import entitee.player.Player;
import management.TilesetManager;

/**
 * Classe qui repr�sente l'equipement Boot.
 * Elle acc�l�re la vitesse de d�placement du joueur.
 * @author Ludov_000
 *
 */
public class Boot extends Equipment {

	public Boot() {
		super(TilesetManager.getInstance().getSprite("boot"), "boot", 20);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pickUp() {
		// TODO Auto-generated method stub
		Player.getInstance().getInventory().setBoot(this);
	}

}
