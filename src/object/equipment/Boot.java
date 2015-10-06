package object.equipment;

import entitee.player.Player;
import management.TilesetManager;

/**
 * Classe qui représente l'equipement Boot.
 * Elle accèlére la vitesse de déplacement du joueur.
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
